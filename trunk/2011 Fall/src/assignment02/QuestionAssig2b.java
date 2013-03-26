package assignment02;

import java.util.Scanner;

public class QuestionAssig2b
{
	private float max;
	private float min;
	private float average;
	private float[] array;
	
	public void readFloatArray()
	{
		array = new float[12];
		Scanner keyboard = new Scanner(System.in);
		
		for(int i = 0; i < array.length; i++)
		{
			System.out.println("Enter a float value: ");
			if (keyboard.hasNextFloat()) {
				array[i] = keyboard.nextFloat();
			} else {
				System.out.println("Invalid Input!");
				array[i] = 0.0f;
			}
			keyboard.nextLine();
		}
	}
	
	public void analyzeArray()
	{
		max = min = average = array[0];
		
		for (int i = 1; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}
		
		for (int i = 1; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}
		
		for (int i = 1; i < array.length; i++) {
			average += array[i];
		}
		average /= array.length;
	}

	public float getMax() {
		return max;
	}

	public float getMin() {
		return min;
	}

	public float getAverage() {
		return average;
	}
}
