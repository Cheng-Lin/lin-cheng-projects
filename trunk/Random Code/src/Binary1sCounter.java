//2's complement
// 
//One of the basics of Computer Science is knowing how numbers are represented in 2's complement. Imagine that you write down all numbers between A and B inclusive in 2's complement representation using 32 bits. How many 1's will you write down in all ?
// 
//Input:
//The first line contains the number of test cases T (<1000). Each of the next T lines contains two integers A and B.
// 
//Output:
//Output T lines, one corresponding to each test case.
// 
//Constraints:
//-2^31 <= A <= B <= 2^31 - 1
//
//
//Sample Input:
//3
//-2 0
//-3 4
//-1 4
// 
//Sample Output:
//63
//99
//37
// 
//
//Explanation:
//For the first case, -2 contains 31 1's followed by a 0, -1 contains 32 1's and 0 contains 0 1's. Thus the total is 63.
//For the second case, the answer is 31 + 31 + 32 + 0 + 1 + 1 + 2 + 1 = 99

import java.util.*;

public class Binary1sCounter 
{
	public static void main(String[] args)
	{
		try {
			Scanner input = new Scanner(System.in);
			if (input.hasNextInt())
			{
				int num = input.nextInt();
				input.nextLine();
				long total = 0L;
				long diff = 0L;

				for (int i = 0; i < num && input.hasNextLong(); ++i)
				{
					total = 0;
					diff = 0;
					long a = input.nextLong();
					long b = input.nextLong();
	
					if (a == b)
					{
						total = Integer.bitCount((int)a);
						diff = 0;
					}
					else if (b < 0)
					{
						total = binaryAlgorithm(a);
						diff = binaryAlgorithm(b + 1);
					}
					else if (a > 0)
					{
						total = binaryAlgorithm(b);
						diff = binaryAlgorithm(a - 1);
					}
					else
					{
						total = binaryAlgorithm(b);
						diff = -binaryAlgorithm(a);
					}

					System.out.println(total - diff);
				}
			}
			input.close();
	    } catch (Exception e) {
	        System.err.println("Error:" + e.getMessage());
	    }
	}

	/**
	 * Algorithm for this problem
	 * @param target what number to stop count from zero
	 * @return total 1s in all the 2's comp number passed
	 */
	public static long binaryAlgorithm(long target)
	{
		int count = 0;
		long diff = Math.abs(target);
		long sum = 0L;
		
		boolean neg = false;
		if (diff != target)
		{
			neg = true;
			diff--;
		}

		while (diff != 0)
		{
			int n = (int)(Math.log(diff)/Math.log(2));
			long num = (long)(Math.pow(2, n));
			sum += (long)Math.pow(2, n - 1) * n + num * count + 1;
			diff = diff - num;
			count++;
		}

		return neg? 32L * (Math.abs(target)) - sum: sum;
	}
}