package assignment03;

/**
 * 
 * @author khuang13
 *
 */
public class Question4
{
	/**
	 * main method used for testing purpose
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] rowsums, columnsums;
		int diag1, diag2;
		int[][] solution;
		boolean result;
		
		// Sample One
		rowsums = new int[] {16,19,10,28};
		columnsums = new int[] {7,19,19,28};
		diag1 = 19;
		diag2 = 17;
		solution = new int[][] {{4, 3, 2, 7}, {1, 4, 6, 8}, {1, 3, 2, 4}, {1, 9, 9, 9}};
		
		result = verifySolution(solution, rowsums, columnsums, diag1, diag2);
		
		if (result) {
			System.out.println("Solution 1 works!");
		} else {
			System.out.println("Solution 1 failed!");
		}
		System.out.println("Expected: Works");
		
		// Sample Two
		rowsums = new int[] {8,8,14,13};
		columnsums = new int[] {13,12,13, 5};
		diag1 = 12;
		diag2 = 14;
		solution = new int[][] {{3, 2, 1, 2}, {2, 2, 3, 1}, {3, 4, 6, 1}, {5, 4, 3, 1}};
		
		result = verifySolution(solution, rowsums, columnsums, diag1, diag2);
		
		if (result) {
			System.out.println("Solution 2 works!");
		} else {
			System.out.println("Solution 2 failed!");
		}
		System.out.println("Expected: Works");
	}
	
	/**
	 * Verify is solution works for the given probelm
	 * 
	 * @param solution giving solution for the problem
	 * @param rowsums what the sum of each row should be
	 * @param columnsums what the sum of each columns should be
	 * @param diag1 what the sum of the diagonal on the right bottom should be
	 * @param diag2 what the sum of the diagonal on the right top should be
	 * @return did the solution work out
	 */
	public static boolean verifySolution(int[][] solution, int[] rowsums, int[] columnsums, int diag1, int diag2)
	{
		boolean worked = true;
		
		for (int i = 0; i < 4 && worked; i++)
		{
			int test = 0;
			for (int j = 0; j < 4 && worked; j++)
			{
				if (solution[i][j] > 0 && solution[i][j] < 10) {
					test += solution[i][j];
				} else {
					worked = false;
				}
			}
			if (test != rowsums[i]) {
				worked = false;
			}
		}
		
		for (int j = 0; j < 4 && worked; j++)
		{
			int test = solution[0][j] + solution[1][j] + solution[2][j] + solution[3][j];
			if (test != columnsums[j]) {
				worked = false;
			}
		}
		
		int diagTest = 0;
		for (int x = 0; x < 4 && worked; x++)	{
			diagTest += solution[x][x];
		}
		if (diagTest != diag1) {
			worked = false;
		}
					
		diagTest = 0;		
		for (int y = 0; y < 4 && worked; y++)	{
			diagTest += solution[y][3 - y];
		}
		if (diagTest != diag2) {
			worked = false;
		}
		
		return worked;
	}
}
