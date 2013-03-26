package from011to020;

import java.util.Scanner;

public class Problem011 
{
	private final static int ROWS = 20;
	private final static int COLS = 20;
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int list[][] = new int[ROWS][COLS];
		int product = 0;
		int tProduct = 0;
		int i , j;
		
		for (i = 0; i < ROWS; i++)
		{
			list[i][0] = input.nextInt();
			list[i][1] = input.nextInt();
			list[i][2] = input.nextInt();
			list[i][3] = input.nextInt();
			
			tProduct = list[i][0] * list[i][1] * list[i][2] * list[i][3];
			
			if (tProduct > product)
				product = tProduct;
			
			for (j = 4; j < COLS; j++)
			{
				list[i][j] = input.nextInt();
				if (list[i][j] > list[i][j - 4])
				{
					tProduct = list[i][j - 3] * list[i][j - 2] * list[i][j - 1] * list[i][j];
					if (tProduct > product)
						product = tProduct;					
				}
			}
			
			input.nextLine();
		}
		
		for (j = 0; j < COLS; j++)
		{
			tProduct = list[0][j] * list[1][j] * list[2][j] * list[3][j];
			
			if (tProduct > product)
				product = tProduct;
			
			for (i = 4; i < ROWS; i++)
			{
				if (list[i][j] > list[i - 4][j])
				{
					tProduct = list[i - 3][j] * list[i - 2][j] * list[i - 1][j] * list[i][j];
					if (tProduct > product)
						product = tProduct;					
				}
			}
		}
		
		i = 0;
		j = 0;
		while (j < COLS - 3)
		{
			tProduct = list[i][j] + list[i + 1][j + 1] + list[i + 2][j + 2] + list[i + 3][j + 3];
			if (tProduct > product)
				product = tProduct;
			
			int j2 = j + 4;
			i = 4;
			while (j2 < COLS - 3)
			{
				if (list[i][j2] > list[i - 4][j2 - 4])
				{
					tProduct = list[i - 3][j2 - 3] * list[i - 2][j2 - 2] * list[i - 1][j2 - 1] * list[i][j2];
					if (tProduct > product)
						product = tProduct;
				}
				i++;
				j2++;
			}
			
			j++;
			i = 0;
		}
		i = 1;
		j = 0;
		while (i < ROWS - 3)
		{
			tProduct = list[i][j] + list[i + 1][j + 1] + list[i + 2][j + 2] + list[i + 3][j + 3];
			if (tProduct > product)
				product = tProduct;
			
			int i2 = i + 4;
			j = 4;
			while (i2 < ROWS - 3)
			{
				if (list[i2][j] > list[i2 - 4][j - 4])
				{
					tProduct = list[i2 - 3][j - 3] * list[i2 - 2][j - 2] * list[i2 - 1][j - 1] * list[i2][j];
					if (tProduct > product)
						product = tProduct;
				}
				i2++;
				j++;
			}
			
			i++;
			j = 0;
		}
		
		i = ROWS - 1;
		j = 0;
		while (j < COLS - 3)
		{
			tProduct = list[i][j] + list[i - 1][j + 1] + list[i - 2][j + 2] + list[i - 3][j + 3];
			if (tProduct > product)
				product = tProduct;
			
			int j2 = j + 4;
			i -= 4;
			while (j2 < COLS - 3)
			{
				if (list[i][j2] > list[i + 4][j2 - 4])
				{
					tProduct = list[i + 3][j2 - 3] * list[i + 2][j2 - 2] * list[i + 1][j2 - 1] * list[i][j2];
					if (tProduct > product)
						product = tProduct;
				}
				i--;
				j2++;
			}
			
			j++;
			i = ROWS - 1;
		}
		i = ROWS - 2;
		j = 0;
		while (i > 2)
		{
			tProduct = list[i][j] + list[i - 1][j + 1] + list[i - 2][j + 2] + list[i - 3][j + 3];
			if (tProduct > product)
				product = tProduct;
			
			int i2 = i - 4;
			j = 4;
			while (i2 > 2)
			{
				if (list[i2][j] > list[i2 + 4][j - 4])
				{
					tProduct = list[i2 + 3][j - 3] * list[i2 + 2][j - 2] * list[i2 + 1][j - 1] * list[i2][j];
					if (tProduct > product)
						product = tProduct;
				}
				i2--;
				j++;
			}
			
			i--;
			j = 0;
		}
		
		System.out.println(product);
	}
}
