package com.web.onlineshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.web.onlineshop")
public class OnlineShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineShopApplication.class, args);
    }

}
