package lab06.part1;

public class InsufficientFundsException extends Exception {
	private static final long serialVersionUID = -3415506535660215916L;
	public InsufficientFundsException() {
	}
	public InsufficientFundsException(String message) {
		super(message);
	}
}
