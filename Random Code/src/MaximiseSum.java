import java.util.Scanner;

public class MaximiseSum 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++)
		{
			int N = in.nextInt();
			long M = in.nextInt();
			long array[][] = new long[N][N];
			
			long max = 0;
			for (int j = 0; j < N; j++)
			{
				array[j][j] = in.nextInt() % M;
				if (max != M - 1) {
					if (max < array[j][j]) {
						max = array[j][j];
					}
					for (int k = 0; k < j; k++)
					{
						array[k][j] = (array[k][j - 1] + array[j][j]) % M;
						if (max < array[k][j]) {
							max = array[k][j];
						}
					}
				}
			}
			
			System.out.println(max);
		}
	}
}
