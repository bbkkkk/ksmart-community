package com.ksmart;

import com.ksmart.framework.base.dao.KBaseDaoImpl;
import com.ksmart.framework.dds.DynamicDataSourceRegister;
import com.yomahub.tlog.core.enhance.bytes.AspectLogEnhance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Import(DynamicDataSourceRegister.class)
@EnableJpaRepositories(repositoryBaseClass = KBaseDaoImpl.class)
@SpringBootApplication
public class KsmartDemoBizApplication {
    static {
        AspectLogEnhance.enhance();
    }
    public static void main(String[] args) {
        SpringApplication.run(KsmartDemoBizApplication.class, args);
    }

}
