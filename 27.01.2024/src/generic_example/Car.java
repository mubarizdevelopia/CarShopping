package generic_example;

import Exception.PriceLowerThanLimitEcxeption;

public class Car implements Cloneable {
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	String model;
	int price;
	int count;

	public Car(String model, int price, int count) {
		if (price < 1000) {
			throw new PriceLowerThanLimitEcxeption("Car's price must be greater than 1000");
		}
		this.model = model;
		this.price = price;
		this.count = count;
	}

	public Car() {

	}
}
