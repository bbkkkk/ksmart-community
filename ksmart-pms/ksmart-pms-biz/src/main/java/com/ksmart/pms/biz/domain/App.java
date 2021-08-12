package com.ksmart.pms.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "sys_app")
@Data
@Accessors(chain = true)
public class App {

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
     * 编码
     */
    @Column(name = "code")
    private String code;
    /**
     * 英文名称
     */
    @Column(name = "ename")
    private String ename;
    /**
     * 中文名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 类型 0 标准系统 1 临时系统
     */
    @Column(name = "type")
    private Integer type;
    /**
     * 状态 0 正常 1 禁用
     */
    @Column(name = "status")
    private Integer status;
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
