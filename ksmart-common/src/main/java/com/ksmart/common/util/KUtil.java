package com.ksmart.common.util;

import com.ksmart.common.dto.Condition;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class KUtil {
    /**
     * 根据package名获取模块名称
     * 平台规范为 com.ksmart开头，第三位作为模块名称，因此只需要取点号分割后的第三位即可
     * 如：
     * 渠道的包名字符串为：com.ksmart.pms.biz.config.swagger
     * 获取的模块名称为 pms
     *
     * @param packageName
     * @return
     */
    public static String getModuleNameByPackageName(String packageName) {
        log.debug("根据packageName获取模块名称:{}", packageName);
        String arr[] = packageName.split("\\.");
        if (arr.length < 2) {
            log.error("不符合ksmart平台规范的包名入参:{}", packageName);
            return null;
        } else {
            return arr[2];
        }
    }

    /**
     * 根据swagger配置类获取controller扫描包路径
     * 平台规范为 com.ksmart开头，第三位作为模块名称，第四位为biz或者api，config位于biz下，因此只需替换 config.swagger为ctl即可
     * 如：
     * 渠道的包名字符串为：com.ksmart.pms.biz.config.swagger
     * 获取的扫描包路径为 com.ksmart.pms.biz.ctl
     *
     * @param packageName
     * @return
     */
    public static String getModuleSwaggerScanBasePackageName(String packageName) {
        log.debug("根据packageName获取controller扫描路径:{}", packageName);
        packageName = packageName.replace("config", "ctl");
        return packageName;
    }

    public static String setTraceId(String logValue, String traceId) {
        //[NONE][NONE][0][8406758210781440]
        String arr[] = logValue.split("]\\[");
        arr[arr.length - 1] = traceId + "]";
        logValue = "";
        for (int i = 0; i < arr.length; i++) {
            logValue = logValue + arr[i];
            if (i < arr.length - 1) {
                logValue += "][";
            }
        }
        return logValue;
    }

    /**
     * 将分页请求中的条件对象转换为map，以便拼接条件
     * @param conditionList
     * @return
     */
    public static Map<String, Condition> pageConditionList2Map(List<Condition> conditionList) {
        Map<String, Condition> map = new HashMap<>();
        if (conditionList != null && conditionList.size() > 0) {
            Condition condition;
            for (int i = 0; i < conditionList.size(); i++) {
                condition = conditionList.get(i);
                map.put(condition.getName(), condition);
            }
        }
        return map;
    }

    public static boolean isNotNullAndBlank(Object value){
        if(value!=null&&StringUtils.isNotBlank(String.valueOf(value))){
         return true;
        }else{
            return false;
        }
    }

    public static boolean pageConditionIsNotBlank(String name,Map<String, Condition> conditionMap) {
        if (conditionMap.containsKey(name) && isNotNullAndBlank(conditionMap.get(name).getValue())) {
            return true;
        }else{
            return false;
        }

    }


    public static void main(String[] args) {
//        String packageName = "com.ksmart.pms.biz.config.swagger";
//        System.out.println(getModuleNameByPackageName(packageName));
//        System.out.println(getModuleSwaggerScanBasePackageName(packageName));
//        System.out.println("测试中文");

        String logValue = "[NONE][NONE][0][8406758210781440]";
        System.out.println(setTraceId(logValue, "test"));
    }
}
