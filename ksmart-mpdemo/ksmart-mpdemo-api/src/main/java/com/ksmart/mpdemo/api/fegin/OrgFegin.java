package com.ksmart.mpdemo.api.fegin;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.mpdemo.api.dto.OrgDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 19:51
 * @description:
 */
@FeignClient("pms")
@RequestMapping(value = "/pms/org/")
public interface OrgFegin {

    @PostMapping("/insert")
    ResultData<String> insert(@RequestBody OrgDTO orgDTO);

    @DeleteMapping("/delete")
    ResultData<String> delete(@RequestParam("id") String id);

    @PostMapping("/update")
    ResultData<String> update(@RequestBody OrgDTO orgDTO);

    @GetMapping("/get/{id}")
    ResultData<OrgDTO> get(@PathVariable(value = "id") String id);

    @PostMapping("/query")
    ResultData<List<OrgDTO>> query(@RequestParam(value = "input") String input);

    @PostMapping("/queryPage")
    ResultData<PageData<OrgDTO>> queryPage(@RequestBody PageDTO pageDTO);


//  @GetMapping("/listByPage")
//  ResultData<String> listByPage(@RequestParam("accountCode") String accountCode, @RequestParam("amount") BigDecimal amount);

}
