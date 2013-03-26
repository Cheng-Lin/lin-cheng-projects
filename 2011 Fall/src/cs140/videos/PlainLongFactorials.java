package cs140.videos;

/**
 * Class to illustrate the limit on the size of numbers
 * that an long can represent. The products are computed
 * in a loop and shown in decimal.
 * 
 * @author CS140
 */
public class PlainLongFactorials {
	/**
	 * Main method with tests of the numbers that can
	 * be represented using a long.
	 * 
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args) {
				
		long currentProduct = 1;
		for(int i = 1; i < 23; i++) {
			currentProduct = currentProduct * i; 			
			if(i < 10) {
				System.out.println("factorial of  " + i + 
						" = " + currentProduct);
			} else {
				System.out.println("factorial of " + i + 
						" = " + currentProduct);				
				
			}
		}

	}
	
}
