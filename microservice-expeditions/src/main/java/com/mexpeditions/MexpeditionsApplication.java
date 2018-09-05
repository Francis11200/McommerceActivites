package com.mexpeditions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MexpeditionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MexpeditionsApplication.class, args);
	}
}
