package com.baomidou.mybatisplus.samples.assembly;

import com.yomahub.tlog.core.enhance.bytes.AspectLogEnhance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. cd target
 * 2. java -jar mybatis-plus-sample-assembly-0.0.1-SNAPSHOT.jar
 * 3. curl http://127.0.0.1:8080/test
 *
 * @author lxk
 */
@SpringBootApplication
public class AssemblyApplication {
    static {
        AspectLogEnhance.enhance();
    }

    public static void main(String[] args) {
        SpringApplication.run(AssemblyApplication.class, args);
    }

}
