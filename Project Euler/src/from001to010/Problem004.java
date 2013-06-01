package from001to010;

/**
 * A palindromic number reads the same both ways. The 
 * largest palindrome made from the product of two 2-digit 
 * numbers is 9009 = 91 99.
 *
 * Find the largest palindrome made from the product of two 
 * 3-digit numbers.
 */

public class Problem004
{
	public static void main(String[] args) 
	{
		int limit = 899;
		int result = 0;
		
		for (int i = 999; i >= limit && i >= 100; i--)
		{
			for (int j = i; j >= limit && j >= 100; j--)
			{
				int temp = i * j;
				
				int splitPoint1 = (new Integer(temp)).toString().length() / 2;
				int splitPoint2 = (new Integer(temp)).toString().length() - splitPoint1;
				int factor1 = (int)Math.pow(10, splitPoint2);
				int factor2 = (int)Math.pow(10, splitPoint1);
				
				int firstThree = temp / factor1;
				int firstReverse = 0;
				
				while (firstThree > 0)
				{
					firstReverse = firstReverse * 10 + firstThree % 10;
					firstThree /= 10;
				}
				
				if (firstReverse == temp % factor2 && temp > result)
				{
					result = temp;
					limit = j;
				}
			}
			
			if (result == 0)
				limit--;
		}
		
		System.out.println(result);
	}
}
