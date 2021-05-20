package com.course.RestApi.practical.common;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.course.RestApi.practical.entity.Car;
import com.course.RestApi.practical.repository.CarElasticRepository;
import com.course.RestApi.practical.service.CarService;

@Component
public class CarElasticDatasource {

	private static Logger log = LoggerFactory.getLogger(CarElasticDatasource.class); 
	
	@Autowired
	private CarElasticRepository carRepository;

	@Autowired
	@Qualifier("randomCarService")
	private CarService carService;
	
	@Autowired
	@Qualifier("webClientElasticsearch")
	private WebClient webClient;
	
	@EventListener(ApplicationReadyEvent.class)
	public void populateData() {
		var response = webClient.delete().uri("/practical-java").retrieve().bodyToMono(String.class).block();
		log.info("End delete with response {}", response);
		
		var cars = new ArrayList<Car>();
		
		for(int i = 0; i < 1000; i++) {
			cars.add(carService.generateCar());
		}
		
		carRepository.saveAll(cars);
		log.info("Saved {} cars", carRepository.count());
	}
}
