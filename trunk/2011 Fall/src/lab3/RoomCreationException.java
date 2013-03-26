package lab3;
/**
 * Exception class used to describe problems in creating
 * room information when planning a House.
 * @author CS 140
 *
 */
public class RoomCreationException extends Exception {
	// Exception is Serializable, hence its subclasses need
	// their own serialVersionID to avoid compiler warnings
	private static final long serialVersionUID = -8860866354829155684L;
	
	/**
	 * Null argument constructor for this exception
	 */
	public RoomCreationException() {
		super();
	}

	/**
	 * Constructor for this exception that takes a message
	 * argument
	 * @param message the message contained in the exception object
	 */
	public RoomCreationException(String message) {
		super(message);
	}	
}
