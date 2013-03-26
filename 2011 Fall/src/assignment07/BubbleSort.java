package assignment07;

public class BubbleSort 
{
	public static void sort(Measurable[] array)
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
