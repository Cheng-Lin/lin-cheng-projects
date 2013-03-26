package assignment03;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author khuang13
 *
 */
public class Question3
{
	/**
	 * asking for user input for acquiring student interest deduction
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		//testing purpose
		System.out.println("Test Example: 1250 interest, 100000 income, 500 deduction, and married is 396 deduction");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the amount of interest: ");
		int interest = Math.min(input.nextInt(), 2500);
		input.nextLine();

		System.out.println("Enter the total income: ");
		int income = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter the total of other deduction: ");
		int deduction = input.nextInt();
		input.nextLine();
		
		System.out.println("Are you married(y/n): ");
		boolean married = false;
		if (input.nextLine().compareToIgnoreCase("y") == 0)	{
			married = true;
		}
		
		int item9 = computeStudentInterestDeduction(interest, income, deduction, married);
		System.out.println("Total Student loan interest deduction is: " + item9);
	}
	
	/**
	 * Compute the student interest deduction
	 * 
	 * @param item1	the amount of interest
	 * @param item2	total income
	 * @param item3	total of other deduction
	 * @param mfj marital status
	 * @return student interest deduction
	 */
	public static int computeStudentInterestDeduction(int item1, int item2, int item3, boolean mfj)
	{
		int item4 = item2 - item3;
		
		int item5 = 60000;
		if (mfj) {
			item5 = 120000;
		}
		
		if (item4 > item5) {
			return item1;
		} else {
			int item6 = item5 - item4;
			
			double item7 = (Math.round(1000.0 * item6 / 15000)) / 1000.0;
			if(mfj) {
				item7 = (Math.round(1000.0 * item6 / 30000)) / 1000.0;
			} 
			if (item7 > 1.0) {
				 item7 = 1.0;
			}
			
			double item8 = item1 * item7;
			return (int)Math.round(item1 - item8);
		}
	}
}
