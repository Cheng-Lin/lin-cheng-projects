package from001to010;

/**
 * Each new term in the Fibonacci sequence is generated by 
 * adding the previous two terms. By starting with 1 and 2, 
 * the first 10 terms will be:
 * 		1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose 
 * values do not exceed four million, find the sum of the 
 * even-valued terms.
 */

public class Problem002 
{
	public static void main(String[] args) 
	{
		int fib1 = 1;
		int fib2 = 2;
		int temp;
		int answer = 2;
		
		while(fib2 < 4000000)
		{
			temp = fib2;
			fib2 += fib1;
			fib1 = temp;
			
			if (fib2 % 2 == 0)
				answer += fib2;
		}
		
		System.out.println(answer);
	}
}
