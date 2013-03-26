package from001to010;

public class Problem006 
{
	public static void main(String[] args)
	{
		int n = 100;
		long sumOfInt = n * (n + 1) / 2;
		sumOfInt *= sumOfInt;
		long sumOfSquared = n * (n + 1) * (2 * n + 1) / 6;
		long answer = sumOfInt - sumOfSquared;
		
		System.out.println(answer);
	}
}
