package com.ksmart.pms.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ResDTO {
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
         * 编码
         */
        private String code;

        /**
         * 父编码
         */
        private String pcode;

        /**
         * 名称
         */
        private String name;

        /**
         * 类型 0 菜单 1 操作（按钮、链接等用户精确请求操作）
         */
        private Integer type;

        /**
         * 状态 0 正常 1 禁用
         */
        private Integer status;

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
