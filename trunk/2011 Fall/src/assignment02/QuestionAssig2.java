package assignment02;

import java.util.Scanner;

public class QuestionAssig2
{
	public static void main(String[] args)
	{
		float[] testArray = new float[12];
		Scanner keyboard = new Scanner(System.in);
		boolean inputOK = true;
		
		for(int i = 0; i < testArray.length && inputOK; i++)
		{
			System.out.println("Enter a float value: ");
			if (keyboard.hasNextFloat()) {
				testArray[i] = keyboard.nextFloat();
			} else {
				inputOK = false;
			}
			keyboard.nextLine();
		}
		
		if (inputOK)
		{
			float max, min, avg; 
			max = min = avg = testArray[0];
			
			for (int i = 1; i < testArray.length; i++) {
				max = Math.max(max, testArray[i]);
			}
			System.out.println("The maximum is: " + max);
			
			for (int i = 1; i < testArray.length; i++) {
				min = Math.min(min, testArray[i]);
			}
			System.out.println("The minimum is: " + min);
			
			for (int i = 1; i < testArray.length; i++) {
				avg += testArray[i];
			}
			avg /= testArray.length;
			System.out.println("The average is: " + avg);
		} else {
			System.out.println("Wrong Input");
		}
	}
}
