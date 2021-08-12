package com.ksmart.pms.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "sys_user_igo")
@Data
@Accessors(chain = true)
public class UserIgo {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 角色id
     */
    @Column(name = "user_id")
    private String userId;
    /**
     * 角色名称
     */
    @Column(name = "user_name")
    private String userName;
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
