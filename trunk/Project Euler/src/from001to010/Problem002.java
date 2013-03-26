package from001to010;

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
