package com.ksmart.demo.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.demo.api.dto.DemoDTO;
import com.ksmart.demo.api.fegin.DemoFegin;
import com.ksmart.demo.biz.domain.Demo;
import com.ksmart.demo.biz.service.impl.DemoService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "示例表")
@RestController
@Log4j2
public class DemoCtl implements DemoFegin {

    @Autowired
    DemoService demoService;

    @Override
    public ResultData<String> insert(DemoDTO demoDTO) {
            demoService.insert(demoDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        demoService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(DemoDTO demoDTO) {
        demoService.update(demoDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<DemoDTO> get(String id) {
        DemoDTO demoDTO = demoService.get(id);
        return ResultData.success(demoDTO, "ok");
    }

    @Override
    public ResultData<List<DemoDTO>> query(String input) {
        return ResultData.success(demoService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<DemoDTO>> queryPage(PageDTO pageDTO) {
        PageData<Demo> pageData = demoService.queryPage(pageDTO);
        List<DemoDTO> demoDTOList = new ArrayList<>();
        List<Demo> demoList = pageData.getPageContent();
        DemoDTO demoDTO;
        for (int i = 0; i < demoList.size(); i++) {
            demoDTO = new DemoDTO();
            BeanUtils.copyProperties(demoList.get(i), demoDTO);
            demoDTOList.add(demoDTO);
        }
        PageData<DemoDTO> demoDTOPageData = PageData.<DemoDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), demoDTOList);
        return ResultData.success(demoDTOPageData, "ok");
    }
}
