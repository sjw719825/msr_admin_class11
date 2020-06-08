package com.msr.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tom
 * @version V1.0
 * @Package com.msr.edu
 * @date 2020/6/5 13:27
 * @Copyright © 株式会社多言语系统研究所
 */
// 主类或启动类
@SpringBootApplication
@MapperScan("com.msr.edu.mapper")
@ComponentScan(basePackages={"com.msr.edu","com.msr.common"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
