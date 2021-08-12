package com.ksmart.demo.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "demo")
@Data
@Accessors(chain = true)
public class Demo {

    /**
     * 主键
     */
    @Id
    @Column(name = "c_id")
    private String id;
    /**
     * 姓名
     */
    @Column(name = "c_name")
    private String name;
    /**
     * 0 男  1 女
     */
    @Column(name = "c_sex")
    private Integer sex;
    /**
     * 生日
     */
    @Column(name = "c_birthday")
    private String birthday;
    /**
     * 省份证号
     */
    @Column(name = "c_idnumber")
    private String idnumber;
    /**
     * 电话
     */
    @Column(name = "c_phone")
    private String phone;
    /**
     * 邮箱
     */
    @Column(name = "c_email")
    private String email;
    /**
     * 地址
     */
    @Column(name = "c_address")
    private String address;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 创建人id
     */
    @Column(name = "create_uid")
    private String createUid;
    /**
     * 创建人name
     */
    @Column(name = "create_uname")
    private String createUname;
    /**
     * 最后修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;
    /**
     * 最后修改人id
     */
    @Column(name = "modify_uid")
    private String modifyUid;
    /**
     * 最后修改人name
     */
    @Column(name = "modify_uname")
    private String modifyUname;


}
