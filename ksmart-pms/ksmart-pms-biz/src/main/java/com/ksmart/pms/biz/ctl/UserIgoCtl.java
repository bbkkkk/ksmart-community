package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.UserIgoDTO;
import com.ksmart.pms.api.fegin.UserIgoFegin;
import com.ksmart.pms.biz.domain.UserIgo;
import com.ksmart.pms.biz.service.impl.UserIgoService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户与省份组织组关系")
@RestController
@Log4j2
public class UserIgoCtl implements UserIgoFegin {

    @Autowired
    UserIgoService userIgoService;

    @Override
    public ResultData<String> insert(UserIgoDTO userIgoDTO) {
        userIgoService.insert(userIgoDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        userIgoService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(UserIgoDTO userIgoDTO) {
        userIgoService.update(userIgoDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<UserIgoDTO> get(String id) {
        UserIgoDTO userIgoDTO = userIgoService.get(id);
        return ResultData.success(userIgoDTO, "ok");
    }

    @Override
    public ResultData<List<UserIgoDTO>> query(String input) {
        return ResultData.success(userIgoService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<UserIgoDTO>> queryPage(PageDTO pageDTO) {
        PageData<UserIgo> pageData = userIgoService.queryPage(pageDTO);
        List<UserIgoDTO> userIgoDTOList = new ArrayList<>();
        List<UserIgo> userIgoList = pageData.getPageContent();
        UserIgoDTO userIgoDTO;
        for (int i = 0; i < userIgoList.size(); i++) {
            userIgoDTO = new UserIgoDTO();
            BeanUtils.copyProperties(userIgoList.get(i), userIgoDTO);
            userIgoDTOList.add(userIgoDTO);
        }
        PageData<UserIgoDTO> userIgoDTOPageData = PageData.<UserIgoDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), userIgoDTOList);
        return ResultData.success(userIgoDTOPageData, "ok");
    }
}
