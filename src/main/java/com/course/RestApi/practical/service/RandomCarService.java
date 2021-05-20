package com.course.RestApi.practical.service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.course.RestApi.practical.entity.Car;
import com.course.RestApi.practical.entity.Engine;
import com.course.RestApi.practical.entity.Tire;
import com.course.RestApi.practical.util.RandomDateUtil;

@Service
public class RandomCarService implements CarService {

	@Override
	public Car generateCar() {

		var brand = BRAND.get(ThreadLocalRandom.current().nextInt(0, BRAND.size()));
		var color = COLOR.get(ThreadLocalRandom.current().nextInt(0, COLOR.size()));
		var type = TYPE.get(ThreadLocalRandom.current().nextInt(0, TYPE.size()));
		
		var available = ThreadLocalRandom.current().nextBoolean();
		var price = ThreadLocalRandom.current().nextInt(5000, 12001);
		var firstReleaseDate = RandomDateUtil.generateRandomLocalDate();
		
		int randomCount = ThreadLocalRandom.current().nextInt(ADDITIONAL_FEATURE.size());
		var additionalFeature = new ArrayList<String>();
		
		for(int i = 0; i < randomCount; i++) {
			additionalFeature.add(ADDITIONAL_FEATURE.get(i));
		}
		
		var fuel = FUELS.get(ThreadLocalRandom.current().nextInt(FUELS.size()));
		var horsePower = ThreadLocalRandom.current().nextInt(100, 221);
		var engine = new Engine();
		engine.setFuelType(fuel);
		engine.setHorsePower(horsePower);
		
		var tires = new ArrayList<Tire>();
		for(int i = 0 ; i < 3; i++) {
			var tire = new Tire();
			var manufacturer = TIRE_MANUFACTURES.get(ThreadLocalRandom.current().nextInt(TIRE_MANUFACTURES.size()));
			var size = ThreadLocalRandom.current().nextInt(15, 18);
			var tireprice = ThreadLocalRandom.current().nextInt(200, 401);
			
			tire.setManufacturer(manufacturer);
			tire.setSize(size);
			tire.setPrice(tireprice);
			
			tires.add(tire);
		}
		
		var secretFeature = ThreadLocalRandom.current().nextBoolean() ? "Can fly" : null;
		
		var result = new Car(brand, color, type);
		result.setAvailable(available);
		result.setPrice(price);
		result.setFirstReleaseDate(firstReleaseDate);
		result.setAdditionalFeature(additionalFeature);
		result.setTires(tires);
		result.setSecretFeature(secretFeature);
		
		return result;
	}

}
