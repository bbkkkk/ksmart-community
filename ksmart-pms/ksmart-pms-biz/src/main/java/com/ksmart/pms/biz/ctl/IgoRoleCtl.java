package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.IgoRoleDTO;
import com.ksmart.pms.api.fegin.IgoRoleFegin;
import com.ksmart.pms.biz.domain.IgoRole;
import com.ksmart.pms.biz.service.impl.IgoRoleService;
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
public class IgoRoleCtl implements IgoRoleFegin {

    @Autowired
    IgoRoleService igoRoleService;

    @Override
    public ResultData<String> insert(IgoRoleDTO igoRoleDTO) {
        igoRoleService.insert(igoRoleDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        igoRoleService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(IgoRoleDTO igoRoleDTO) {
        igoRoleService.update(igoRoleDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<IgoRoleDTO> get(String id) {
        IgoRoleDTO igoRoleDTO = igoRoleService.get(id);
        return ResultData.success(igoRoleDTO, "ok");
    }

    @Override
    public ResultData<List<IgoRoleDTO>> query(String input) {
        return ResultData.success(igoRoleService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<IgoRoleDTO>> queryPage(PageDTO pageDTO) {
        PageData<IgoRole> pageData = igoRoleService.queryPage(pageDTO);
        List<IgoRoleDTO> igoRoleDTOList = new ArrayList<>();
        List<IgoRole> igoRoleList = pageData.getPageContent();
        IgoRoleDTO igoRoleDTO;
        for (int i = 0; i < igoRoleList.size(); i++) {
            igoRoleDTO = new IgoRoleDTO();
            BeanUtils.copyProperties(igoRoleList.get(i), igoRoleDTO);
            igoRoleDTOList.add(igoRoleDTO);
        }
        PageData<IgoRoleDTO> igoRoleDTOPageData = PageData.<IgoRoleDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), igoRoleDTOList);
        return ResultData.success(igoRoleDTOPageData, "ok");
    }
}
