package com.ksmart.mpdemo.biz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@TableName("sys_org")
@Data
@Accessors(chain = true)
public class Org {

    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;
    /**
     * 父级id
     */
    @TableField(value = "pid")
    private String pid;
    /**
     * 编码
     */
    @TableField(value = "code")
    private String code;
    /**
     * 父级编码
     */
    @TableField(value = "pcode")
    private String pcode;
    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 别名，简称
     */
    @TableField(value = "alias")
    private String alias;
    /**
     * 类型 0 标准组织 1 临时组织
     */
    @TableField(value = "type")
    private Integer type;
    /**
     * 状态 0 正常 1 禁用
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 创建人id
     */
    @TableField(value = "create_user_id")
    private String createUserId;
    /**
     * 最后修改时间
     */
    @TableField(value = "modify_time")
    private Date modifyTime;
    /**
     * 最后修改人id
     */
    @TableField(value = "modify_user_id")
    private String modifyUserId;


}
