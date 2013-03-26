package from001to010;

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
