/**
 * 
 */
package com.priyam.hystrix.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.priyam.hystrix.helper.JSONUtil;
import com.priyam.hystrix.model.Github;

/**
 * @author priyamgupta
 *
 */
@Service
public class GithubService {
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "defaultProfile", groupKey = "gitHub2", commandKey = "gitHub2")
	public Github getProfile(String username) {
		logger.info("getProfile - accessing...");
		return new RestTemplate().getForObject("https://api.github.com/users/{username}", Github.class, username);
	}

	@SuppressWarnings("unused")
	private Github defaultProfile(String username) {
		logger.info("defaultProfile - accessing...");
		return restTemplate.getForObject("https://api.github.com/users/priyamm", Github.class);
	}

}
