package assignment07;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
	private int determinant;
	private boolean determinantKnown = false;
	private int[][] array;
	private int numRows;

	/**
	 * Constructor for Matrix
	 * @param elements a list of numbers that are
	 * the elements of a 2-dimensional matrix
	 */
	public Matrix(int... elements) {
		// if elements == null
		// throw an IllegalArgumentException with the message
		// "is null"
		if (elements == null) {
			throw new IllegalArgumentException("is null");
		}

		// set numRows and assign it to the rounded value of 
		// the square root of elements.length, cast to an int. 
		numRows = (int)(Math.sqrt(elements.length) + 0.5);

		// if numRows*numRows is not equal to elements.length
		// throw an IllegalArgumentException with the message
		// "Inputs do not give a square matrix"
		if (numRows * numRows != elements.length) {
			throw new IllegalArgumentException("Inputs do not give a square matrix");
		}

		// Now instantiate array as a numRows x numRows
		// 2-dimensional array
		array = new int[numRows][numRows];

		// Put values in the array using 2 for loops
		// using i and j and setting
		// array[i][j] = elements[numRows*i+j];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numRows; j ++) {
				array[i][j] = elements[numRows * i + j];
			}
		}
	}

	/**
	 * This works the way hashCode does. If the determinant
	 * was already computed, return the value. Otherwise,
	 * compute the determinant, save the value and return
	 * the computed value.
	 * @return the determinant of the Matrix
	 */
	public int getDeterminant() {
		if(!determinantKnown) {
			determinant = computeDeterminant(array);
		}
		determinantKnown = true;
		return determinant;		
	}

	/**
	 * Internal-use only private method to compute
	 * a determinant
	 * @param arr a 2-dimensional array
	 * @return the determinant of the array
	 * @throws IllegalArgumentException if the array is
	 * null or not square.
	 */
	private static int computeDeterminant(int[][] arr) {
		int retVal = 0;

		// if arr is null throw an IllegalArgumentException
		// with the message "Input is null"
		if (arr == null) {
			throw new IllegalArgumentException("Input is null");
		}

		// check for not square:
		// in a for loop: for each row arr[i]
		// if arr.length != arr[i].length throw an
		// IllegalArgumentException with the 
		// message "Input is not a square matrix"
		for (int i = 0; i < arr.length; i++) {
			if (arr.length != arr[i].length) {
				throw new IllegalArgumentException("Input is not a square matrix");
			}
		}

		// if arr,length is 1, set retVal to arr[0][0]
		// else
		// ... introduce an int sign = -1
		// ... in a for loop for each row arr[i] 
		// ... ... change the sign using sign = -sign;
		// ... ... create the "minor" matrix for arr[i][0]:
		// ... ... int[][] minor = a square array with (arr.length-1)
		// ... ... rows and columns
		// ... ... fill the minor using
		// ... ... for(int j = 0; j < i; j++) {
		// ... ...	 System.arraycopy(arr[j], 1, minor[j], 0, arr.length-1);
		// ... ... }
		// ... ... for(int j = i+1; j < arr.length; j++) {
		// ... ...   System.arraycopy(arr[j], 1, minor[j-1], 0, arr.length-1);
		// ... ... }
		// ... ... add sign*arr[i][0]*computeDeterminant(minor); to retVall
		if (arr.length == 1) {
			retVal = arr[0][0];
		} else {
			int sign = -1;
			for (int i = 0; i < arr.length; i++) {
				sign = -sign;
				
				int[][] minor = new int[arr.length - 1][arr.length - 1];
				for(int j = 0; j < i; j++) {
					System.arraycopy(arr[j], 1, minor[j], 0, arr.length-1);
				}
				for(int j = i+1; j < arr.length; j++) {
					System.arraycopy(arr[j], 1, minor[j - 1], 0, arr.length-1);
				}
				
				retVal += (sign * arr[i][0] * computeDeterminant(minor));
			}
		}
		
		return retVal;
	}

	/**
	 * Getter for numRows
	 * @return numRows
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/**
	 * Compute sum of the major diagonal of the matrix
	 * @return sum of the major diagonal of the matrix
	 */
	public int getDiagonal()
	{
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i][i];
		}
		
		return sum;
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(Arrays.toString(array[i]) + "\n");
		}
		return sb.toString();
	}

	public static void main(String[]args) {
		Matrix[] matrixes = new Matrix[5];
		matrixes[0] = new Matrix(0,4,0,-3,1,1,5,2,1,-2,0,6,3,0,0,1);
		matrixes[1] = new Matrix(1,2,3,4,-1,-2,-3,-4,7,8,9,0,-7,-8,-9,-6);
		matrixes[2] = new Matrix(11,22,33,44,55,66,77,88,99);
		matrixes[3] = new Matrix(34,12,67,34,8,23,87,23,45,12,56,34, 13, 31,354, 65);
		matrixes[4] = new Matrix(9, 9, 9, 9, 9, 9, 9, 9 , 9, 9, 9, 9, 9, 9, 9,9, 9, 9, 9, 9,9, 9, 9, 9, 9);

		for (Matrix m : matrixes) {
			System.out.println(m.toString());
		}
		Arrays.sort(matrixes, new CompareNumRows());
		System.out.println("---------------------------------------");
		
		for (Matrix m : matrixes) {
			System.out.println(m.toString());
		}
		Arrays.sort(matrixes, new CompareMajorDiagonal());
		System.out.println("---------------------------------------");
		
		for (Matrix m : matrixes) {
			System.out.println(m.toString());
		}
		Arrays.sort(matrixes, new CompareDeterminant());
		System.out.println("---------------------------------------");
		
		for (Matrix m : matrixes) {
			System.out.println(m.toString());
		}
	}
}
