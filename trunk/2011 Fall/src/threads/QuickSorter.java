package threads;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/**
 * This class sorts an array, using the quicksort 
 * algorithm.
 */
public class QuickSorter implements Sorter
{
	public QuickSorter()
	{
	}   

	/**
      Sorts the array managed by this merge sorter
	 */
	@Override
	public void sort() throws InterruptedException
	{  
		sort(0, a.length - 1);
	}

	public void sort(int from, int to) 
	throws InterruptedException
	{
		int p;
		if (from >= to) {
			pause(1);
			return;
		}
		pause(1); //compare
		p = partition(from, to);
		sort(from, p);
		pause(1); // method call
		sort(p + 1, to);
		pause(1); // method call
	}

	private int partition(int from, int to) 
	throws InterruptedException
	{
		int pivot = a[from];
		markedPosition1 = from;
		alreadySorted = from;
		int i = from - 1;
		int j = to + 1;
		while (i < j)
		{
			i++;
			pause(1); // arithmetic
			while (a[i] < pivot) {
				SortViewer.sortStateLock.lock();
				try
				{
					i++;
					markedPosition1 = i;
				}
				finally
				{
					SortViewer.sortStateLock.unlock();
				}
				pause(1); // compare
			}
			j--; 
			pause(1); // arithmetic
			while (a[j] > pivot) {
				SortViewer.sortStateLock.lock();
				try
				{
					j--;
					markedPosition2 = j;
				}
				finally
				{
					SortViewer.sortStateLock.unlock();
				}
				pause(1); //compare
			}
			if (i < j) {
				SortViewer.sortStateLock.lock();
				try
				{
					swap(i, j); 
					markedPosition1 = i;
					markedPosition2 = j;
				}
				finally
				{
					SortViewer.sortStateLock.unlock();
				}
				pause(1); // swap
			}
			pause(1); //compare
		}
		return j;
	}


	/**
      Swaps two entries of the array.
      @param i the first position to swap
      @param j the second position to swap
	 */
	private void swap(int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * Draws the current state of the sorting algorithm.
	 * @param g2 the graphics context
	 */
	@Override
	public void draw(Graphics2D g2)
	{
		SortViewer.sortStateLock.lock();
		try
		{
			int deltaX = component.getWidth() / a.length;
			for (int i = 0; i < a.length; i++)
			{
				if (i == markedPosition2)
					g2.setColor(Color.RED);
				else if (i == markedPosition1)
					g2.setColor(Color.GREEN);
				else if (i <= alreadySorted)
					g2.setColor(Color.BLUE);
				else
					g2.setColor(Color.BLACK);
				g2.draw(new Line2D.Double(20 + i * deltaX, 0, 
						20 + i * deltaX, a[i]));
			}
		}
		finally
		{
			SortViewer.sortStateLock.unlock();
		}
	}

	/**
	 * Pauses the animation.
	 * @param steps the number of steps to pause
	 */
	public void pause(int steps) throws InterruptedException
	{
		component.repaint();
		Thread.sleep(steps * DELAY);
	}


	/**
	 * @param anArray the array to sort
	 */
	@Override
	public void setValues(int[] values) {
		a = values;
	}

	/**
	 * @param aComponent the component to be repainted when the 
	 * animation pauses
	 */
	@Override
	public void setComponent(JComponent aComponent) {
		component = aComponent;
	}

	private int[] a;
	// private Lock sortStateLock;

	// The component is repainted when the animation is paused
	private JComponent component;   

	// These fields are needed for drawing 
	private int markedPosition1 = -1;
	private int markedPosition2 = -1;
	private int alreadySorted = -1;

	private static final int DELAY = SortViewer.DELAY;

}
