package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.IgoRoleDTO;
import com.ksmart.pms.biz.domain.IgoRole;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IIgoRoleService {

    int insert(IgoRoleDTO igoRoleDTO);

    int update(IgoRoleDTO igoRoleDTO);

    int delete(String id);

    IgoRoleDTO get(String id);

    List<IgoRoleDTO> query(String input);

    PageData<IgoRole> queryPage(PageDTO pageDTO);

}
