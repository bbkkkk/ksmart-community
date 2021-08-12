package com.ksmart.demo.api.dto;

import com.ksmart.common.dto.BaseDTO;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class DemoDTO extends BaseDTO {
    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 0 男  1 女
     */
    private Integer sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 省份证号
     */
    private String idnumber;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
}
