package assignment05;

import java.util.ArrayList;

public class Question2 
{
	private ArrayList<double[]> array = new ArrayList<double[]>( );

	/**
	 * Add double[] as an element to array arraylist.
	 * 
	 * @param e double array thats adding to arraylist
	 * @return true if this collection changed as a result of the call
	 */
	public boolean add(double[] e) 
	{
		return array.add(e);
	}
	
	/**
	 * Calculate the avg of all the numbers stored in array.
	 * Skip all null and empty array during the calculation.
	 * avg = 0 if array is null.
	 * 
	 * @return average or 0 if array is null
	 */
	public double avg()
	{
		int count = 0;
		double avg = 0.0;
		
		if (array.size() > 0)
		{
			for (int i = 0; i < array.size(); i++)
			{
				if (array.get(i) != null)
				{
					for (int j = 0; j < array.get(i).length; j++)
					{
						avg += array.get(i)[j];
						count++;
					}
				}
			}
			
			avg /= count;
		}
		
		return avg;
	}

	/**
	 * Main method for testing the class
	 * @param args command line arguments are not used
	 */
	public static void main(String[] args)
	{
		Question2 test = new Question2();
		test.add(new double[]{1,2,3,4});
		
		System.out.println("The expect average for the list (1, 2, 3, 4) is 2.5.");
		System.out.println("The actual average is: " + test.avg() + "\n");
		
		test.add(null);
		test.add(new double[]{5, 6, 7, 8, 9});
		test.add(new double[]{});
		test.add(new double[]{10, 11, 12, 13, 14, 15});
		
		System.out.println("The expect averge for 1, 2, 3, 4 ... 14, 15 is 8.");
		System.out.println("The actual value is: " + test.avg());
	}
}
