package threads;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/**
   This class sorts an array, using the selection sort 
   algorithm.
 */
public class DoubleBubbleSorter implements Sorter
{
	/**
	 * Constructs a selection sorter.
	 */
	public DoubleBubbleSorter()
	{
	}

	/**
      Sorts the array managed by this selection sorter.
	 */
	@Override
	public void sort() throws InterruptedException
	{  
		int lastChanged = a.length;
		int firstChanged = 0;
		if (a != null) {
			boolean changed = true;
			while(changed) {
				changed = false;
				for(int i = 0; i < a.length-1; i++) {
					SortViewer.sortStateLock.lock();
					try
					{
						if(a[i] > a[i+1]) {
							markedPosition = i+1;
							swap(i, i+1);
							lastChanged = i+1;
							changed = true;
						}
					}
					finally
					{
						SortViewer.sortStateLock.unlock();
					}
					pause(1);
				}
				alreadySortedRight = lastChanged;
				if (changed) {
					for(int i = Math.min(alreadySortedRight, a.length-2); i >= 0; i--) {
						SortViewer.sortStateLock.lock();
						try
						{
							if(a[i] > a[i+1]) {
								markedPosition = i;
								swap(i, i+1);
								lastChanged = i;
								changed = true;
							}
						}
						finally
						{
							SortViewer.sortStateLock.unlock();
						}
						pause(1);
					}
				}
			}
		}
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
      Draws the current state of the sorting algorithm.
      @param g2 the graphics context
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
				if (i == markedPosition)
					g2.setColor(Color.RED);
				else if (i < alreadySortedLeft || i > alreadySortedRight)
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
      Pauses the animation.
      @param steps the number of steps to pause
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
	private int markedPosition = -1;
	private int alreadySortedRight = Integer.MAX_VALUE;

	private static final int DELAY = SortViewer.DELAY;
	private int alreadySortedLeft = -1;
}
