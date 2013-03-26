package from001to010;

public class Problem003
{
	public static void main(String[] args)
	{
		long number = 600851475143L;
		int count = 2;
		
		while (true)
		{
			int limit = (int)Math.sqrt(count);
			boolean prime = true;
			
			for (int i = 2; i < limit && prime; i++)
				if (count % i == 0L)
					prime = false;
			
			if (prime && number % count == 0L)
			{
				if (number == count)
					break;
				else {
					number /= count;
					count = 1;
				}
			}
			
			count++;
		}
		
		System.out.println(number);
	}
}
