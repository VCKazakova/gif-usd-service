package com.kazakova.gifusdservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GifUsdServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GifUsdServiceApplication.class, args);
    }

}
