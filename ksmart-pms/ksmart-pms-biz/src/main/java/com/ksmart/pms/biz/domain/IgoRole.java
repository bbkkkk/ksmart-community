package com.ksmart.pms.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "sys_igo_role")
@Data
@Accessors(chain = true)
public class IgoRole {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 角色id
     */
    @Column(name = "role_id")
    private String roleId;
    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;
    /**
     * 身份组织组id
     */
    @Column(name = "igo_id")
    private String igoId;
    /**
     * 身份组织组名称
     */
    @Column(name = "igo_name")
    private String igoName;
    /**
     * 1 身份 2 组织 3 组
     */
    @Column(name = "type")
    private Integer type;
    /**
     * 应用编码
     */
    @Column(name = "app_code")
    private String appCode;



}
