package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.UserIgoDTO;
import com.ksmart.pms.biz.domain.UserIgo;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IUserIgoService {

    int insert(UserIgoDTO userIgoDTO);

    int update(UserIgoDTO userIgoDTO);

    int delete(String id);

    UserIgoDTO get(String id);

    List<UserIgoDTO> query(String input);

    PageData<UserIgo> queryPage(PageDTO pageDTO);

}
