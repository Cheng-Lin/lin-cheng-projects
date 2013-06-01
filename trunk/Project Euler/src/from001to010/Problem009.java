package from001to010;

/**
 * A Pythagorean triplet is a set of three natural numbers, 
 * a  b  c, for which,
 * 		a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which 
 * a + b + c = 1000.
 * Find the product abc.
 */

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
