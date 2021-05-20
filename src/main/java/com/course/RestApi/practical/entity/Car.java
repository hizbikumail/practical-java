package com.course.RestApi.practical.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Document(indexName = "practical-java")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car {

	@Id
	private String id;
	
	@JsonInclude(value = Include.NON_EMPTY)
	private List<String> additionalFeature;
	
	private Boolean available;

	private String brand;

	private String color;
	
	private Engine engine;
	
	@Field(type = FieldType.Date, format = DateFormat.date)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
	private LocalDate FirstReleaseDate;

	private int price;
	
	@JsonInclude(value = Include.NON_EMPTY)
	private String secretFeature;
	
	public List<Tire> tires;
	
	private String type;
	
	public Car(String brand, String color, String type) {
		super();
		this.brand = brand;
		this.color = color;
		this.type = type;
	} 
	
	public List<String> getAdditionalFeature() {
		return additionalFeature;
	}
	
	public Boolean getAvailable() {
		return available;
	}
	
	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public Engine getEngine() {
		return engine;
	}

	public LocalDate getFirstReleaseDate() {
		return FirstReleaseDate;
	}

	public String getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public String getSecretFeature() {
		return secretFeature;
	}

	public List<Tire> getTires() {
		return tires;
	}

	public String getType() {
		return type;
	}

	public void setAdditionalFeature(List<String> additionalFeature) {
		this.additionalFeature = additionalFeature;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setFirstReleaseDate(LocalDate firstReleaseDate) {
		FirstReleaseDate = firstReleaseDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setSecretFeature(String secretFeature) {
		this.secretFeature = secretFeature;
	}

	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [additionalFeature=" + additionalFeature + ", secretFeature=" + secretFeature + ", available="
				+ available + ", brand=" + brand + ", color=" + color + ", engine=" + engine + ", FirstReleaseDate="
				+ FirstReleaseDate + ", price=" + price + ", tires=" + tires + ", type=" + type + "]";
	}
}
