package com.lynch.ms.bomms.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CustomerMsApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerMsApplication.class, args);
  }
}
