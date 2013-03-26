package cs140.videos;

/**
 * Class to illustrate the limit on the size of numbers
 * that an int can represent. The products are computed
 * in a loop and shown in binary format.
 * 
 * @author CS140
 */
public class BinaryVersions {
	/**
	 * Method to present an int as a String of 0s and 1s 
	 * illustrating the 2-s complement 32-bit internal 
	 * representation of the number in the computer.
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
	 * Main method with tests of the numbers that can
	 * be represented using an int (which is stored in 
	 * 32-bit 2-s complement form). Results are shown
	 * in their binary format
	 * 
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args) {
		
		BinaryVersions test = new BinaryVersions();
		
		int currentProduct = 1;
		for(int i = 1; i < 18; i++) {
			currentProduct = currentProduct * i; 
			
			String val = test.formatAs32BitString(currentProduct);			
			if(i < 10) {
				System.out.println("factorial of  " + i + " = " + val);
			} else {
				System.out.println("factorial of " + i + " = " + val);				
			}
		}
	}
}
