package com.priyam.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixBoilerPlateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixBoilerPlateApplication.class, args);
	}
}
