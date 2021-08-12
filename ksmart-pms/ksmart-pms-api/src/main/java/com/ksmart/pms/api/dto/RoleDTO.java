package com.ksmart.pms.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class RoleDTO {
    /**
     * 主键
     */
    private String id;

    /**
     * 父id
     */
    private String pid;

        /**
         * 应用编码
         */
        private String appCode;

        /**
         * 名称
         */
        private String name;

        /**
         * 类型 0 标准角色 1 顶级角色
         */
        private Integer type;

        /**
         * 状态 0 正常 1 过期 2 禁用
         */
        private Integer status;

        /**
         * 是否临时角色 0 否 1是
         */
        private Integer isTemp;

        /**
         * 角色过期时间
         */
        private Date expireTime;

        /**
         * 创建时间
         */
        private Date createTime;

        /**
         * 创建人id
         */
        private String createUserId;

    /**
     * 最后修改时间
         */
        private Date modifyTime;

    /**
     * 最后修改人id
     */
    private String modifyUserId;

}
