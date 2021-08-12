package com.ksmart.pms.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserDTO {
    /**
     * 主键
     */
    private String id;

    /**
     * 用户编码
     */
    private String code;

        /**
         * 登录账号
         */
        private String userName;

        /**
         * 密码
         */
        private String password;

        /**
         * 用户昵称，中文称呼
         */
        private String userAlias;

        /**
         * 真实名字
         */
        private String realName;

        /**
         * 省份证号（加密脱敏）
         */
        private String idCard;

        /**
         * 手机
         */
        private String cellphone;

        /**
         * 邮箱地址
         */
        private String email;

        /**
         * 组织机构id路径
         */
        private String orgPathId;

        /**
         * 组织机构名称路径
         */
        private String orgPathName;

        /**
         * 住址
         */
        private String address;

        /**
         * 固定电话
         */
        private String telphone;

        /**
         * 性别 0 未知 1 女 2 男
         */
        private Integer sex;

        /**
         * 出生日期
         */
        private Date birthday;

        /**
         * 状态:0 初始化中 1 正常 2 锁定 3过期 4 注销 5 删除
         */
        private Integer status;

        /**
         * 个性描述
         */
        private String comment;

        /**
         * 头像路径
         */
        private String profilePhoto;

        /**
         * 过期时间
         */
        private Date expireTime;

        /**
         * 解锁时间
         */
        private Date unlockTime;

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
