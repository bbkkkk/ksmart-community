package com.ksmart.demo.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.demo.api.dto.DemoDTO;
import com.ksmart.demo.biz.domain.Demo;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IDemoService {

    int insert(DemoDTO demoDTO);

    int update(DemoDTO demoDTO);

    int delete(String id);

    DemoDTO get(String id);

    List<DemoDTO> query(String input);

    PageData<Demo> queryPage(PageDTO pageDTO);

}
