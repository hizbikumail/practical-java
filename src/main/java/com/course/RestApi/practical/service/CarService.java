package com.course.RestApi.practical.service;

import java.util.List;

import com.course.RestApi.practical.entity.Car;

public interface CarService {

	List<String> BRAND = List.of("Toyota", "Honda", "Ford");
	
	List<String> COLOR = List.of("Red", "Black", "White");
	
	List<String> TYPE = List.of("Sedan", "SUV", "MPV");
	
	Car generateCar();
}
