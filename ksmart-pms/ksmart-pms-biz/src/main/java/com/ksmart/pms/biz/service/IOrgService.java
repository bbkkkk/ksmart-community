package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.OrgDTO;
import com.ksmart.pms.biz.domain.Org;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IOrgService {

    int insert(OrgDTO orgDTO);

    int update(OrgDTO orgDTO);

    int delete(String id);

    OrgDTO get(String id);

    List<OrgDTO> query(String input);

    PageData<Org> queryPage(PageDTO pageDTO);

}
