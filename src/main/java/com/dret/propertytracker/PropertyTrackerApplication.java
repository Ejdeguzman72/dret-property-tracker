package com.dret.propertytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class PropertyTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyTrackerApplication.class, args);
	}

}
