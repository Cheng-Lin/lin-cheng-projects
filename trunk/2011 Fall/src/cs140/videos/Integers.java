package cs140.videos;
/**
 * Class to illustrate the limit on the size of numbers
 * that an int can represent by considering factorials. 
 * The main method lists the products explicitly.
 * 
 * @author CS140
 */
public class Integers {

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
		System.out.println("factorial of  1 = " + 1);
		System.out.println("factorial of  2 = " + 1*2);
		System.out.println("factorial of  3 = " + 1*2*3);
		System.out.println("factorial of  4 = " + 1*2*3*4);
		System.out.println("factorial of  5 = " + 1*2*3*4*5);
		System.out.println("factorial of  6 = " + 1*2*3*4*5*6);
		System.out.println("factorial of  7 = " + 1*2*3*4*5*6*7);
		System.out.println("factorial of  8 = " + 1*2*3*4*5*6*7*8);
		System.out.println("factorial of  9 = " + 1*2*3*4*5*6*7*8*9);
		System.out.println("factorial of 10 = " + 1*2*3*4*5*6*7*8*9*10);
		System.out.println("factorial of 11 = " + 1*2*3*4*5*6*7*8*9*10*11);
		System.out.println("factorial of 12 = " + 1*2*3*4*5*6*7*8*9*10*11*12);
		System.out.println("factorial of 13 = " + 1*2*3*4*5*6*7*8*9*10*11*12*13);
		System.out.println("factorial of 14 = " + 1*2*3*4*5*6*7*8*9*10*11*12*13*14);
		System.out.println("factorial of 15 = " + 1*2*3*4*5*6*7*8*9*10*11*12*13*14*15);
		System.out.println("factorial of 16 = " + 1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16);
		System.out.println("factorial of 17 = " + 1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17);
	}
}
