package com.course.RestApi.practical.api.server;

import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.RestApi.practical.entity.Car;
import com.course.RestApi.practical.service.RandomCarService;

@RequestMapping(value = "/api/car/v1")
@RestController
public class CarApi {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(CarApi.class);

	@Autowired
	private RandomCarService carservice;
	
	@GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
	public Car random() {
		return carservice.generateCar();
	}
	
	@PostMapping(value = "/echo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String echo(@RequestBody Car car) {
		log.info("car is {}", car);
		
		return car.toString();
	}
	
	@GetMapping(value = "/random-car", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> randomCar(){
		var result = new ArrayList<Car>();
		
		for(int i = 0; i < ThreadLocalRandom.current().nextInt(1, 10); i++) {
			result.add(carservice.generateCar());
		}
		
		return result;
	}
	
}
