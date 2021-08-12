package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.RoleResDTO;
import com.ksmart.pms.api.fegin.RoleResFegin;
import com.ksmart.pms.biz.domain.RoleRes;
import com.ksmart.pms.biz.service.impl.RoleResService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "身份组织组与角色关系")
@RestController
@Log4j2
public class RoleResCtl implements RoleResFegin {

    @Autowired
    RoleResService roleResService;

    @Override
    public ResultData<String> insert(RoleResDTO roleResDTO) {
        roleResService.insert(roleResDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        roleResService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(RoleResDTO roleResDTO) {
        roleResService.update(roleResDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<RoleResDTO> get(String id) {
        RoleResDTO roleResDTO = roleResService.get(id);
        return ResultData.success(roleResDTO, "ok");
    }

    @Override
    public ResultData<List<RoleResDTO>> query(String input) {
        return ResultData.success(roleResService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<RoleResDTO>> queryPage(PageDTO pageDTO) {
        PageData<RoleRes> pageData = roleResService.queryPage(pageDTO);
        List<RoleResDTO> roleResDTOList = new ArrayList<>();
        List<RoleRes> roleResList = pageData.getPageContent();
        RoleResDTO roleResDTO;
        for (int i = 0; i < roleResList.size(); i++) {
            roleResDTO = new RoleResDTO();
            BeanUtils.copyProperties(roleResList.get(i), roleResDTO);
            roleResDTOList.add(roleResDTO);
        }
        PageData<RoleResDTO> roleResDTOPageData = PageData.<RoleResDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), roleResDTOList);
        return ResultData.success(roleResDTOPageData, "ok");
    }
}
