package from011to020;

public class Problem014 
{
	public static void main(String[] args)
	{
		int[] list = new int[1000000];
		list[0] = 1;
		int maxCount = 1;
		int answer = 1;
		int count;
		long temp;
		
		for (int i = 2; i <= list.length; i++)
		{
			temp = i;
			count = 1;
	
			while (temp >= i)
			{
				if (temp % 2 == 0) {
					temp /= 2;
				} else {
					temp = 3 * temp + 1;
				}
				count++;
			}
			
			list[i - 1] = count + list[(int)temp - 1] - 1;
			
			if (maxCount < list[i - 1])
			{
				maxCount = list[i - 1];
				answer = i;
			}
		}
		
		System.out.println(answer);
	}
}
