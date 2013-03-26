package cs140.videos;
/**
 * Class to illustrate the limit on the size of numbers
 * that an int can represent. The products are computed
 * in a loop.
 * 
 * @author CS140
 */
public class Integers1 {

	/**
	 * Main method with sample numbers that may or 
	 * may not be correctly represented using an int 
	 * (which is stored in the standard 32-bit 2-s 
	 * complement form). Factorials are used that have
	 * previously been computed by hand.
	 * 
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args) {
		int currentProduct = 1;
		
		for(int i = 1; i < 18; i++) {
			currentProduct = currentProduct * i; 
			System.out.println("factorial of " + i + 
					" = " + currentProduct);			
		}
	}
}
