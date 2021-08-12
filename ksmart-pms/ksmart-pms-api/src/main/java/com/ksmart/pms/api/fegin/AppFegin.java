package com.ksmart.pms.api.fegin;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.AppDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 19:51
 * @description:
 */
@FeignClient("pms")
@RequestMapping(value = "/pms/app/")
public interface AppFegin {

    @PostMapping("/insert")
    ResultData<String> insert(@RequestBody AppDTO appDTO);

    @DeleteMapping("/delete")
    ResultData<String> delete(@RequestParam("id") String id);

    @PostMapping("/update")
    ResultData<String> update(@RequestBody AppDTO appDTO);

    @GetMapping("/get/{id}")
    ResultData<AppDTO> get(@PathVariable(value = "id") String id);

    @PostMapping("/query")
    ResultData<List<AppDTO>> query(@RequestParam(value = "input") String input);

    @PostMapping("/queryPage")
    ResultData<PageData<AppDTO>> queryPage(@RequestBody PageDTO pageDTO);


//  @GetMapping("/listByPage")
//  ResultData<String> listByPage(@RequestParam("accountCode") String accountCode, @RequestParam("amount") BigDecimal amount);

}
