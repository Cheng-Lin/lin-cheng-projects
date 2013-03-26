package assignment08;

public class BubbleSort 
{
	public static void sort(Measurable[] array)
	{
		if (array != null)
		{
			boolean changed = true;

			while (changed)
			{
				changed = false;

				for (int i = 0; i < array.length - 1; i++)
				{
					if (array[i].getMeasure() > array[i + 1].getMeasure())
					{
						changed = true;
						Measurable temp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = temp;
					}
				}
			}
		}
	}
	
	public static void sort(Object[] array, Measurer meas)
	{
		if (array != null)
		{
			boolean changed = true;

			while (changed)
			{
				changed = false;

				for (int i = 0; i < array.length - 1; i++)
				{
					if (meas.measure(array[i]) > meas.measure(array[i + 1]))
					{
						changed = true;
						Object temp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = temp;
					}
				}
			}
		}
	}
}
