package Exception;

public class PriceLowerThanLimitEcxeption extends RuntimeException {
	String message;

	public PriceLowerThanLimitEcxeption(String message) {
		super(message);
		this.message = message;
	}
}
