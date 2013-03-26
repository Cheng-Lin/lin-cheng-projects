public class GameCell
{
	private int myRows, myColumns;
	private double gridWidth, gridHeight;
	private int[][] myLifes;
	private boolean[][] isLife;

	public int[][] nextGen(int rows, int columns, int lifes[][])
	{
		myRows = rows;
		myColumns = columns;
		myLifes = lifes;
		isLife = new boolean[myRows][myColumns];    

		int i, k;
		int tempRows, tempColumns;
		int count = 0;

		for (i = 0; i < myRows; i++)
		{
			for (k = 0; k < myColumns; k++)
			{
				tempRows = i;
				tempColumns = k;
				if (i == 0)
					tempRows = myRows;
				if (k == 0) 
					tempColumns = myColumns;
				if (myLifes[tempRows - 1][tempColumns - 1] >= 1)  
					count += 1;

				tempRows = i;
				tempColumns = k;
				if (i == 0)  
					tempRows = myRows;
				if (myLifes[tempRows - 1][tempColumns] >= 1)  
					count += 1;

				tempRows = i;
				tempColumns = k;
				if (i == 0)  
					tempRows = myRows;
				if (k == myColumns - 1)  
					tempColumns = -1;
				if (myLifes[tempRows - 1][tempColumns + 1] >= 1)  
					count += 1;

				tempRows = i;
				tempColumns = k;
				if (k == 0)  
					tempColumns = myColumns;
				if (myLifes[tempRows][tempColumns - 1] >= 1)  
					count += 1;

				tempRows = i;
				tempColumns = k;
				if (k == myColumns - 1)  
					tempColumns = -1;
				if (myLifes[tempRows][tempColumns + 1] >= 1)  
					count += 1;

				tempRows = i;
				tempColumns = k;
				if (i == myRows - 1)  
					tempRows = -1;
				if (k == 0)  
					tempColumns = myColumns;
				if (myLifes[tempRows + 1][tempColumns - 1] >= 1)  
					count += 1;

				tempRows = i;
				tempColumns = k;
				if (i == myRows - 1)  
					tempRows = -1;
				if (myLifes[tempRows + 1][tempColumns] >= 1)  
					count += 1;

				tempRows = i;
				tempColumns = k;
				if (i == myRows - 1)  
					tempRows = -1;
				if (k == myColumns - 1)  
					tempColumns = -1;
				if (myLifes[tempRows + 1][tempColumns + 1] >= 1)  
					count += 1;

				if (myLifes[i][k] >= 1)
				{
					if (count == 3 || count == 2)  
						isLife[i][k] = true;
					else
						isLife[i][k] = false;
				}
				else
				{
					if (count == 3)  
						isLife[i][k] = true;
					else
						isLife[i][k] = false;
				} 

				count = 0;
			}
		}

		for (i = 0; i < myRows; i++)
		{
			for (k = 0; k < myColumns; k++)
			{
				if (isLife[i][k] == true)
					myLifes[i][k] += 1;
				else
					myLifes[i][k] = 0;
			}
		}

		return myLifes;
	}
}