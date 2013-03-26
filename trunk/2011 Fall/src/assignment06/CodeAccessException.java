package assignment06;
/**
 * Unchecked Exception that is thrown when access to
 * instruction location outside the range of 0 to 255
 * 
 * @author Ke-Bang Huang
 */
public class CodeAccessException extends ArrayIndexOutOfBoundsException
{
	/**
	 * Null argument constructor
	 */
	public CodeAccessException() {}
	
	/**
	 * Constructor that provides a message for the exception
	 * @param message the message thrown with the exception
	 */
	public CodeAccessException(String message) {
		super(message);
	}
}
