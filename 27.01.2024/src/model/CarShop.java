package model;

import java.util.ArrayList;
import java.util.List;

import Exception.CarNotFoundException;
import enums.PromoCode;
import enums.TransactionStatus;

public class CarShop {
	List<Car> cars;
	List<Car> saledCars;
	List<Transaction> transactions;
	private static Integer id = 0;

	public CarShop() {
		this.cars = new ArrayList<>();
		this.saledCars = new ArrayList<>();
		this.transactions = new ArrayList<>();
	}

	public void buyCar(String model, PromoCode pr, int userId) {
		id++;
		boolean isExist = false;
		Transaction transaction = new Transaction();
		transaction.setId(id);
		transaction.setUserId(userId);
		Car selectedCar = new Car();
		for (Car car : this.cars) {
			if (car.getModel() == model) {
				isExist = true;
				selectedCar = car;
				break;
			}

		}

		if (!isExist) {
			transaction.setStatus(TransactionStatus.FAILED);
			transactions.add(transaction);
//			throw new CarNotFoundException("Mashin yoxdur");
			return;
		}
		if (selectedCar.getCount() == 0) {
			cars.remove(cars.indexOf(selectedCar));
			transaction.setStatus(TransactionStatus.FAILED);
			return;
//			throw new CarNotFoundException("Mashin yoxdur.");
		}
		Car saledCar = findSaledCar(model);
		if (!carIsSaled(saledCar)) {
			saledCar = new Car(selectedCar.getModel(), selectedCar.getPrice(), 1);
			saledCars.add(saledCar);
		} else {
			saledCar.setCount(saledCar.getCount() + 1);
		}
		selectedCar.setCount(selectedCar.getCount() - 1);
		int perc = getPromocode(pr);
		int decreaseValue = 0;
		if (perc != 1) {
			decreaseValue = (saledCar.getPrice() * perc) / 100;
		}

		transaction.setStatus(TransactionStatus.SUCCESS);
		transaction.setAmount(saledCar.getPrice() - decreaseValue);
		transaction.setCarModel(saledCar.getModel());
		this.transactions.add(transaction);
	}

	private boolean carIsSaled(Car car) {
		return car != null;
	}

	private Car findSaledCar(String model) {
		for (Car car : this.saledCars) {
			if (car.getModel() == model) {
				return car;
			}
		}
		return null;
	}

	public int calculateSumOfPrice() {
		int sum = 0;
		for (Transaction tr : this.transactions) {
			sum += tr.getAmount();
		}
		return sum;
	}

	private int getPromocode(PromoCode pr) {
		boolean isExist = false;
		for (PromoCode promo : PromoCode.values()) {
			if (pr == promo) {
				isExist = true;
			}
		}
		if (isExist) {
			return pr.getVal();
		}
		return 1;
	}

	public List<Transaction> getTransactionsByUserId(int userId) {
		List<Transaction> userTransactions = new ArrayList<>();

		for (Transaction tr : this.transactions) {
			if (tr.getUserId() == userId) {
				userTransactions.add(tr);
			}
		}
		return userTransactions;
	}

	public List<Transaction> getTransactionsByStatus(TransactionStatus status) {
		List<Transaction> transactions = new ArrayList<>();

		for (Transaction tr : this.transactions) {
			if (tr.getStatus() == status) {
				transactions.add(tr);
			}
		}

		return transactions;
	}

	public void reverseTransaction(int transactionId) {
		boolean isExist = false;
		Transaction transaction = new Transaction();
		for (Transaction tr : this.transactions) {
			if (tr.getId() == transactionId && tr.getStatus() == TransactionStatus.SUCCESS) {
				isExist = true;
				transaction = tr;
				break;
			}
		}
		transaction.setStatus(TransactionStatus.REVERSED);
		Car car = findSaledCar(transaction.getCarModel());

		if (car != null && car.getCount() > 1) {
			car.setCount(car.getCount() - 1);
		} else {
			this.saledCars.remove(car);
		}
		car = carExists(transaction.getCarModel());
		if (car != null && car.getCount() >= 1) {
			car.setCount(car.getCount() + 1);
		}else {
			cars.add(car);
		}

	}

	private Car carExists(String model) {
		for (Car car : this.cars) {
			if (car.getModel() == model) {
				return car;
			}
		}
		return null;
	}

}
