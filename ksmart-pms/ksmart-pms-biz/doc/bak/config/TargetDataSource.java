package com.ksmart.pms.biz.config.datasource;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface TargetDataSource {
        String dataSource() default "";//数据源
    }