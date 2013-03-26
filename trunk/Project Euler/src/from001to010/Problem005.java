package from001to010;

public class Problem005 
{
	public static void main(String[] args) 
	{
		int end = 20;
		int start = end / 2 + 1;
		boolean continues = true;
		long primeFactor = 1;
		long overallFactor = 1;
		
		for (int i = start; i <= end; i++)
		{
			continues = true;
			int limit = (int)(Math.sqrt(i) + 0.5);
			
			for (int j = 2; j <= limit && continues; j++)
			{
				if (i % j == 0)
					continues = false;
			}
			
			if (continues)
				primeFactor *= i;
			overallFactor *= i;
		}
		
		System.out.println(primeFactor + " " + overallFactor);

		long result = overallFactor;
		continues = true;
		while (overallFactor > primeFactor)
		{
			continues = true;
			overallFactor -= primeFactor;
			
			for (int i = start; i <= end && continues; i++)
			{
				if (overallFactor % i != 0)
					continues = false;
			}
			
			if (continues)
				result = overallFactor;
		}
		
		System.out.println(result);
	}
}
