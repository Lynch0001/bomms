package com.lynch.ms.bomms.ackservice.orderacknowledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrderacknowledgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderacknowledgeApplication.class, args);
	}

}
