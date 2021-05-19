package com.course.RestApi.practical.api.server;

import java.time.LocalTime;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class DefaultRestApi {
	
	private Logger log = org.slf4j.LoggerFactory.getLogger(DefaultRestApi.class);
	
	@GetMapping(value = "/welcome")
	public String welcome() {
		log.info(StringUtils.join("Hello"," this is"," Spring Boot", " Rest Api"));
		return "Welcome to Spring Boot";
	}
	
	@GetMapping(value = "/time")
	public String time() {
		return LocalTime.now().toString();
	}
}
