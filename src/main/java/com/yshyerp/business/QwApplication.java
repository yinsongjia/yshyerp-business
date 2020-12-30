package com.yshyerp.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yshyerp.business.mapper")
@SpringBootApplication
public class QwApplication {

    public static void main(String[] args) {
        SpringApplication.run(QwApplication.class, args);
    }

}
