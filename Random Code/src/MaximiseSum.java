import java.util.HashSet;
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
			
			HashSet<Long> currResult = new HashSet<Long>();
			HashSet<Long> tempResult = new HashSet<Long>();
			
			long max = 0;
			for (int j = 0; j < N; j++)
			{
				long temp1 = in.nextInt() % M;
				if (max < temp1) {
					max = temp1;
				}
				tempResult.add(temp1);
				for (long l : currResult)
				{
					long temp2 = (l + temp1) % M;
					if (max < temp2) {
						max = temp2;
					}
					tempResult.add(temp2);
				}
				
				currResult = tempResult;
				tempResult = new HashSet<Long>();
			}
			
			System.out.println(max);
		}
	}
}
