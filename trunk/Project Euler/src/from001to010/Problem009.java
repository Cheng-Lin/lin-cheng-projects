package from001to010;

public class Problem009 
{
	public static void main(String[] args)
	{
		int sum = 1000;
		int c = sum / 2 - 1;
		int b = sum / 2 - 2;
		int a = (int)(Math.sqrt(c * c - b * b) + 0.5);
		boolean within = true;
		boolean reached = false;
		
		a--;
		while (!reached)
		{
			c = sum / 2;
			a++;
			b = sum - c - a;
			within = true;
			double temp = 0;
			
			while (b < c && within)
			{
				b++;
				c--;
				temp = Math.sqrt(c * c - b * b);
				if (temp == (double)a)
				{
					reached = true;
					within = false;
				}
				else if (temp < (double)a)
				{
					within = false;
				}
			}
		}
		
		System.out.println(a + " " + b + " " + c);
		System.out.println(a * b * c);
	}
}
