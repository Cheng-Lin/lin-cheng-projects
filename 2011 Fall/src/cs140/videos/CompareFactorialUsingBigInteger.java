package cs140.videos;

import java.math.BigInteger;

/**
 * Class to illustrate the computation of the factorial of a
 * number using int, long and BigInteger. The products are computed
 * in a loop and shown in decimal.
 * 
 * @author CS140
 */
public class CompareFactorialUsingBigInteger {
	/**
	 * Main method with tests of the numbers that can
	 * be represented using a long.
	 * 
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args) {
		int currentIntProduct = 1;		
		long currentLongProduct = 1;
		BigInteger currentBigIntProduct = BigInteger.ONE;
		for(int i = 1; i < 67; i++) {
			currentIntProduct = currentIntProduct * i; 			
			currentLongProduct = currentLongProduct * i; 			
			currentBigIntProduct = 
				currentBigIntProduct.multiply(BigInteger.valueOf(i)); 			
			System.out.println("factorial of " + i + ":"); 
			System.out.println("\t" + currentIntProduct + "\t(using int)");
			System.out.println("\t" + currentLongProduct + "\t(using long)");
			System.out.println("\t" + currentBigIntProduct + "\t(using BigInteger)");
		}
		for(int i = 67; i <= 500; i++) {
			currentBigIntProduct = 
				currentBigIntProduct.multiply(BigInteger.valueOf(i)); 			
		}
		System.out.println("\n-----------------------------------------");
		System.out.println("factorial of 500 = "+ currentBigIntProduct);
	}
}

