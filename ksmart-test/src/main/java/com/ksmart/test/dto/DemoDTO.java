package com.ksmart.test.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DemoDTO {

    //主键 varchar(34)
    private String id;

    //姓名 varchar(255)
    private String name;

    //0 男  1 女 tinyint
    private int sex;

    //生日 varchar(255)
    private String birthday;

    //省份证号 varchar(255)
    private String idnumber;

    //电话 varchar(255)
    private String phone;

    //邮箱 varchar(255)
    private String email;

    //地址 varchar(255)
    private String address;

    //测试驼峰 varchar(255)
    private String testUserDemo;

}
