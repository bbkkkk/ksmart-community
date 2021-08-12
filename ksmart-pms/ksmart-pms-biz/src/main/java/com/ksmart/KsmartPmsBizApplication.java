package com.ksmart;

import com.ksmart.framework.dds.DynamicDataSourceRegister;
import com.yomahub.tlog.core.enhance.bytes.AspectLogEnhance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(DynamicDataSourceRegister.class)
@SpringBootApplication
public class KsmartPmsBizApplication {
    static {
        AspectLogEnhance.enhance();
    }

    public static void main(String[] args) {
        SpringApplication.run(KsmartPmsBizApplication.class, args);
    }

}
