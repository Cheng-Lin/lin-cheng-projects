package from011to020;

public class Problem012 
{
	public static void main(String[] args) 
	{
		int totalDivisors = 500;
		int min = totalDivisors * totalDivisors / 4;
		int triangleNum = 1;
		int count = 2;
		int factor = 1;

		while (triangleNum < min)
		{
			triangleNum += count;
			count++;
		}
		
		while (factor < totalDivisors)
		{
			triangleNum += count;
			double tempLimit = Math.sqrt(triangleNum);
			int limit = (int)(tempLimit);
			
			if ((double)limit == tempLimit)
				factor = 3;
			else
			{
				factor = 2;
				limit++;
			}
			
			for (int i = 2; i < limit; i++)
			{
				if (triangleNum % i == 0)
					factor += 2;
			}
			
			count++;
		}
		
		System.out.println(triangleNum);
	}
}
