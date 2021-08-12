package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.ResDTO;
import com.ksmart.pms.biz.domain.Res;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IResService {

    int insert(ResDTO resDTO);

    int update(ResDTO resDTO);

    int delete(String id);

    ResDTO get(String id);

    List<ResDTO> query(String input);

    PageData<Res> queryPage(PageDTO pageDTO);

}
