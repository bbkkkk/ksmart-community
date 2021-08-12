package com.ksmart.pms.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "sys_org")
@Data
@Accessors(chain = true)
public class Org {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 父级id
     */
    @Column(name = "pid")
    private String pid;
    /**
     * 编码
     */
    @Column(name = "code")
    private String code;
    /**
     * 父级编码
     */
    @Column(name = "pcode")
    private String pcode;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 别名，简称
     */
    @Column(name = "alias")
    private String alias;
    /**
     * 类型 0 标准组织 1 临时组织
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
