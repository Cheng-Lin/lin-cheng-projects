package assignment04;

/**
 * @author Ke-Bang Huang
 *
 */
public class InvestmentProjection
{

	/**
	 * Calculates the the final balance after numYears with 
	 * the given initialBalance and the annual percentage rate 
	 * of interest using Monthly Compounding
	 * 
	 * @param initialBalance the balance you start up with
	 * @param apr annual percentage rate of the interest
	 * @param numYears number of years has passed
	 * @return Final balance after numYears
	 */
	public static double futureBalance(double initialBalance, double apr, int numYears)
	{
		double futureBalance = initialBalance;
		
		for (int i = 1; i <= numYears * 12; i++)
		{
			futureBalance += futureBalance * apr / 12.0;
		}
		
		return futureBalance;
	}
	
	/**
	 * calculated how many years it will take to reach a balance 
	 * greater than or equal to the desiredBalance assuming the interest
	 * is calculated with monthly compounding
	 * 
	 * @param initialBalance the balance you start up with
	 * @param desiredBalance the balance you want to end up with
	 * @param apr annual percentage rate of the interest
	 * @return Number of year required to reach desired balance
	 */
	public static int waitTimeForBalance(double initialBalance, double desiredBalance, double apr)
	{
		int count = 11;				//so when divide the answer will always be round forward
		
		while (initialBalance < desiredBalance)
		{
			initialBalance += initialBalance * apr / 12.0;
			count++;
		}
		
		return count / 12;
	}
	
	/**
	 * calculates the minimum apr you need to go from 
	 * initialBalance to desiredBalance in numYears, 
	 * compounding monthly 
	 * 
	 * @param initialBalance the balance you start up with
	 * @param desiredBalance the desiredBalance you want to end up with
	 * @param numYears number of year you want it to take
	 * @return minimum annual percentage rate of the interest
	 */
	public static double neededRate(double initialBalance, double desiredBalance, int numYears)
	{
		double tempBalance;
		boolean overed;
		double overEstRate = (int)((desiredBalance / initialBalance / numYears) * 100 + .5);	//By assuming interest never changes
		overEstRate = (overEstRate - overEstRate % 25) / 100.0;									//Round down to multiple of .25
		
		do {
			tempBalance = initialBalance;
			overed = false;
			
			for (int i = 1; !overed && i < numYears * 12; i++) 
			{
				tempBalance += tempBalance * overEstRate / 12.0;
				if (tempBalance >= desiredBalance)
				{
					overed = true;
					overEstRate -= .25;
				}
			}			
		} while (overed);
			
		return overEstRate + .25;
	}
	
	/**
	 * Main method for testing the class
	 * @param args command line arguments are not used
	 */
	public static void main(String[] args) 
	{
		// Test Case 1
		System.out.println("Test case 1: ");
		
		System.out.println("The expect balance for initial balance of 1500, 5 year later with apr of 0.25 is 5168.71");
		System.out.println("The actual balance is: " + futureBalance(1500, 0.25, 5) + "\n");
		
		System.out.println("The expect year for initial balance of 1500 with apr of 0.25 to reach 5000 is 5 year");
		System.out.println("The actual year is: " + waitTimeForBalance(1500, 5000, .25) + "\n");
		
		System.out.println("The expect apr for initial balance of 1500 to reach 5000 in 5 year is .25");
		System.out.println("The actual apr is: " + neededRate(1500, 5000, 5) + "\n");
		
		// Test Case 2
		System.out.println("\n" + "Test case 2: ");
		
		System.out.println("The expect balance for initial balance of 2000, 5 year later with apr of 0.75 is 75991.73");
		System.out.println("The actual balance is: " + futureBalance(2000, 0.75, 5) + "\n");
		
		System.out.println("The expect year for initial balance of 2000 with apr of 0.75 to reach 76000 is 6 year");
		System.out.println("The actual year is: " + waitTimeForBalance(2000, 76000, .75) + "\n");
		
		System.out.println("The expect apr for initial balance of 2000 to reach 76000 in 5 year is 1.00");
		System.out.println("The actual apr is: " + neededRate(2000, 76000, 5) + "\n");
	}
}
