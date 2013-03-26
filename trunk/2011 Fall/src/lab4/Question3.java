package lab4;

import java.util.ArrayList;

/**
 * @author khuang13
 *
 */
public class Question3 
{
	private ArrayList<ArrayList<Double>> alist = new ArrayList<ArrayList<Double>>();
		
	public void add(int i, double j)
	{
		if (i < alist.size()) {
			alist.get(i).add(j);
		} else {
			ArrayList<Double> temp = new ArrayList<Double>();
			temp.add(j);
			alist.add(temp);
		}
	}

	public void reset(double[][] array)
	{
		alist = null;
		alist = new ArrayList<ArrayList<Double>>();
		
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				alist.add(new ArrayList<Double>());
				if (array[i] != null) {
					for (int j = 0; j < array[i].length; j++) {
						alist.get(i).add(array[i][j]);
					}
				}
			}
		}
	}
	
	public double average()
	{
		double avg = 0.0;
		int count = 0;
		
		for(ArrayList<Double> a : alist) {
			for (Double d : a)	{
				if (d != null) {
					avg += d.doubleValue();
				}
				count++;
			}
		}
		
		return avg / count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Question3 test = new Question3();
		
		for (int i = 0; i < 10; i++) {
			double temp = Math.random() * 100;
			test.add(5, temp);
			System.out.println(temp);
		}
		System.out.println(test.average());
		
		test.reset(new double[][]{{1, 2},{ , }, null, {9, 8}, null});
		System.out.println(test.average());
	}
}
