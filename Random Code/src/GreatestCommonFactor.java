import java.util.Scanner;

public class GreatestCommonFactor 
{
	public static void main(String[] args) 
	{
		try 
		{
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			for (int i = 0; i < n; i++) 
			{
				int length = input.nextInt();
				int width = input.nextInt();
				int currentPrime = 3;
				int gcf = 1;
				
				if (1 == length || 1 == width) {
					System.out.println(length * width);
					continue;
				}
				
				int tempL = length;
				int tempW = width;
				while (tempL % 2 == 0 && tempW % 2 == 0 && tempL != 0 && tempW != 0) {
					tempL /= 2;
					tempW /= 2;
					gcf *= 2;
				}
				
				int min = Math.min(length, width);
				while (currentPrime < length && currentPrime < width) 
				{
					while (tempL % currentPrime == 0 && tempW % currentPrime == 0) 
					{
						tempL /= currentPrime;
						tempW /= currentPrime;
						gcf *= currentPrime;
					}
					currentPrime = nextPrime(currentPrime, min);
				}
				
				System.out.println((length * width) / (gcf * gcf));
			}
			input.close();
		} catch (Exception e) {
	        System.err.println("Error:" + e.getMessage());
		}
	}
	
	private static int nextPrime(int currentPrime, int max) 
	{
		currentPrime += 2;		
		while (currentPrime <= max)
		{
			int limit = (int)Math.sqrt(currentPrime);
			boolean prime = true;
			
			if (currentPrime % 2 == 0) {
				prime = false;
				currentPrime += 2;
				continue;
			}
				
			for (int i = 3; i < limit && prime; i += 2)
				if (currentPrime % i == 0)
					prime = false;
			
			if (prime) {
				return currentPrime;
			} else {			
				currentPrime += 2;
			}
		}
		
		return max;
	}
}
