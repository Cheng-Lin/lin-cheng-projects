package lab1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Recursive versions of factorial using int, long
 * and BigInteger
 * @author CS140
 *
 */
public class IterativeFactorials {
	/**
	 * Compute the factorial of the input for values 0 through 12 
	 * using int.
	 * @param i the input value
	 * @return the int value of the factorial of the input
	 * @throws IllegalArgumentException if the input is negative
	 */
	public static int factorialIie(int i) {
		int value = 1;
		if(i < 0) {
			throw new IllegalArgumentException("Negative argument not accepted");
		} 
		int count = 1;
		while(count <= i) {
			value = value * count;
			count = count + 1;
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for values 0 through 12 
	 * using int. Prints a warning message if the value is negative.
	 * @param i the input value
	 * @return the int value of the factorial of the input or 1 
	 * if the input is negative
	 */
	public static int factorialIim(int i) {
		int value = 1;
		if(i < 0) {
			System.out.println("Negative input " + 
					i + " is invalid");
		} else {
			int count = 1;
			while(count <= i) {
				value *= count;
				count++;
			}
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for values 0 through 20 
	 * using long.
	 * @param i the input value
	 * @return the long value of the factorial of the input
	 * @throws IllegalArgumentException if the input is negative
	 */
	public static long factorialLie(int i) {
		long value = 1;
		if(i < 0) {
			throw new IllegalArgumentException("Negative argument not accepted");
		}
		int count = 1;
		while(count <= i) {
			value *= count;
			count++;
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for values 0 through 20 
	 * using long. Prints a warning message if the value is negative.
	 * @param i the input value
	 * @return the long value of the factorial of the input or 1 
	 * if the input is negative
	 */
	public static long factorialLim(int i) {
		long value = 1;
		if(i < 0) {
			String message = "Negative input " + i + " is invalid";
			System.out.println(message);
		} else {
			int count = 1;
			while(count <= i) {
				value *= count;
				count++;
			}
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for non-negative values 
	 * using BigInteger. The upper limit will depend on machine 
	 * restrictions.
	 * @param i the input value
	 * @return the BigInteger value of the factorial of the input
	 * @throws IllegalArgumentException if the input is negative
	 */
	public static BigInteger factorialBIie(int i) {
		BigInteger value = BigInteger.ONE;
		if(i < 0) {
			throw new IllegalArgumentException("Negative argument not accepted");
		}
		int count = 1;
		while(count <= i) {
			value = value.multiply(BigInteger.valueOf(count));
			count++;
		}
		return value;
	}
	/**
	 * Compute the factorial of the input for non-negative values 
	 * using BigInteger. The upper limit will depend on machine 
	 * restrictions. Prints a warning message if the value is negative.
	 * @param i the input value
	 * @return the BigInteger value of the factorial of the input
	 */
	public static BigInteger factorialBIim(int i) {
		BigInteger value = BigInteger.ONE;
		if(i < 0) {
			System.out.print("Negative input ");
			System.out.print(i); 
			System.out.println(" is invalid");
		} else {
			int count = 1;
			while(count <= i) {
				value = value.multiply(BigInteger.valueOf(count));
				count++;
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
		IterativeFactorials test = new IterativeFactorials();
		System.out.println("Testing versions with exceptions with non-negative inputs");
		for(int i = 0; i < 67; i++) {
			System.out.println("factorial of " + i + ":"); 
			System.out.println("  " + test.factorialIie(i) + 
					"\t(using int, hex: " + Integer.toHexString(test.factorialIie(i))+ ")");
			System.out.println("  " + test.factorialLie(i) + 
					"\t(using long, hex:  " + Long.toHexString(test.factorialLie(i))+ ")");
			System.out.println("  " + test.factorialBIie(i) + 
					"\t(using BigInteger, hex:  " + test.factorialBIie(i).toString(16) + ")");
		}
		System.out.println("----------------------");
		System.out.println("Testing versions with exceptions with negative inputs");
		System.out.println("factorial of -5:");
		try {
			System.out.println("  " + test.factorialIie(-5) + 
					"\t(using int, hex: " + Integer.toHexString(test.factorialIie(-5))+ ")");
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		try {
			System.out.println("  " + test.factorialLie(-5) + 
					"\t(using long, hex:  " + Long.toHexString(test.factorialLie(-5))+ ")");
		} catch(IllegalArgumentException ex) {
			System.out.println(ex);
		}
		try {
			System.out.println("  " + test.factorialBIie(-5) + 
					"\t(using BigInteger, hex:  " + test.factorialBIie(-5).toString(16) + ")");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("----------------------");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Hit enter when ready");
		keyboard.nextLine();
		System.out.println("Testing versions with messages with positive and negative inputs");
		for(int i = -3; i < 67; i++) {
			System.out.println("factorial of " + i + ":"); 
			System.out.println("  " + test.factorialIim(i) + 
					"\t(using int)");
			System.out.println("  " + test.factorialLim(i) + 
					"\t(using long)");
			System.out.println("  " + test.factorialBIim(i) + 
					"\t(using BigInteger)");
		}

	}
}
