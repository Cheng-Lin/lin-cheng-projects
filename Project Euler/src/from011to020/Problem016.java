package from011to020;

import java.util.ArrayList;

public class Problem016 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(2);

		boolean ten = false;
		boolean addOne = false;

		for (int i = 2; i <= 1000; i++)
		{
			for (int j = 0; j < num.size(); j++)
			{
				if (num.get(j) < 5) {
					if (ten) {
						num.set(j, num.get(j) * 2 + 1);
						ten = false;
					} else {
						num.set(j, num.get(j) * 2);
					}
				} else {
					if (ten) {
						num.set(j, num.get(j) * 2 % 10 + 1);
					} else {
						num.set(j, num.get(j) * 2 % 10);
					}
					ten = true;
				}
			}

			if (ten)
			{
				num.add(1);
				ten = false;
			}
		}

		int sum = 0;
		for (Integer i : num)
			sum += i;

		System.out.println(num);
		System.out.println(sum);
	}
}
