package cs140.videos;
/**
 * Class that provides a way to see the binary representation of
 * selected int values in their 32-bit 2-s complement form.
 * 
 * @author CS 140
 *
 */
public class IntToBinary1 {
	/**
	 * Method to present an int as a String of 0s and 1s 
	 * showing the 2-s complement 32-bit internal representation
	 * of the number in the computer.
	 * 
	 * @param i the int value to be shown as a 32-bit binary String
	 * @return the binary String showing how i is stored
	 */
	public String formatAs32BitString(int i) {
		String retVal = Integer.toBinaryString(i);
		if(i >= 0) {
			retVal = "00000000000000000000000000000000" + retVal;
			retVal = retVal.substring(retVal.length()-32);
		}
		return retVal;
	}

	/**
	 * Main method with shows selected int values
	 * with their representation as a 32-bit
	 * 2-s complement representation).
	 * 
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args) {

		IntToBinary1 test = new IntToBinary1();

		System.out.println("As an int, " + 1 + " is stored as " 
				+ test.formatAs32BitString(1));			
		System.out.println("As an int,  " + 0 + " is stored as " 
				+ test.formatAs32BitString(0));			
		System.out.println("As an int, " + -1 + " is stored as " 
				+ test.formatAs32BitString(-1));			
		System.out.println("As an int, " + 1000 + " is stored as " 
				+ test.formatAs32BitString(1000));			
		System.out.println("As an int,  " + 1024 + " is stored as " 
				+ test.formatAs32BitString(1024));			
		System.out.println("As an int,  " + 1023 + " is stored as " 
				+ test.formatAs32BitString(1023));			
		System.out.println("As an int, " + -1024 + " is stored as " 
				+ test.formatAs32BitString(-1024));			
		System.out.println("As an int,  " + Integer.MAX_VALUE + " is stored as " 
				+ test.formatAs32BitString(Integer.MAX_VALUE));			
		System.out.println("As an int, " + Integer.MIN_VALUE + " is stored as " 
				+ test.formatAs32BitString(Integer.MIN_VALUE));			
	}

}
