package com.ksmart.framework.dds;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(-100)
@Log4j2
public class DynamicDataSourceAspect {
    @Around("execution(public * com.ksmart.*.*.service..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        log.debug("切面处理sevice中的数据源转换");
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        //优先按注解设置处理数据源切换
        if (targetMethod.isAnnotationPresent(DDS.class)) {
            String targetDataSource = targetMethod.getAnnotation(DDS.class).value();
            DynamicDataSourceContextHolder.setDataSourceRouterKey(targetDataSource);
        }else{//如果未设计切换，那么采用 service中方法名称前缀为 query,find,get,select 的方法均默认走只读数据源 规则
            String methodName=targetMethod.getName().toLowerCase();
            if(methodName.startsWith("query")
                    ||methodName.startsWith("find")
                    ||methodName.startsWith("get")
                    ||methodName.startsWith("select")){
                DynamicDataSourceContextHolder.setDataSourceRouterKey("slave1");
            }
        }
        Object result = pjp.proceed();//执行方法
        DynamicDataSourceContextHolder.removeDataSourceRouterKey();
        return result;
    }
}