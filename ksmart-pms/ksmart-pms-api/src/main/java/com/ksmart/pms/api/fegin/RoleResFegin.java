package com.ksmart.pms.api.fegin;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.RoleResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 19:51
 * @description:
 */
@FeignClient("pms")
@RequestMapping(value = "/pms/roleres/")
public interface RoleResFegin {

    @PostMapping("/insert")
    ResultData<String> insert(@RequestBody RoleResDTO roleResDTO);

    @DeleteMapping("/delete")
    ResultData<String> delete(@RequestParam("id") String id);

    @PostMapping("/update")
    ResultData<String> update(@RequestBody RoleResDTO roleResDTO);

    @GetMapping("/get/{id}")
    ResultData<RoleResDTO> get(@PathVariable(value = "id") String id);

    @PostMapping("/query")
    ResultData<List<RoleResDTO>> query(@RequestParam(value = "input") String input);

    @PostMapping("/queryPage")
    ResultData<PageData<RoleResDTO>> queryPage(@RequestBody PageDTO pageDTO);


//  @GetMapping("/listByPage")
//  ResultData<String> listByPage(@RequestParam("accountCode") String accountCode, @RequestParam("amount") BigDecimal amount);

}
