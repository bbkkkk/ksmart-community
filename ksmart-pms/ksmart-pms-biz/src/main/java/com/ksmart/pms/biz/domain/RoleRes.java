package com.ksmart.pms.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "sys_role_res")
@Data
@Accessors(chain = true)
public class RoleRes {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 角色pid
     */
    @Column(name = "role_pid")
    private String rolePid;
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
     * 资源id
     */
    @Column(name = "res_id")
    private String resId;
    /**
     * 资源名称
     */
    @Column(name = "res_name")
    private String resName;
    /**
     * 应用编码
     */
    @Column(name = "app_code")
    private String appCode;



}
