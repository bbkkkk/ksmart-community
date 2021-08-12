package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.GroupDTO;
import com.ksmart.pms.api.fegin.GroupFegin;
import com.ksmart.pms.biz.domain.Group;
import com.ksmart.pms.biz.service.impl.GroupService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户组")
@RestController
@Log4j2
public class GroupCtl implements GroupFegin {

    @Autowired
    GroupService groupService;

    @Override
    public ResultData<String> insert(GroupDTO groupDTO) {
        groupService.insert(groupDTO);
        return ResultData.success("ok", "");
    }

    @Override
    public ResultData<String> delete(String id) {
        groupService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(GroupDTO groupDTO) {
        groupService.update(groupDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<GroupDTO> get(String id) {
        GroupDTO groupDTO = groupService.get(id);
        return ResultData.success(groupDTO, "ok");
    }

    @Override
    public ResultData<List<GroupDTO>> query(String input) {
        return ResultData.success(groupService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<GroupDTO>> queryPage(PageDTO pageDTO) {
        PageData<Group> pageData = groupService.queryPage(pageDTO);
        List<GroupDTO> groupDTOList = new ArrayList<>();
        List<Group> groupList = pageData.getPageContent();
        GroupDTO groupDTO;
        for (int i = 0; i < groupList.size(); i++) {
            groupDTO = new GroupDTO();
            BeanUtils.copyProperties(groupList.get(i), groupDTO);
            groupDTOList.add(groupDTO);
        }
        PageData<GroupDTO> groupDTOPageData = PageData.<GroupDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), groupDTOList);
        return ResultData.success(groupDTOPageData, "ok");
    }
}
