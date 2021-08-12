package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.ResAntiDTO;
import com.ksmart.pms.api.fegin.ResAntiFegin;
import com.ksmart.pms.biz.domain.ResAnti;
import com.ksmart.pms.biz.service.impl.ResAntiService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "互斥资源")
@RestController
@Log4j2
public class ResAntiCtl implements ResAntiFegin {

    @Autowired
    ResAntiService resAntiService;

    @Override
    public ResultData<String> insert(ResAntiDTO resAntiDTO) {
        resAntiService.insert(resAntiDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        resAntiService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(ResAntiDTO resAntiDTO) {
        resAntiService.update(resAntiDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<ResAntiDTO> get(String id) {
        ResAntiDTO resAntiDTO = resAntiService.get(id);
        return ResultData.success(resAntiDTO, "ok");
    }

    @Override
    public ResultData<List<ResAntiDTO>> query(String input) {
        return ResultData.success(resAntiService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<ResAntiDTO>> queryPage(PageDTO pageDTO) {
        PageData<ResAnti> pageData = resAntiService.queryPage(pageDTO);
        List<ResAntiDTO> resAntiDTOList = new ArrayList<>();
        List<ResAnti> resAntiList = pageData.getPageContent();
        ResAntiDTO resAntiDTO;
        for (int i = 0; i < resAntiList.size(); i++) {
            resAntiDTO = new ResAntiDTO();
            BeanUtils.copyProperties(resAntiList.get(i), resAntiDTO);
            resAntiDTOList.add(resAntiDTO);
        }
        PageData<ResAntiDTO> resAntiDTOPageData = PageData.<ResAntiDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), resAntiDTOList);
        return ResultData.success(resAntiDTOPageData, "ok");
    }
}
