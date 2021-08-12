package com.ksmart.pms.biz.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;
 
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
 
/**
 * @Description
 * @Author lxk
 * @version V1.0.0
 */
@Configuration
public class DataSourceConfig {
    public final static String WRITE_DATASOURCE_KEY = "writeDruidDataSource";
    public final static String READ_DATASOURCE_KEY = "readDruidDataSource";
    @Primary
    @Bean(name = "writeDruidDataSource")
    @Qualifier("writeDruidDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.write")
    public DataSource writeDruidDataSource() {
        System.out.println("primary db built");
        return DataSourceBuilder.create().build();
    }
 
    @Bean(name = "readDruidDataSource")
    @Qualifier("readDruidDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.read")
    public DataSource readDruidDataSource() {
        System.out.println("secondary db built");
        return DataSourceBuilder.create().build();
    }



    /**
     * 注入AbstractRoutingDataSource
     * @param readDruidDataSource
     * @param writeDruidDataSource
     * @return
     * @throws Exception
     */
    @Bean
    public AbstractRoutingDataSource routingDataSource(
            @Qualifier(READ_DATASOURCE_KEY) DataSource readDruidDataSource,
            @Qualifier(WRITE_DATASOURCE_KEY) DataSource writeDruidDataSource
    ) throws Exception {
        DynamicDataSource dataSource = new DynamicDataSource();

        Map<Object, Object> targetDataSources = new HashMap();
        targetDataSources.put(WRITE_DATASOURCE_KEY, writeDruidDataSource);
        targetDataSources.put(READ_DATASOURCE_KEY, readDruidDataSource);
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(writeDruidDataSource);
        return dataSource;
    }
   
}