package com.ksmart.pms.api.fegin;

import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.dto.ResultData;
import com.ksmart.pms.api.dto.IgoRoleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 19:51
 * @description:
 */
@FeignClient("pms")
@RequestMapping(value = "/pms/igorole/")
public interface IgoRoleFegin {

    @PostMapping("/insert")
    ResultData<String> insert(@RequestBody IgoRoleDTO igoRoleDTO);

    @DeleteMapping("/delete")
    ResultData<String> delete(@RequestParam("id") String id);

    @PostMapping("/update")
    ResultData<String> update(@RequestBody IgoRoleDTO igoRoleDTO);

    @GetMapping("/get/{id}")
    ResultData<IgoRoleDTO> get(@PathVariable(value = "id") String id);

    @PostMapping("/query")
    ResultData<List<IgoRoleDTO>> query(@RequestParam(value = "input") String input);

    @PostMapping("/queryPage")
    ResultData<PageData<IgoRoleDTO>> queryPage(@RequestBody PageDTO pageDTO);


//  @GetMapping("/listByPage")
//  ResultData<String> listByPage(@RequestParam("accountCode") String accountCode, @RequestParam("amount") BigDecimal amount);

}
