package generic_example;

public class Main {

	public static void main(String[] args) {
//		Generics generics = new Generics(1);
//		System.out.println(generics.getTest());

		Car car1 = new Car("Ford Mustang", 16000, 6);
		Car car2 = new Car("Toyota Supra", 45000, 7);
		CarShop carShop = new CarShop();
		carShop.cars.add(car1);
		carShop.cars.add(car2);
		try {
			carShop.buyCar("Ford Mustang");
			carShop.buyCar("Ford Mustang");
			carShop.buyCar("Ford Mustang");
			carShop.buyCar("Ford Mustang");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (Car car : carShop.saledCars) {
			System.out.println("Saled:Model: " + car.model + " Count: " + car.count);
		}
		for (Car car : carShop.cars) {
			System.out.println("Model: " + car.model + " Count: " + car.count);
		}
	}

}