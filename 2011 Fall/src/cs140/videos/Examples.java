package cs140.videos;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;


public class Examples {
	public static double arrayMax(double[] array) {
		double retVal = 0;
		if(array != null && array.length > 0) {
			retVal = array[0];
			for(double d : array) {
				retVal = d > retVal?d:retVal;
			}
		}
		return retVal;
	}

	public static double arrayMin(double[] array) {
		double retVal = 0;
		if(array != null && array.length > 0) {
			retVal = array[0];
			for(double d : array) {
				retVal = d < retVal?d:retVal;
			}
		}
		return retVal;
	}
	
	public static double average(double[] array) {
		double retVal = 0;
		if(array != null && array.length > 0) {
			for(double d : array) {
				retVal += d;
			}
			retVal /= array.length;
		}
		return retVal;
	}

	public static int firstMaxIndex(double[] array) {
		int retIndex = -1;
		double max = 0;
		if(array != null && array.length > 0) {
			max = array[0];
			retIndex = 0;
			for(int i = 0; i < array.length; i++) {
				if(array[i] > max) {
					retIndex = i;
					max = array[i];
				}
			}
		}
		return retIndex;
	}
	
	public static int firstMinIndex(double[] array) {
		int retIndex = -1;
		double min = 0;
		if(array != null && array.length > 0) {
			min = array[0];
			retIndex = 0;
			for(int i = 0; i < array.length; i++) {
				if(array[i] < min) {
					retIndex = i;
					min = array[i];
				}
			}
		}
		return retIndex;
	}

	public static void insertionSort(double[] array) {
		if(array != null && array.length > 0) {
			for(int i = 0; i < array.length; i++) {
				double next = array[i];
				int j = i;
				while(j > 0 && array[j-1] > next) {
					array[j] = array[j-1];
					j--;
				}
				array[j] = next;
			}
		}
	}

	public static BigDecimal arrayMax(BigDecimal[] array) {
		BigDecimal retVal = null;
		if(array != null && array.length > 0) {
			for(BigDecimal d : array) {
				if(retVal != null && d != null) {
					retVal = d.compareTo(retVal) > 0?d:retVal;
				} else if(retVal == null && d != null) {
					retVal = d;
				}
			}
		}
		return retVal;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(1+2+" is the sum of 1 and 2");
		System.out.println("the sum of 1 and 2 is "+1+2);
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
		int count = 0;
		Scanner input = new Scanner(new File("out.txt"));		
		while(++count > 0 && 
				input.hasNextLine() && 
				input.nextLine().length() >= 0) {
		}
		System.out.println(count-1);
	}
}
