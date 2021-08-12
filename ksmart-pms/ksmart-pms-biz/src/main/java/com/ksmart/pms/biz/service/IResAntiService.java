package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.ResAntiDTO;
import com.ksmart.pms.biz.domain.ResAnti;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IResAntiService {

    int insert(ResAntiDTO resAntiDTO);

    int update(ResAntiDTO resAntiDTO);

    int delete(String id);

    ResAntiDTO get(String id);

    List<ResAntiDTO> query(String input);

    PageData<ResAnti> queryPage(PageDTO pageDTO);

}
