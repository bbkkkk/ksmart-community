package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.IdentityDTO;
import com.ksmart.pms.api.fegin.IdentityFegin;
import com.ksmart.pms.biz.domain.Identity;
import com.ksmart.pms.biz.service.impl.IdentityService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户身份")
@RestController
@Log4j2
public class IdentityCtl implements IdentityFegin {

    @Autowired
    IdentityService identityService;

    @Override
    public ResultData<String> insert(IdentityDTO identityDTO) {
        identityService.insert(identityDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        identityService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(IdentityDTO identityDTO) {
        identityService.update(identityDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<IdentityDTO> get(String id) {
        IdentityDTO identityDTO = identityService.get(id);
        return ResultData.success(identityDTO, "ok");
    }

    @Override
    public ResultData<List<IdentityDTO>> query(String input) {
        return ResultData.success(identityService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<IdentityDTO>> queryPage(PageDTO pageDTO) {
        PageData<Identity> pageData = identityService.queryPage(pageDTO);
        List<IdentityDTO> identityDTOList = new ArrayList<>();
        List<Identity> identityList = pageData.getPageContent();
        IdentityDTO identityDTO;
        for (int i = 0; i < identityList.size(); i++) {
            identityDTO = new IdentityDTO();
            BeanUtils.copyProperties(identityList.get(i), identityDTO);
            identityDTOList.add(identityDTO);
        }
        PageData<IdentityDTO> identityDTOPageData = PageData.<IdentityDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), identityDTOList);
        return ResultData.success(identityDTOPageData, "ok");
    }
}
