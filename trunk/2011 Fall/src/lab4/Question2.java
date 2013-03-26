package lab4;

import java.util.ArrayList;

/**
 * @author khuang13
 *
 */
public class Question2 
{
	//double[] array;
	private ArrayList<double[]> array = new ArrayList<double[]>();

	public boolean add(double[] e) {
		return array.add(e);
	}
	
	public double getAverage()
	{
		double avg = 0.0;
		int count = 0;
		
		if (array != null) {
			for (int i = 0; i < array.size(); i++) {
				if(array.get(i) != null) {
					for (int j = 0; j < array.get(i).length; j++) {
						avg += array.get(i)[j];
						count++;
					}
				}
			}
		}
		
		return avg / count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Question2 test = new Question2();
		test.add(new double[]{1,2,3,4});
		
		System.out.println(test.getAverage());
	}
}
