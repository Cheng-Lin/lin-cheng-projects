package from001to010;

import java.util.Scanner;

public class Problem008 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		String line = input.nextLine();
		int[][] list = new int[20][line.length()];
		int sum = 0;
		int product = 0;

		long start = System.currentTimeMillis();
		for (int i = 0; i < 20; i++)
		{
			list[i][0] = Integer.parseInt(line.substring(0, 1));
			list[i][1] = Integer.parseInt(line.substring(1, 2));
			list[i][2] = Integer.parseInt(line.substring(2, 3));
			list[i][3] = Integer.parseInt(line.substring(3, 4));
			list[i][4] = Integer.parseInt(line.substring(4, 5));

			int temp = list[i][0] + list[i][1] + list[i][2] + list[i][3] + list[i][4];
			int temp2 = list[i][0] * list[i][1] * list[i][2] * list[i][3] * list[i][4];

			if (temp2 > product)
			{
				sum = temp;
				product = temp2;
			}

			for (int j = 5; j < line.length(); j++)
			{
				list[i][j] = Integer.parseInt(line.substring(j, j + 1));
				if (list[i][j] > list[i][j - 5])
				{
					temp = (list[i][j - 4] + list[i][j - 3] + list[i][j - 2] + list[i][j - 1] + list[i][j]);
					if (temp >= sum)
					{
						temp2 = list[i][j - 4] * list[i][j - 3] * list[i][j - 2] * list[i][j - 1] * list[i][j];
						if (temp2 > product)
						{
							sum = temp;
							product = temp2;
						}
					}
				}
			}

			if (i < 19)
				line = input.nextLine();
		}

		for (int i = 0; i < list[0].length; i++)
		{			
			int temp = list[0][i] + list[1][i] + list[2][i] + list[3][i] + list[4][i];
			int temp2 = list[0][i] * list[1][i] * list[2][i] * list[3][i] * list[4][i];

			if (temp2 > product)
			{
				sum = temp;
				product = temp2;
			}
			for (int j = 5; j < list.length; j++)
			{
				if (list[j][i] > list[j - 5][i])
				{
					temp = (list[j - 4][i] + list[j - 3][i] + list[j - 2][i] + list[j - 1][i] + list[j][i]);
					if (temp >= sum)
					{
						temp2 = list[j - 4][i] * list[j - 3][i] * list[j - 2][i] * list[j - 1][i] * list[j][i];
						if (temp2 > product)
						{
							sum = temp;
							product = temp2;
						}
					}
				}
			}
		}

		long stop = System.currentTimeMillis();
		//
		System.out.println(stop + " " + start + " " + (stop - start));
		System.out.println(product);
	}
}
