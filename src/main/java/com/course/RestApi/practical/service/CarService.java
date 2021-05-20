package com.course.RestApi.practical.service;

import java.util.List;

import com.course.RestApi.practical.entity.Car;

public interface CarService {

	List<String> BRAND = List.of("Toyota", "Honda", "Ford", "BMW", "Mitsubishi");
	
	List<String> COLOR = List.of("Red", "Black", "White", "Blue", "Silver");
	
	List<String> TYPE = List.of("Sedan", "SUV", "MPV","Hatchback", "Convertible");
	
	List<String> ADDITIONAL_FEATURE = List.of("GPS", "Alarm", "Sunroof", "Media Player", "Leather Seats");
	
	List<String> FUELS = List.of("Petrol", "Electric", "Hybrid");
	
	List<String> TIRE_MANUFACTURES =  List.of("Goodyear", "Bridgestone", "Dunlop");
	Car generateCar();
}
