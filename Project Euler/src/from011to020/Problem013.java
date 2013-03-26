package from011to020;

import java.util.Scanner;

public class Problem013 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double num = 0;
		double sum = 0;
		
		while (true)
		{
			num = input.nextDouble();
			sum += num;
			System.out.println(sum);
		}
	}
}
