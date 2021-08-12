package com.ksmart.pms.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "sys_user")
@Data
@Accessors(chain = true)
public class User {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 用户编码
     */
    @Column(name = "code")
    private String code;
    /**
     * 登录账号
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 用户昵称，中文称呼
     */
    @Column(name = "user_alias")
    private String userAlias;
    /**
     * 真实名字
     */
    @Column(name = "real_name")
    private String realName;
    /**
     * 省份证号（加密脱敏）
     */
    @Column(name = "id_card")
    private String idCard;
    /**
     * 手机
     */
    @Column(name = "cellphone")
    private String cellphone;
    /**
     * 邮箱地址
     */
    @Column(name = "email")
    private String email;
    /**
     * 组织机构id路径
     */
    @Column(name = "org_path_id")
    private String orgPathId;
    /**
     * 组织机构名称路径
     */
    @Column(name = "org_path_name")
    private String orgPathName;
    /**
     * 住址
     */
    @Column(name = "address")
    private String address;
    /**
     * 固定电话
     */
    @Column(name = "telphone")
    private String telphone;
    /**
     * 性别 0 未知 1 女 2 男
     */
    @Column(name = "sex")
    private Integer sex;
    /**
     * 出生日期
     */
    @Column(name = "birthday")
    private Date birthday;
    /**
     * 状态:0 初始化中 1 正常 2 锁定 3过期 4 注销 5 删除
     */
    @Column(name = "status")
    private Integer status;
    /**
     * 个性描述
     */
    @Column(name = "comment")
    private String comment;
    /**
     * 头像路径
     */
    @Column(name = "profile_photo")
    private String profilePhoto;
    /**
     * 过期时间
     */
    @Column(name = "expire_time")
    private Date expireTime;
    /**
     * 解锁时间
     */
    @Column(name = "unlock_time")
    private Date unlockTime;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private String createUserId;
    /**
     * 最后修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;
    /**
     * 最后修改人id
     */
    @Column(name = "modify_user_id")
    private String modifyUserId;



}
