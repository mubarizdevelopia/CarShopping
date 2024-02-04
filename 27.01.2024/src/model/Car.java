package model;

import Exception.PriceLowerThanLimitEcxeption;

public class Car  {
	private String model;
	private int price;
	private int count;

	public Car(String model, int price, int count) {
		if (price < 1000) {
			throw new PriceLowerThanLimitEcxeption("Car's price must be greater than 1000");
		}
		this.model = model;
		this.price = price;
		this.count = count;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Car() {

	}
}
