package com.ksmart.pms.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class GroupDTO {
    /**
     * 主键
     */
    private String id;

    /**
     * 父id
     */
    private String pid;

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
         * 别名
         */
        private String alias;

        /**
         * 类型 0 标准分组 1 临时分组
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
