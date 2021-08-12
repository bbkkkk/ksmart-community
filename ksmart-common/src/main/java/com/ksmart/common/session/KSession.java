package com.ksmart.common.session;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class KSession {
    private String sessionId;
    private String token;
    private String userId;
    private String code;
    private String userName;
    private String userAlias;
    private Integer userType;
    private Integer channel;
    private Timestamp createTime;
    private Timestamp lastRenewal;
    private String loginIp;
    private String loginUseAgent;
    private String loginSystem;
    private String browserName;
}
