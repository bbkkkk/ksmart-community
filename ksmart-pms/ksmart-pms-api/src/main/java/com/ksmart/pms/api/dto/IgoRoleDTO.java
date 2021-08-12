package com.ksmart.pms.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class IgoRoleDTO {
    /**
     * 主键
     */
    private String id;

    /**
     * 角色id
     */
    private String roleId;

        /**
         * 角色名称
         */
        private String roleName;

        /**
         * 身份组织组id
         */
        private String igoId;

    /**
     * 身份组织组名称
         */
        private String igoName;

        /**
         * 1 身份 2 组织 3 组
         */
        private Integer type;

        /**
         * 应用编码
         */
        private String appCode;

}
