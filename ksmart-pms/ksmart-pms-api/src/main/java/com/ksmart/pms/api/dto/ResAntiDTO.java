package com.ksmart.pms.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ResAntiDTO {
    /**
     * 主键
     */
    private String id;

    /**
     * 左侧资源id
     */
    private String resLid;

        /**
         * 左侧资源名称
         */
        private String resLname;

        /**
         * 右侧资源id
         */
        private String resRid;

    /**
     * 右侧资源名称
         */
        private String resRname;

        /**
         * 应用编码
         */
        private String appCode;

}
