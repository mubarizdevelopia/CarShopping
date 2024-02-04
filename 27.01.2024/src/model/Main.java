package model;

import java.util.List;

import enums.PromoCode;
import enums.TransactionStatus;

public class Main {

	public static void main(String[] args) {
//		Generics generics = new Generics(1);
//		System.out.println(generics.getTest());
		User user = new User(1, "Oqtay");
		User user2 = new User(2, "Elvin");
		Car car1 = new Car("07", 16000, 6);
		Car car2 = new Car("BMW", 10000, 7);
		CarShop carShop = new CarShop();
		carShop.cars.add(car1);
		carShop.cars.add(car2);
		carShop.buyCar("BMW", PromoCode.B,user.getId());
		carShop.buyCar("BMW", PromoCode.B,user.getId());
		List<Transaction> userTransactions1 = carShop.getTransactionsByUserId(user.getId());
//		var transactions =carShop.getTransactionsByStatus(TransactionStatus.FAILED);
//		for(Transaction tr:userTransactions1) {
//			System.out.print(tr);
//		}
//		carShop.reverseTransaction(1);
		
//		carShop.buyCar("07", PromoCode.B,user.getId());
//		carShop.buyCar("MERCEDES", PromoCode.B,user.getId());
//		carShop.buyCar("BMW", PromoCode.B,user2.getId());
//		carShop.buyCar("BMW",null);

		for (Car car : carShop.saledCars) {
			System.out.println("Saled:Model: " + car.getModel() + " Count: " + car.getCount());
		}

		for (Car car : carShop.cars) {
			System.out.println("Not Saled Model: " + car.getModel() + " Count: " + car.getCount());
		}

//		for (Transaction tr : carShop.transactions) {
//			System.out.println(
//					"Tr_id: " + tr.getId() + "  Car Model: " + tr.getCarModel() + " Amount: " + tr.getAmount());
//		}

//		System.out.println(carShop.calculateSumOfPrice());
		
//		List<Transaction> userTransactions = carShop.getTransactionsByUserId(user.getId());
////		var transactions =carShop.getTransactionsByStatus(TransactionStatus.FAILED);
//		for(Transaction tr:userTransactions) {
//			System.out.print(tr);
//		}
		
//		for(Transaction tr:transactions) {
//			System.out.print(tr);
//		}
		

	}

}