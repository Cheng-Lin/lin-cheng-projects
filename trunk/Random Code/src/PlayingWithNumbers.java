import java.util.Scanner;

// Faster version in repository

public class PlayingWithNumbers 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextInt()) 
		{
			int N = in.nextInt();
			
			int array[] = new int[N];
			for (int i = 0; i < N; i++)	{
				array[i] = in.nextInt();
			}
			
			int Q = in.nextInt();
			
			int x = in.nextInt();
			int sum = 0;
			for (int j = 0; j < N; j++)
			{
				array[j] += x;
				sum += Math.abs(array[j]);
			}
			System.out.println(sum);
			
			for (int i = 1; i < Q; i++) 
			{
				x = in.nextInt();
				int negSum = 0;
				int negCount = 0;
				for (int j = 0; j < N; j++)
				{
					int temp = array[j];
					array[j] += x;
					
					if (array[j] < 0 || temp < 0) {
						negSum += Math.abs(array[j]) - Math.abs(temp);
						negCount++;
					}
				}
				sum += x * (N - negCount) + negSum;
				System.out.println(sum);
			}
		}
	}
}
