package finalproject;

public class DivideByZeroError extends RuntimeException {

	public DivideByZeroError() {
	}

	public DivideByZeroError(String message) {
		super(message);
	}

}
