import java.util.Scanner;

/**
 * N book with page number p1, p2, ..., pn, 
 * K copier, 1 min per page
 * Find minimum amount of time required to finish copying
 */
public class Transcription 
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in); 
		final int TEST_CASES = stdin.nextInt();
		
		for (int i = 0; i < TEST_CASES; i++) 
		{
			int N = stdin.nextInt();
			int K = stdin.nextInt();
			
			int[] p = new int[N];
			for (int j = 0; j < N; j++) {
				p[j] = stdin.nextInt();
			}
			
			int result;
			if (K >= N)
			{
				int max = p[0];
				for (int j = 1; j < N; j++) {
					if (p[j] > max) {
						max = p[j];
					}
				}
				result = max;
			}
			else 
			{
				int[][] table = new int[K][N];
				
				table[0][0] = p[0];
				for (int y = 1; y < N; y++) {
					table[0][y] = table[0][y-1] + p[y];
				}
				
				for (int x = 1; x < K; x++) 
				{
					for (int y = x + 1; y < N; y++) 
					{
						int min = Integer.MAX_VALUE;
						int sum = 0;
						for (int a = x; a <= y; a++) {
							sum += p[a];
						}
						
						for (int z = x; z <= y; z++) {
							int max = Math.max(table[x-1][z-1], sum);
							if (max < min) {
								min = max;
							}
							sum -= p[z];
						}
						table[x][y] = min;
					}
				}
				
				result = table[K-1][N-1];
			}
			
			System.out.println(result);
		}
		
		stdin.close();
	}
}