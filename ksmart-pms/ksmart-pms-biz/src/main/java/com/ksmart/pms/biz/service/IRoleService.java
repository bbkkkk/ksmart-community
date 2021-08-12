package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.RoleDTO;
import com.ksmart.pms.biz.domain.Role;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IRoleService {

    int insert(RoleDTO roleDTO);

    int update(RoleDTO roleDTO);

    int delete(String id);

    RoleDTO get(String id);

    List<RoleDTO> query(String input);

    PageData<Role> queryPage(PageDTO pageDTO);

}
