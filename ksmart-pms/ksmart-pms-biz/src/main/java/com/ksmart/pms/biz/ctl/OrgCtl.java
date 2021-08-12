package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.OrgDTO;
import com.ksmart.pms.api.fegin.OrgFegin;
import com.ksmart.pms.biz.domain.Org;
import com.ksmart.pms.biz.service.impl.OrgService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "组织机构")
@RestController
@Log4j2
public class OrgCtl implements OrgFegin {

    @Autowired
    OrgService orgService;

    @Override
    public ResultData<String> insert(OrgDTO orgDTO) {
        orgService.insert(orgDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        orgService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(OrgDTO orgDTO) {
        orgService.update(orgDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<OrgDTO> get(String id) {
        OrgDTO orgDTO = orgService.get(id);
        return ResultData.success(orgDTO, "ok");
    }

    @Override
    public ResultData<List<OrgDTO>> query(String input) {
        return ResultData.success(orgService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<OrgDTO>> queryPage(PageDTO pageDTO) {
        PageData<Org> pageData = orgService.queryPage(pageDTO);
        List<OrgDTO> orgDTOList = new ArrayList<>();
        List<Org> orgList = pageData.getPageContent();
        OrgDTO orgDTO;
        for (int i = 0; i < orgList.size(); i++) {
            orgDTO = new OrgDTO();
            BeanUtils.copyProperties(orgList.get(i), orgDTO);
            orgDTOList.add(orgDTO);
        }
        PageData<OrgDTO> orgDTOPageData = PageData.<OrgDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), orgDTOList);
        return ResultData.success(orgDTOPageData, "ok");
    }
}
