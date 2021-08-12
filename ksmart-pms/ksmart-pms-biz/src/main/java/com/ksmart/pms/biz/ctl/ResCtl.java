package com.ksmart.pms.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.ResDTO;
import com.ksmart.pms.api.fegin.ResFegin;
import com.ksmart.pms.biz.domain.Res;
import com.ksmart.pms.biz.service.impl.ResService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "权限资源")
@RestController
@Log4j2
public class ResCtl implements ResFegin {

    @Autowired
    ResService resService;

    @Override
    public ResultData<String> insert(ResDTO resDTO) {
        resService.insert(resDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        resService.delete(id);
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(ResDTO resDTO) {
        resService.update(resDTO);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<ResDTO> get(String id) {
        ResDTO resDTO = resService.get(id);
        return ResultData.success(resDTO, "ok");
    }

    @Override
    public ResultData<List<ResDTO>> query(String input) {
        return ResultData.success(resService.query("%" + input + "%"), "ok");
    }

    @Override
    public ResultData<PageData<ResDTO>> queryPage(PageDTO pageDTO) {
        PageData<Res> pageData = resService.queryPage(pageDTO);
        List<ResDTO> resDTOList = new ArrayList<>();
        List<Res> resList = pageData.getPageContent();
        ResDTO resDTO;
        for (int i = 0; i < resList.size(); i++) {
            resDTO = new ResDTO();
            BeanUtils.copyProperties(resList.get(i), resDTO);
            resDTOList.add(resDTO);
        }
        PageData<ResDTO> resDTOPageData = PageData.<ResDTO>getInstance(pageData.getCurrentPage(), pageData.getPageSize(), pageData.getTotalCount(), resDTOList);
        return ResultData.success(resDTOPageData, "ok");
    }
}
