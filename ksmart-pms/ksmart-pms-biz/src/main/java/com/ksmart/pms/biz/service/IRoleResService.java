package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.RoleResDTO;
import com.ksmart.pms.biz.domain.RoleRes;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IRoleResService {

    int insert(RoleResDTO roleResDTO);

    int update(RoleResDTO roleResDTO);

    int delete(String id);

    RoleResDTO get(String id);

    List<RoleResDTO> query(String input);

    PageData<RoleRes> queryPage(PageDTO pageDTO);

}
