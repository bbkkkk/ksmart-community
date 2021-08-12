package com.ksmart.framework.dds;

import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Auther: lxk
 * @Date: 2018/8/15 10:47
 * @Description: 动态数据源路由配置
 */
@Log4j2
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceContextHolder.getDataSourceRouterKey();
//        log.debug("当前数据源是：{}", dataSourceName);
        return dataSourceName;
    }
}
