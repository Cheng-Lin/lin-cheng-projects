package lab7;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
/**
 * Driver class that creates a JFrame to hold the 
 * component that shows a drawing of a polygon, 
 * connecting the points provided by the main method. 
 * 
 * @author CS 140
 *
 */
public class GraphSortResults {
	/**
	 * An implementation of the bubble sort algorithm
	 * @param sortme array to be sorted
	 */
	public void bubblesort(double[] sortme) {


	}

	void shellsort(double[] sortme) { 
		int j;
		double v;
		int[] incs = { 1391376, 463792, 198768, 86961, 33936,
				13776, 4592, 1968, 861, 336, 
				112, 48, 21, 7, 3, 1 };
		for (int k = 0; k < 16; k++) 
			for (int h = incs[k], i = h; i < sortme.length; i++) { 
				v = sortme[i]; 
				j = i;
				while (j >= h && sortme[j-h] > v) { 
					sortme[j] = sortme[j-h]; 
					j -= h;
				}
				sortme[j] = v; 
			} 
	}

	public void insertionSort(double[] a) {
		for (int i = 1; i < a.length; i++) {
			double next = a[i];
			// Move all larger elements up
			int j = i;
			while (j > 0 && a[j-1] > next) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = next;
		}
	}

	/**
	 * Main method draws a JFrame and places the
	 * component with the polygon inside that
	 * frame. The main method is also responsible for
	 * adding the points of the polygon to the 
	 * component. In this case the polygon is a graph
	 * of the times taken to do sorts of arrays of
	 * increasing size
	 * @param args command line arguments are not used
	 */
	public static void main(String[] args) {
		GraphSortResults gs = new GraphSortResults();
		double[] arr = {5,2,8,3,0,3,1,4,6,8,0,2};
		//Arrays.sort(arr);
		//gs.shellsort(arr);
		gs.insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		JFrame frame = new JFrame();

		Random r = new Random();
		int factor = 10000;
		double[] x = {0,1,2,3,4,5,6,7,8,9};
		double[] y1 = new double[x.length];
		double[] y2 = new double[x.length];
		double[] y3 = new double[x.length];
		double[] sample; 
		double[] sampleCopy; 
		double[] sampleCopy2;
		for (int i = 1; i < x.length; i++) {
			sample = new double[factor*i];
			for(int j = 0; j < sample.length; j++) {
				sample[j] = r.nextDouble();
			}
			sampleCopy = sample.clone();
			sampleCopy2 = sample.clone();
			long start = System.currentTimeMillis();
			gs.shellsort(sample);
			//gs.insertionSort(sample);
			long end = System.currentTimeMillis();
			y1[i] = end-start;
			System.out.println(y1[i]);
			start = System.currentTimeMillis();
			Arrays.sort(sampleCopy);
			end = System.currentTimeMillis();
			y2[i] = end-start;
			System.out.println(y2[i]);
			start = System.currentTimeMillis();
			gs.insertionSort(sampleCopy2);
			end = System.currentTimeMillis();
			y3[i] = end-start;
			System.out.println(y3[i]);
		}
		double k = Math.max(Math.max(y1[x.length-1],y2[x.length-1]),y3[x.length-1]);
		for(int i = 1; i < x.length; i++) {
			x[i] = 20 + 500*x[i]/x[x.length-1];
		}
		for(int i = 0; i < x.length; i++) {
			y1[i] = 550 - 550*y1[i]/k;
		}
		for(int i = 0; i < x.length; i++) {
			y2[i] = 550 - 550*y2[i]/k;
		}
		for(int i = 0; i < x.length; i++) {
			y3[i] = 550 - 550*y3[i]/k;
		}
		frame.setSize(540, 600);
		frame.setTitle("Times");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Graph component = new Graph(x,y1,y2,y3);

		frame.add(component);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
