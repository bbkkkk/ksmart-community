package com.ksmart.pms.biz.service;


import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.pms.api.dto.GroupDTO;
import com.ksmart.pms.biz.domain.Group;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:25
 * @description:
 */
public interface IGroupService {

    int insert(GroupDTO groupDTO);

    int update(GroupDTO groupDTO);

    int delete(String id);

    GroupDTO get(String id);

    List<GroupDTO> query(String input);

    PageData<Group> queryPage(PageDTO pageDTO);

}
