package com.ksmart.pms.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "sys_role")
@Data
@Accessors(chain = true)
public class Role {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 父id
     */
    @Column(name = "pid")
    private String pid;
    /**
     * 应用编码
     */
    @Column(name = "app_code")
    private String appCode;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 类型 0 标准角色 1 顶级角色
     */
    @Column(name = "type")
    private Integer type;
    /**
     * 状态 0 正常 1 过期 2 禁用
     */
    @Column(name = "status")
    private Integer status;
    /**
     * 是否临时角色 0 否 1是
     */
    @Column(name = "is_temp")
    private Integer isTemp;
    /**
     * 角色过期时间
     */
    @Column(name = "expire_time")
    private Date expireTime;
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
