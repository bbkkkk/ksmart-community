package com.ksmart.framework.dds;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lxk
 * @Date: 2018/8/15 10:49
 * @Description: 数据源上下文
 */
@Log4j2
public class DynamicDataSourceContextHolder {




    /**
     * 存储已经注册的数据源的key
     */
    public static List<String> dataSourceIds = new ArrayList<>();

    /**
     * 线程级别的私有变量
     */
    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();
    public static String getDataSourceRouterKey () {
        return HOLDER.get();
    }
    public static void setDataSourceRouterKey (String dataSourceRouterKey) {
//        log.debug("切换至{}数据源", dataSourceRouterKey);
        HOLDER.set(dataSourceRouterKey);
    }

    /**
     * 设置数据源之前一定要先移除
     */
    public static void removeDataSourceRouterKey () {
        HOLDER.remove();
    }

    /**
     * 判断指定DataSrouce当前是否存在
     *
     * @param dataSourceId
     * @return
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }

}
