package lab1;

import java.math.BigInteger;

/**
 * Recursive versions of factorial using int, long
 * and BigInteger
 * @author CS140
 *
 */
public class RecursiveFactorials {
	/**
	 * Compute the factorial of the input for values
	 * 0 through 12 using int.
	 * @param i the input value
	 * @return the int value of the factorial of 
	 * the input
	 * @throws IllegalArgumentException if the input
	 * is negative
	 */
	public static int factorialIre(int i) {
		int value = 1;
		if(i < 0) {
			throw new IllegalArgumentException("Negative argument not accepted");
		} // no need for an else since an exception
		// causes the method to exit
		if(i > 0) {
			value = i * factorialIre(i-1);
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for values
	 * 0 through 12 using int. Prints a warning
	 * message if the value is negative.
	 * @param i the input value
	 * @return the int value of the factorial of 
	 * the input or 1 if the input is negative
	 */
	public static int factorialIrm(int i) {
		int value = 1;
		if(i < 0) {
			System.out.println("Negative input " + 
					i + " is invalid");
		} else {
			if(i > 0) {
				value = i * factorialIrm(i-1);
			}
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for values
	 * 0 through 20 using long.
	 * @param i the input value
	 * @return the long value of the factorial of 
	 * the input
	 * @throws IllegalArgumentException if the input
	 * is negative
	 */
	public static long factorialLre(int i) {
		long value = 1;
		if(i < 0) {
			throw new IllegalArgumentException("Negative argument not accepted");
		} // no need for an else since an exception
		// causes the method to exit
		if(i > 0) {
			value = i * factorialLre(i-1);
		}
		return value;
	}
	/**
	  Compute the factorial of the input for values
	  0 through 20 using long. Prints a warning
	  message if the value is negative.
	  @param i the input value
	  @return the long value of the factorial of 
	  the input or 1 if the input is negative
	 */
	public static long factorialLrm(int i) {
		long value = 1;
		if(i < 0) {
			String message = "Negative input " + i 
					+ " is invalid";
			System.out.println(message);
		} else {
			if(i > 0) {
				value = i * factorialLrm(i-1);
			}
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for 
	 * non-negative values using BigInteger.
	 * The upper limit will depend on machine 
	 * restrictions.
	 * @param i the input value
	 * @return the BigInteger value of the factorial 
	 * of the input
	 * @throws IllegalArgumentException if the input
	 * is negative
	 */
	public static BigInteger factorialBIre(int i) {
		BigInteger value = BigInteger.ONE;
		if(i < 0) {
			throw new IllegalArgumentException("Negative argument not accepted");
		} // no need for an else since an exception
		// causes the method to exit
		if(i > 0) {
			value = factorialBIre(i-1).multiply(BigInteger.valueOf(i));
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for 
	 * non-negative values using BigInteger.
	 * The upper limit will depend on machine 
	 * restrictions.
	 * @param i the input value
	 * @return the BigInteger value of the factorial 
	 * of the input
	 */
	public static BigInteger factorialBIrm(int i) {
		BigInteger value = BigInteger.ONE;
		if(i < 0) {
			System.out.print("Negative input ");
			System.out.print(i); 
			System.out.println(" is invalid");
		} else {
			if(i > 0) {
				value = factorialBIrm(i-1).multiply(BigInteger.valueOf(i));
			}
		}
		return value;
	}

	/**
	 * Driver method to print the values of the factorial
	 * methods above.
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args) {
		RecursiveFactorials test = new RecursiveFactorials();
		System.out.println("Testing versions with exceptions with non-negative inputs");
		for(int i = 0; i < 67; i++) {
			System.out.println("factorial of " + i + ":"); 
			System.out.println("  " + test.factorialIre(i) + 
					"\t(using int, hex: " + Integer.toHexString(test.factorialIre(i))+ ")");
			System.out.println("  " + test.factorialLre(i) + 
					"\t(using long, hex:  " + Long.toHexString(test.factorialLre(i))+ ")");
			System.out.println("  " + test.factorialBIre(i) + 
					"\t(using BigInteger, hex:  " + test.factorialBIre(i).toString(16) + ")");
		}
		System.out.println("----------------------");
		//		System.out.println("Testing versions with exceptions with negative inputs");
		//		System.out.println("factorial of -5:"); 
		//		System.out.println("  " + test.factorialIre(-5) + 
		//				"\t(using int, hex: " + Integer.toHexString(test.factorialIre(-5))+ ")");
		//		System.out.println("  " + test.factorialLre(-5) + 
		//				"\t(using long, hex:  " + Long.toHexString(test.factorialLre(-5))+ ")");
		//		System.out.println("  " + test.factorialBIre(-5) + 
		//				"\t(using BigInteger, hex:  " + test.factorialBIre(-5).toString(16) + ")");
		System.out.println("----------------------");
		System.out.println("Testing versions with messages with positive and negative inputs");
		for(int i = -3; i < 67; i++) {
			System.out.println("factorial of " + i + ":"); 
			System.out.println("  " + test.factorialIrm(i) + 
					"\t(using int)");
			System.out.println("  " + test.factorialLrm(i) + 
					"\t(using long)");
			System.out.println("  " + test.factorialBIrm(i) + 
					"\t(using BigInteger)");
		}

	}
}
