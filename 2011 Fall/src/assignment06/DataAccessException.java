package assignment06;
/**
 * Unchecked Exception that is thrown when access to
 * instruction location outside the range of 0 to 255
 * 
 * @author Ke-Bang Huang
 */
public class DataAccessException extends ArrayIndexOutOfBoundsException 
{
	/**
	 * Null argument constructor
	 */
	public DataAccessException() {}
	
	/**
	 * Constructor that provides a message for the exception
	 * @param message the message thrown with the exception
	 */
	public DataAccessException(String message) {
		super(message);
	}
}
