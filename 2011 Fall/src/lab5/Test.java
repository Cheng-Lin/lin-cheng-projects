package lab5;

import java.util.Arrays;

public class Test {
	double[][] array;
	
	private Test(double[][] array) {
		this.array = array;
	}
	
	private double[] rowSums() {
		double[] retVal = null;
		if (array != null) {
			retVal = new double[array.length]; 
			double sum = 0;
			for(int i = 0; i < array.length; i++) {
				if(array[i] != null) {
					for(double element : array[i]) {
						sum += element;
					}
					retVal[i] = sum;
					sum = 0;
				} else {
					retVal[i] = Double.NEGATIVE_INFINITY;
				}			
			}
		}
		return retVal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] row1 = {1,2,3,4};
		double[] row2 = {1,2,3};
		double[] row3 = {1,2};
		double[][] arr = new double[3][];
		arr[0] = row1;
		arr[1] = row2;
		arr[2] = row3;
		Test test = new Test(arr);
		System.out.println(Arrays.toString(test.rowSums()));
		double[] expected = {10,6,3};
		System.out.println("Expected value: " + Arrays.toString(expected));
	}
}
