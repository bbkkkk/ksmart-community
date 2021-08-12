package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.AppDTO;
import com.ksmart.pms.biz.domain.App;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IAppService {

    int insert(AppDTO appDTO);

    int update(AppDTO appDTO);

    int delete(String id);

    AppDTO get(String id);

    List<AppDTO> query(String input);

    PageData<App> queryPage(PageDTO pageDTO);

}
