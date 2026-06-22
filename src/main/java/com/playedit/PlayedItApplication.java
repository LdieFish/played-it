package com.playedit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.playedit.module.core.mapper")
public class PlayedItApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayedItApplication.class, args);
    }

}
