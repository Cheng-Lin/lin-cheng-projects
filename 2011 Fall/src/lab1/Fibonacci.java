package lab1;

import java.math.BigInteger;

public class Fibonacci {
	/**
	 * Compute the fibonacci of the input for values
	 * @param i the input value
	 * @return the int value of the factorial of 
	 * the input
	 */
    public static int fibonacciIre(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Negative argument not accepted");
        }
        return auxI(i,0,0,1);
    }
    /**
     * The recursive method for calculating fibonacci
     * @param i the input value
     * @param count the int counter
     * @param fib1 int first fibonacci number used in 
     * the calculation
     * @param fib2 int secount fibonacci number used in 
     * the calculation
     * @return the int value of the fibonacci of
     * the input
     */
    public static int auxI(int i, int count, int fib1, int fib2) {
        int value = fib1;
        if(count < i) {
                value = auxI(i, count+1, fib2, fib1+fib2);;
        }
        return value;
    }
	/**
	 * Compute the fibonacci of the input for values
	 * @param i the input value
	 * @return the long value of the factorial of 
	 * the input
	 */
    public static long fibonacciLre(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Negative argument not accepted");
        }
        return auxL(i,0,0,1);
    }
    /**
     * The recursive method for calculating fibonacci
     * @param i the input value
     * @param count the int counter
     * @param fib1 long first fibonacci number used in 
     * the calculation
     * @param fib2 long secount fibonacci number used in 
     * the calculation
     * @return the long value of the fibonacci of
     * the input
     */
    public static long auxL(int i, int count, long fib1, long fib2) {
        long value = fib1;
        if(count < i) {
                value = auxL(i, count+1, fib2, fib1+fib2);;
        }
        return value;
    }
	/**
	 * Compute the fibonacci of the input for values
	 * @param i the input value
	 * @return the BigInteger value of the factorial of 
	 * the input
	 */
    public static BigInteger fibonacciBIre(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Negative argument not accepted");
        }
        return auxBI(i,0,BigInteger.ZERO,BigInteger.ONE);
    }
    /**
     * The recursive method for calculating fibonacci
     * @param i the input value
     * @param count the int counter
     * @param fib1 BigInteger first fibonacci number used in 
     * the calculation
     * @param fib2 BigInteger secount fibonacci number used in 
     * the calculation
     * @return the BigInteger value of the fibonacci of
     * the input
     */
    public static BigInteger auxBI(int i, int count, BigInteger fib1, BigInteger fib2) {
        BigInteger value = fib1;
        if(count < i) {
                value = auxBI(i, count+1, fib2, fib1.add(fib2));;
        }
        return value;
    }
    /**
     * The iterative method for calculating fibonacci
     * @param i the input value
     * @return the int value of the fibonacci of the input
     */
    public static int fibonacciIim(int i) {
        int fib1 = 0;
        int fib2 = 1;
        int count = 0;
        while(count < i) {
            int temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
            count = count + 1;
        }
        return fib1;
    }
    /**
     * The iterative method for calculating fibonacci
     * @param i the input value
     * @return the long value of the fibonacci of the input
     */
    public static long fibonacciLim(int i) {
        long fib1 = 0;
        long fib2 = 1;
        int count = 0;
        while(count < i) {
            long temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
            count = count + 1;
        }
        return fib1;
    }
    /**
     * The iterative method for calculating fibonacci
     * @param i the input value
     * @return the BigInteger value of the fibonacci of the input
     */
    public static BigInteger fibonacciBIim(int i) {
        BigInteger fib1 = BigInteger.ZERO;
        BigInteger fib2 = BigInteger.ONE;
        int count = 0;
        while(count < i) {
            BigInteger temp = fib2;
            fib2 = fib1.add(fib2);
            fib1 = temp;
            count = count + 1;
        }
        return fib1;
    }
}
