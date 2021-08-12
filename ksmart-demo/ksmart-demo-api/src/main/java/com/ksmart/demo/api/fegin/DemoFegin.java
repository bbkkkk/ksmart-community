package com.ksmart.demo.api.fegin;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.demo.api.dto.DemoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 19:51
 * @description:
 */
@FeignClient("demo")
@RequestMapping(value = "/demo/demo/")
public interface DemoFegin {

    @PostMapping("/insert")
    ResultData<String> insert(@RequestBody DemoDTO demoDTO);

    @DeleteMapping("/delete")
    ResultData<String> delete(@RequestParam("id") String id);

    @PostMapping("/update")
    ResultData<String> update(@RequestBody DemoDTO demoDTO);

    @GetMapping("/get/{id}")
    ResultData<DemoDTO> get(@PathVariable(value = "id") String id);

    @PostMapping("/query")
    ResultData<List<DemoDTO>> query(@RequestParam(value = "input") String input);

    @PostMapping("/queryPage")
    ResultData<PageData<DemoDTO>> queryPage(@RequestBody PageDTO pageDTO);


//  @GetMapping("/listByPage")
//  ResultData<String> listByPage(@RequestParam("accountCode") String accountCode, @RequestParam("amount") BigDecimal amount);

}
