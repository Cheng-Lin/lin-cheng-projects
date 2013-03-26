package threads;
import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;

public class SortViewer
{
	public static int DELAY = 1; // was 5
	public static Lock sortStateLock = new ReentrantLock();

	public static void main(String[] args)
	{
		JFrame frame1 = new JFrame();
		JFrame frame2 = new JFrame();
		final int FRAME_WIDTH = 900;
		final int FRAME_HEIGHT = 500;

		frame1.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLocationRelativeTo(null);

		int[] values = ArrayUtil.randomIntArray(400, 400);

		//Arrays.sort(values);


		int[] valuesCopy = values.clone();
		Sorter sorter1 = new SelectionSorter();
		//Sorter sorter2 = new BubbleSorter();
		Sorter sorter2 = new DoubleBubbleSorter();
		//Sorter sorter2 = new QuickSorter();

		final SortComponent component1 = 
				new SortComponent(sorter1, values);
		frame1.add(component1, BorderLayout.CENTER);

		frame1.setVisible(true);
		component1.startAnimation();
		final SortComponent component2 = 
				new SortComponent(sorter2, valuesCopy);
		frame2.add(component2, BorderLayout.CENTER);

		frame2.setVisible(true);
		component2.startAnimation();
	}
}