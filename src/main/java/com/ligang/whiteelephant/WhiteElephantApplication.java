package com.ligang.whiteelephant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "com.ligang")
public class WhiteElephantApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhiteElephantApplication.class, args);
    }

}
