package generic_example;

import java.util.ArrayList;
import java.util.List;

import Exception.CarNotFoundException;

public class CarShop {
	List<Car> cars;
	List<Car> saledCars;
	public static int sumOfPrice = 0;

	public CarShop() {
		this.cars = new ArrayList<>();
		this.saledCars = new ArrayList<>();
	}

	public void buyCar(String model) throws CloneNotSupportedException {
		boolean isExist = false;
		Car selectedCar = new Car();
		for (Car car : this.cars) {
			if (car.model == model) {
				isExist = true;
				selectedCar = car;
			}
		}

		if (!isExist) {
			throw new CarNotFoundException("Mashin yoxdur");
		}
		if (selectedCar.count == 0) {
			cars.remove(cars.indexOf(selectedCar));
			throw new CarNotFoundException("Mashin yoxdur.");
		}
		Car saledCar = findSaledCar(model);
		selectedCar.count -= 1;
		if (!carIsSaled(saledCar)) {
			saledCar = new Car(selectedCar.model, selectedCar.price, 1);
			saledCars.add(saledCar);
		} else {
			saledCar.count++;
		}

		for (Car car : saledCars) {
			sumOfPrice += car.price * car.count;
		}

	}

	private boolean carIsSaled(Car car) {
		return car != null;
	}

	private Car findSaledCar(String model) {
		for (Car car : this.saledCars) {
			if (car.model == model) {
				return car;
			}
		}
		return null;
	}

}
