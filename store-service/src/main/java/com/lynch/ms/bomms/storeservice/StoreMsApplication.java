package com.lynch.ms.bomms.storeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StoreMsApplication {

    public static void main(String[] args) {
      SpringApplication.run(StoreMsApplication.class, args);
    }
}
