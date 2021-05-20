package com.course.RestApi.practical.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Tire {

	private String manufacturer;
	
	private int size;
	
	@JsonIgnore
	private int price;
	
	public Tire() {
		
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Tire [manufacturer=" + manufacturer + ", size=" + size + ", price=" + price + "]";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
