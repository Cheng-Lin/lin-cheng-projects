package assignment07;
/**
 * Checked Exception that is thrown when a 
 * bank account is overdrawn
 * @author CS 140
 *
 */
public class InsufficientFundsException extends Exception {
	private static final long serialVersionUID = -3415506535660215916L;
	/**
	 * Null argument constructor
	 */
	public InsufficientFundsException() {
	}
	/**
	 * Constructor that provides a message for the exception
	 * @param message the message thrown with the exception
	 */
	public InsufficientFundsException(String message) {
		super(message);
	}
}
