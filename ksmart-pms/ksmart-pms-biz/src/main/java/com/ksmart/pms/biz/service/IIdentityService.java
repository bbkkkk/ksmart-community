package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.IdentityDTO;
import com.ksmart.pms.biz.domain.Identity;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IIdentityService {

    int insert(IdentityDTO identityDTO);

    int update(IdentityDTO identityDTO);

    int delete(String id);

    IdentityDTO get(String id);

    List<IdentityDTO> query(String input);

    PageData<Identity> queryPage(PageDTO pageDTO);

}
