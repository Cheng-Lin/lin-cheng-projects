package cs140.videos;
/**
 * Class that provides a way to see the binary representation of an
 * int using its 32-bit 2-s complement form.
 * 
 * @author CS 140
 *
 */
public class IntToBinary {
	/**
	 * Method to present an int as a String of 0s and 1s 
	 * showing the 2-s complement 32-bit internal representation
	 * of the number in the computer.
	 * 
	 * If the parameter is positive the method prints the 
	 * intermediate steps in building the String.
	 * 
	 * @param i the int value to be shown as a 32-bit binary String
	 * @return the binary String showing how i is stored
	 */
	public String formatAs32BitString(int i) {
		String retVal = Integer.toBinaryString(i);
		if(i >= 0) {
			System.out.println("Binary form without " +
					"leading 0s = " + retVal);
			retVal = "00000000000000000000000000000000" + retVal;
			System.out.println("Binary form with 32 " +
					"leading 0s = " + retVal);			
			retVal = retVal.substring(retVal.length()-32);
			System.out.println("Binary form reduced to 32 " +
					"characters = " + retVal);			
		}
		return retVal;
	}

	/**
	 * Main method with allows the programmer to experiment
	 * with the representation of an int as a 32-bit
	 * 2-s complement representation). Results are shown
	 * in decimal and binary format
	 * 
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args) {

		IntToBinary test = new IntToBinary();

		int value = -210;
		System.out.println("As an int, " + value + " is stored as " 
					+ test.formatAs32BitString(value));			

	}

}



