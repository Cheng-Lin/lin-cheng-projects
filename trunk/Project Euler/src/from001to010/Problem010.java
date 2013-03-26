package from001to010;

public class Problem010 
{
	public static void main(String[] args)
	{
		int n = 0;
		long sum = 0;
		int target = 2000000;

		while (n < target) {
			n++;
			if (isPrime(n))
				sum += n;
		}

		System.out.println(sum);
	}

	public static boolean isPrime(int num)
	{
		boolean returnValue = true;

		if (num == 1) {
			returnValue = false;
		} else if (num < 4) {
			returnValue = true;
		} else if (num % 2 == 0) {
			returnValue = false;
		} else if (num < 9) {
			returnValue = true;
		} else if (num % 3 == 0) {
			returnValue = false;
		} else {
			int limit = (int)(Math.sqrt(num));
			int i = 5;
			while (i <= limit && returnValue)
			{
				if (num % i == 0)
					returnValue = false;
				if (num % (i + 2) == 0)
					returnValue = false;
				i += 6;
			}
		}

		return returnValue;
	}
}
