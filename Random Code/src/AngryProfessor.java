import java.util.Scanner;

public class AngryProfessor 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for (int i = 0; i < cases; i++)
		{
			int n = in.nextInt();
			int k = in.nextInt();
			
			int count = 0;
			for (int j = 0; j < n; j++)
			{
				if (in.nextInt() <= 0) {
					count++;
				}
			}
			
			if (count >= k) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
