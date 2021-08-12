package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.AppDTO;
import com.ksmart.pms.api.fegin.AppFegin;
import com.ksmart.pms.biz.domain.App;
import com.ksmart.pms.biz.service.impl.AppService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "应用")
@RestController
@Log4j2
public class AppCtl implements AppFegin {

    @Autowired
    AppService appService;

    @Override
    public ResultData<String> insert(AppDTO appDTO) {
        appService.insert(appDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        appService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(AppDTO appDTO) {
        appService.update(appDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<AppDTO> get(String id) {
        AppDTO appDTO = appService.get(id);
        return ResultData.success(appDTO, "ok");
    }

    @Override
    public ResultData<List<AppDTO>> query(String input) {
        return ResultData.success(appService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<AppDTO>> queryPage(PageDTO pageDTO) {
        PageData<App> pageData = appService.queryPage(pageDTO);
        List<AppDTO> appDTOList = new ArrayList<>();
        List<App> appList = pageData.getPageContent();
        AppDTO appDTO;
        for (int i = 0; i < appList.size(); i++) {
            appDTO = new AppDTO();
            BeanUtils.copyProperties(appList.get(i), appDTO);
            appDTOList.add(appDTO);
        }
        PageData<AppDTO> appDTOPageData = PageData.<AppDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), appDTOList);
        return ResultData.success(appDTOPageData, "ok");
    }
}
