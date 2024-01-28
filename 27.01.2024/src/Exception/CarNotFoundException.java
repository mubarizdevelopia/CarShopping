package Exception;

public class CarNotFoundException extends RuntimeException {

	String message;

	public CarNotFoundException(String message) {
		super(message);
		this.message = message;

	}
}
