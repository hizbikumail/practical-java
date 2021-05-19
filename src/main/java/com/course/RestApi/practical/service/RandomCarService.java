package com.course.RestApi.practical.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.course.RestApi.practical.entity.Car;

@Service
public class RandomCarService implements CarService {

	@Override
	public Car generateCar() {

		var brand = BRAND.get(ThreadLocalRandom.current().nextInt(0, BRAND.size()));
		var color = COLOR.get(ThreadLocalRandom.current().nextInt(0, COLOR.size()));
		var type = TYPE.get(ThreadLocalRandom.current().nextInt(0, TYPE.size()));
		
		return new Car(brand, color, type);
	}

}
