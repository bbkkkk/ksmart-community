package com.ksmart.pms.biz.config;

import com.ksmart.common.util.KUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi
public class Swagger3Config {
    @Value("${ksmart.swagger3.enable:false}")
    private boolean swaggerEnable;
    //自动根据当前类所在的包名获取模块名称
    private final String groupName= KUtil.getModuleNameByPackageName(this.getClass().getPackage().getName());
    //自动根据当前类所在的包名获取扫描controller路径
    private final String basePackage= KUtil.getModuleSwaggerScanBasePackageName(this.getClass().getPackage().getName());
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                //是否开启，根据环境配置
                .enable(swaggerEnable)
                .groupName(groupName)
                .apiInfo(apiInfo())
                .select()
                //指定扫描的包
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 页面基础信息
     */
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("PeterLee", "https://www.ksmart.com", "379266761@qq.com");
        return new ApiInfo(
                "ksmart的接口文档",
                "全网最新版本敏捷开发平台",
                "1.0",
                "https://www.ksmart.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
