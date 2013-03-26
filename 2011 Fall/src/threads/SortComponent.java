package threads;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   A component that displays the current state of the selection sort algorithm.
 */
public class SortComponent extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8875756474814972285L;

	/**
	 * Constructs the component.
	 * @param sorter TODO
	 */
	public SortComponent(Sorter sorter, int[] values)
	{
		this.sorter = sorter;
		sorter.setValues(values);
		sorter.setComponent(this);
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		sorter.draw(g2);
	}

	/**
      Starts a new animation thread.
	 */
	public void startAnimation()
	{
		class AnimationRunnable implements Runnable
		{
			public void run()
			{
				try
				{
					sorter.sort();
				}
				catch (InterruptedException exception)
				{
				}
			}
		}

		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}

	private Sorter sorter;
}

