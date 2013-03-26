package from001to010;

public class Problem001
{
	public static void main(String[] args)
	{
		int answer = 0;
		//int count = 1;
		
		for (int i = 0; i < 1000; i += 3) {
			answer += i;
			//count++;
		}
		
		for (int i = 0; i < 1000; i += 5) {
			if (i % 3 != 0)
				answer += i;
			//count++;
		}
		
		System.out.println(answer);
		//System.out.println(count);
	}
}
