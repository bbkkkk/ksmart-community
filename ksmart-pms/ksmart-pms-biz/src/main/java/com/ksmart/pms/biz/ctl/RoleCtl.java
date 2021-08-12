package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.RoleDTO;
import com.ksmart.pms.api.fegin.RoleFegin;
import com.ksmart.pms.biz.domain.Role;
import com.ksmart.pms.biz.service.impl.RoleService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "系统角色")
@RestController
@Log4j2
public class RoleCtl implements RoleFegin {

    @Autowired
    RoleService roleService;

    @Override
    public ResultData<String> insert(RoleDTO roleDTO) {
        roleService.insert(roleDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        roleService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(RoleDTO roleDTO) {
        roleService.update(roleDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<RoleDTO> get(String id) {
        RoleDTO roleDTO = roleService.get(id);
        return ResultData.success(roleDTO, "ok");
    }

    @Override
    public ResultData<List<RoleDTO>> query(String input) {
        return ResultData.success(roleService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<RoleDTO>> queryPage(PageDTO pageDTO) {
        PageData<Role> pageData = roleService.queryPage(pageDTO);
        List<RoleDTO> roleDTOList = new ArrayList<>();
        List<Role> roleList = pageData.getPageContent();
        RoleDTO roleDTO;
        for (int i = 0; i < roleList.size(); i++) {
            roleDTO = new RoleDTO();
            BeanUtils.copyProperties(roleList.get(i), roleDTO);
            roleDTOList.add(roleDTO);
        }
        PageData<RoleDTO> roleDTOPageData = PageData.<RoleDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), roleDTOList);
        return ResultData.success(roleDTOPageData, "ok");
    }
}
