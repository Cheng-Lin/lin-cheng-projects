package from011to020;

public class Problem015 
{
	public static void main(String[] args) 
	{
		int size = 20;		//if size = 1 then result = 2;
		long[] pattern = new long[size * 2 - 1];
		
		for (int i = 0; i < pattern.length; i++)
		{
			pattern[i] = i + 1;
		}
		
		int count = 2;
		while (count <= size - 1)
		{
			for (int i = 1; i <= pattern.length - count; i++)
			{
				pattern[i] = pattern[i - 1] + pattern[i];
			}
			count++;
		}
		
		long result = 0;
		
		for (int i = 0; i < size + 1; i++)
		{
			result+=pattern[i];
		}
		
		System.out.println(result);
	}
}
