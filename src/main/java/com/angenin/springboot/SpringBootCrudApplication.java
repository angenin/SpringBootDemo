package com.angenin.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.angenin.springboot.dao")
public class SpringBootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudApplication.class, args);
    }

}
