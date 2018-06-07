/**
 * 
 */
package com.priyam.hystrix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author priyamgupta
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		System.out.println("rest template");
		return new RestTemplate();
	}
}
