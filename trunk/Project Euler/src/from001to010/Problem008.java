package from001to010;

/**
 * Find the greatest product of five consecutive digits 
 * in the 1000-digit number.
 * 		73167176531330624919225119674426574742355349194934
 * 		96983520312774506326239578318016984801869478851843
 * 		85861560789112949495459501737958331952853208805511
 *		12540698747158523863050715693290963295227443043557
 *		66896648950445244523161731856403098711121722383113
 *		62229893423380308135336276614282806444486645238749
 * 		30358907296290491560440772390713810515859307960866
 * 		70172427121883998797908792274921901699720888093776
 *		65727333001053367881220235421809751254540594752243
 * 		52584907711670556013604839586446706324415722155397
 *		53697817977846174064955149290862569321978468622482
 *		83972241375657056057490261407972968652414535100474
 *		82166370484403199890008895243450658541227588666881
 *		16427171479924442928230863465674813919123162824586
 *		17866458359124566529476545682848912883142607690042
 *		24219022671055626321111109370544217506941658960408
 *		07198403850962455444362981230987879927244284909188
 *		84580156166097919133875499200524063689912560717606
 *		05886116467109405077541002256983155200055935729725
 *		71636269561882670428252483600823257530420752963450
 */

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
