package com.course.RestApi.practical.api.server;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.RestApi.practical.entity.Car;
import com.course.RestApi.practical.service.RandomCarService;

@RequestMapping(value = "/api/car/v1")
@RestController
public class CarApi {

	@Autowired
	private RandomCarService carservice;
	
	@GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
	public Car random() {
		return carservice.generateCar();
	}
	
}
