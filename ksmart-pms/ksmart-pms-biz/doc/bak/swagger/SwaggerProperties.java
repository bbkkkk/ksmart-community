package com.ksmart.pms.biz.config.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger的属性配置类
 */
//@Component
//@ConfigurationProperties(prefix = "ksmart.swagger3")
//@Data
public class SwaggerProperties {
    private String groupName;
    private String basePackage;
    private String title;
    private String description;
    private String contactName;
    private String contactEmail;
    private String contactUrl;
    private String version;
    private Boolean enable;
}