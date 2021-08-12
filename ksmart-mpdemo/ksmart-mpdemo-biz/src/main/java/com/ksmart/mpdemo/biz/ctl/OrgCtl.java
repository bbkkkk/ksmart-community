package com.ksmart.mpdemo.biz.ctl;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.mpdemo.biz.entity.Org;
import com.ksmart.pms.api.dto.OrgDTO;
import com.ksmart.pms.api.fegin.OrgFegin;
import com.ksmart.mpdemo.biz.service.impl.OrgService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "组织机构")
@RestController
@Log4j2
public class OrgCtl implements OrgFegin {

    @Autowired
    OrgService orgService;

    @Override
    public ResultData<String> insert(OrgDTO orgDTO) {
        Org org = new Org();
        BeanUtils.copyProperties(orgDTO, org);
        orgService.save(org);
        return ResultData.success("ok");
    }

    @Override
    public ResultData<String> delete(String id) {
        return ResultData.success("ok");

    }

    @Override
    public ResultData<String> update(OrgDTO orgDTO) {
        return ResultData.success("ok");
    }

    @Override
    public ResultData<OrgDTO> get(String id) {
        return ResultData.success(null, "ok");
    }

    @Override
    public ResultData<List<OrgDTO>> query(String input) {
        return ResultData.success(null, "ok");
    }

    @Override
    public ResultData<PageData<OrgDTO>> queryPage(PageDTO pageDTO) {
        return ResultData.success(null, "ok");
    }
}
