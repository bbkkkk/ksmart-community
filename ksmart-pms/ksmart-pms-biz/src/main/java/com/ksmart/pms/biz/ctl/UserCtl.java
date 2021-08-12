package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.UserDTO;
import com.ksmart.pms.api.fegin.UserFegin;
import com.ksmart.pms.biz.domain.User;
import com.ksmart.pms.biz.service.impl.UserService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户")
@RestController
@Log4j2
public class UserCtl implements UserFegin {

    @Autowired
    UserService userService;

    @Override
    public ResultData<String> insert(UserDTO userDTO) {
        userService.insert(userDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        userService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(UserDTO userDTO) {
        userService.update(userDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<UserDTO> get(String id) {
        UserDTO userDTO = userService.get(id);
        return ResultData.success(userDTO, "ok");
    }

    @Override
    public ResultData<List<UserDTO>> query(String input) {
        return ResultData.success(userService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<UserDTO>> queryPage(PageDTO pageDTO) {
        PageData<User> pageData = userService.queryPage(pageDTO);
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = pageData.getPageContent();
        UserDTO userDTO;
        for (int i = 0; i < userList.size(); i++) {
            userDTO = new UserDTO();
            BeanUtils.copyProperties(userList.get(i), userDTO);
            userDTOList.add(userDTO);
        }
        PageData<UserDTO> userDTOPageData = PageData.<UserDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), userDTOList);
        return ResultData.success(userDTOPageData, "ok");
    }
}
