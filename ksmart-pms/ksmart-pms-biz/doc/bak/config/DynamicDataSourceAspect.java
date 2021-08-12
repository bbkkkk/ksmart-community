package com.ksmart.pms.biz.config.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {
    @Around("execution(public * com.ksmart.*.*.service..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        //优先按注解设置处理数据源切换
        if (targetMethod.isAnnotationPresent(TargetDataSource.class)) {
            String targetDataSource = targetMethod.getAnnotation(TargetDataSource.class).dataSource();
            System.out.println("----------数据源是:" + targetDataSource + "------");
            DynamicDataSourceHolder.setDataSource(targetDataSource);
        }else{//如果未设计切换，那么采用 service中方法名称前缀为 query,find,get,select 的方法均默认走只读数据源 规则
            String methodName=targetMethod.getName().toLowerCase();
            if(methodName.startsWith("query")
                    ||methodName.startsWith("find")
                    ||methodName.startsWith("get")
                    ||methodName.startsWith("select")){
                DynamicDataSourceHolder.setDataSource("readDruidDataSource");
            }
        }
        Object result = pjp.proceed();//执行方法
        DynamicDataSourceHolder.clearDataSource();
        return result;
    }
}