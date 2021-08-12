package com.ksmart.pms.biz.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "sys_res_anti")
@Data
@Accessors(chain = true)
public class ResAnti {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 左侧资源id
     */
    @Column(name = "res_lid")
    private String resLid;
    /**
     * 左侧资源名称
     */
    @Column(name = "res_lname")
    private String resLname;
    /**
     * 右侧资源id
     */
    @Column(name = "res_rid")
    private String resRid;
    /**
     * 右侧资源名称
     */
    @Column(name = "res_rname")
    private String resRname;
    /**
     * 应用编码
     */
    @Column(name = "app_code")
    private String appCode;



}
