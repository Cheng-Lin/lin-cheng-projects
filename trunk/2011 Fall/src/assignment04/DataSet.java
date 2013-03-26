package assignment04;

import java.util.ArrayList;

/**
   Computes the average of a set of data values.
 */
public class DataSet
{
	private ArrayList<Double> backup = new ArrayList<Double>();
	private double minimum;	
	private double sum;
	private double maximum;
	private int count;

	/**
      Constructs an empty data set.
	 */
	public DataSet()
	{
		sum = 0;
		count = 0;
		maximum = 0;
		minimum = 0;
	}

	/**
      Adds a data value to the data set
      @param x a data value
	 */
	public void add(double x)
	{
		backup.add(x);
		sum = sum + x;
		if (count == 0 || maximum < x) maximum = x;
		if (count == 0 || minimum > x) minimum = x;
		count++;
	}

	/**
      Gets the average of the added data.
      @return the average or 0 if no data has been added
	 */
	public double getAverage()
	{
		if (count == 0) return 0;
		else return sum / count;
	}

	/**
      Gets the largest of the added data.
      @return the maximum or 0 if no data has been added
	 */
	public double getMaximum()
	{
		return maximum;
	}

	/**
      Gets the smallest of the added data.
      @return the minimum or 0 if no data has been added
	 */
	public double getMinimum()
	{
		return minimum;
	}

	/**
	 * Calculate min, max, avg using the backup list and
	 * compare the result with the method provided by class
	 * @return true if numbers are all matched up,
	 * 		   false otherwise
	 */
	public boolean checkValues()
	{
		boolean same = true;

		double avg = 0.0;
		for (double i : backup) {
			avg += i;
		}
		same = avg / backup.size() == getAverage();

		if (same) {
			double min = backup.get(0);
			for (int i = 1; i < backup.size(); i++) {
				if (min > backup.get(i)) {
					min = backup.get(i);
				}
			}
			same = min == getMinimum();
		}

		if (same) {
			double max = backup.get(0);
			for (int i = 1; i < backup.size(); i++) {
				if (max < backup.get(i)) {
					max = backup.get(i);
				}
			}
			same = max == getMaximum();
		}

		return same;
	}

	/**
	 * add some extra number to the backup list
	 * to test if checkValue can return false
	 */
	public void corruptBackup( )
	{
		backup.add(Math.random() * 100.0);
		
		while ((int)(Math.random() * 5) < 3)
		{
			backup.add(Math.random() * 100.0);
		}
	}
	
	/**
	 * Main method for testing the class
	 * @param args command line arguments are not used
	 */
	public static void main(String[] args) 
	{
		DataSet test = new DataSet();
		
		while ((int)(Math.random() * 10) < 9)
		{
			double temp = Math.random() * 100.0;
			test.add(temp);
			System.out.println(temp);
		}
		
		System.out.println("\n" + "Average: " + test.getAverage());
		System.out.println("Minimum: " + test.getMinimum());
		System.out.println("Maximum: " + test.getMaximum());
		System.out.println("Check Values Return: " + test.checkValues());
		
		test.corruptBackup();
		System.out.println("\n" + "Back up corrupted!");
		System.out.println("Check Values Return: " + test.checkValues());		
	}
}
