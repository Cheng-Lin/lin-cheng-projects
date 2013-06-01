package from001to010;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, 
 * and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

public class Problem007 
{
	public static void main(String[] args) 
	{
		int first = 2;
		int second = 3;
		int num = second;
		int count = 2;
		int end = 10001;
		
		while (count != end)
		{
			num += 2;
			int limit = (int)(Math.sqrt(num) + 0.5);
			
			boolean notFind = true;
			while (notFind)
			{
				for (int j = 2; j <= limit && notFind; j++)
				{
					if (num % j == 0)
						notFind = false;
				}
				
				if (!notFind) {
					num += 2;
					notFind = true;
				} else {
					notFind = false;
				}
			}
			
			count++;
		}
		
		System.out.println(num);
	}
}
