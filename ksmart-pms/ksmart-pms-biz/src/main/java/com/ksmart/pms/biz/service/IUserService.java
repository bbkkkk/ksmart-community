package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.UserDTO;
import com.ksmart.pms.biz.domain.User;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IUserService {

    int insert(UserDTO userDTO);

    int update(UserDTO userDTO);

    int delete(String id);

    UserDTO get(String id);

    List<UserDTO> query(String input);

    PageData<User> queryPage(PageDTO pageDTO);

}
