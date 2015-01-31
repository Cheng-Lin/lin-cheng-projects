import java.util.Scanner;

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
			for (int i = 0; i < Q; i++) 
			{
				int x = in.nextInt();
				int sum = 0;
				for (int j = 0; j < N; j++)
				{
					array[j] += x;
					sum += Math.abs(array[j]);
				}
				System.out.println(sum);
			}
		}
	}
}
