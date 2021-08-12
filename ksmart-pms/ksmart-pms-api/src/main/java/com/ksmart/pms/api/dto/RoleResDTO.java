package com.ksmart.pms.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class RoleResDTO {
    /**
     * 主键
     */
    private String id;

    /**
     * 角色pid
     */
    private String rolePid;

        /**
         * 角色id
         */
        private String roleId;

    /**
     * 角色名称
         */
        private String roleName;

        /**
         * 资源id
         */
        private String resId;

    /**
     * 资源名称
         */
        private String resName;

        /**
         * 应用编码
         */
        private String appCode;

}
