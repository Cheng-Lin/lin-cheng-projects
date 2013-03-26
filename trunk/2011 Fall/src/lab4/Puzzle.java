package lab4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class to represent a puzzle from called "challenger" (r)
 * (c)2011 by King Features Syndicate, Inc.
 * World Rights reserved.
 * @author CS 140
 *
 */
public class Puzzle {
	private int[][] array;
	private int[] rowSums;
	private int[] columnSums; 
	// major diagonal goes top-left to bottom-right
	// minor diagonal goes bottom-left to top-right
	private int majorDiagonal;
	private int minorDiagonal;

	/**
	 * Constructor which sets the original layout of
	 * the puzzle (row, column, and diagonal sums together
	 * with one given number in each row. The initial
	 * array has a 0 in the places where the puzzle has
	 * blanks.
	 * @param array initial array with 0 for blanks and one
	 * initial value on each line
	 * @param rowSums the four sums of the four rows
	 * @param columnSums the four sums of the four columns
	 * @param majorDiagonal the sum of the main diagonal
	 * @param minorDiagonal the sum of the minor diagonal
	 */
	private Puzzle(int[][] array, int[] rowSums, int[] columnSums,
			int majorDiagonal, int minorDiagonal) {
		this.array = array;
		this.rowSums = rowSums;
		this.columnSums = columnSums;
		this.majorDiagonal = majorDiagonal;
		this.minorDiagonal = minorDiagonal;
	}

	/**
	 * Method to check if a completed 4x4 matrix satisfies
	 * all the row-, column- and diagonal-sum conditions.
	 * @param trial a completed 4x4 array of integers in the
	 * range 1 through 9.
	 * @return true if the trial matrix satifies all the conditions
	 * of the puzzle, otherwise false
	 */
	public boolean checkSolution(int[][] trial) {

		boolean ok = true;
		
		for (int i = 0; i < 4 && ok; i++)
		{
			int test = 0;
			for (int j = 0; j < 4 && ok; j++)
			{
				if (trial[i][j] > 0 && trial[i][j] < 10) {
					test += trial[i][j];
				} else {
					ok = false;
				}
			}
			if (test != rowSums[i]) {
				ok = false;
			}
		}
		
		for (int j = 0; j < 4 && ok; j++)
		{
			int test = trial[0][j] + trial[1][j] + trial[2][j] + trial[3][j];
			if (test != columnSums[j]) {
				ok = false;
			}
		}
		
		int diagTest = 0;
		for (int x = 0; x < 4 && ok; x++)	{
			diagTest += trial[x][x];
		}
		if (diagTest != majorDiagonal) {
			ok = false;
		}
					
		diagTest = 0;		
		for (int y = 0; y < 4 && ok; y++)	{
			diagTest += trial[y][3 - y];
		}
		if (diagTest != minorDiagonal) {
			ok = false;
		}
		
		return ok;
	}

	/**
	 * Very brute force recursive method doing a depth
	 * first search for a solution. All possible values
	 * are tried in all of the blank spaces until a
	 * solution is found.
	 * This method solves the first sample puzzle in a few
	 * seconds but takes a long time for the second sample
	 * puzzle (1 hour 40 minutes in my test).
	 * The method works through as many as 9^12 (9 to the power
	 * 12) = 282,429,536,481 possible values until a solution
	 * is found.
	 * @param trial the matrix solution being filled in by
	 * the recursive calls to this method
	 * @param row the row of the cell that is being filled 
	 * with all possible values
	 * @param col the column of the cell that is being filled 
	 * with all possible values
	 * @return true if the value placed in this cell
	 * leads to a solution of the puzzle, otherwise false.
	 */
	public boolean solve(int[][] trial, int row, int col) {
		boolean returnValue = false;
		if(row == 4) {
			returnValue = checkSolution(trial);			
		} else { 
			int nextRow = row;
			int nextCol = col;
			if (col < 3) {
				nextCol = col + 1;
			} else if (col == 3) { 
				nextRow = row + 1;
			    nextCol = 0;
			}
			
			if (array[row][col] > 0)
			{
				trial[row][col] = array[row][col];
				returnValue = solve(trial, nextRow, nextCol);
			} else {
				int i = 1;
				boolean solved = false;
				
				while (i <= 9 && !solved)
				{
					trial[row][col] = i;
					solved = solve(trial, nextRow, nextCol);
					i++;
				}
				
				returnValue = solved;
			}
		}
		return returnValue;
	}

	/** 
	 * A much faster version of this recursion,
	 * where the sums of the rows and columns are
	 * used to determine the values in the last row
	 * and column, instead of trying every value.
	 * The method works through up to 9^6 (9 to the power
	 * 6) = 531,441 possible values until a solution
	 * is found.
	 * @param trial the matrix solution being filled in by
	 * the recursive calls to this method
	 * @param row the row of the cell that is being filled 
	 * with all possible values
	 * @param col the column of the cell that is being filled 
	 * with all possible values
	 * @return true if the value placed in this cell
	 * leads to a solution of the puzzle, otherwise false.
	 */
	public boolean solve1(int[][] trial, int row, int col) {
		boolean returnValue = false;

		if(row == 3 && col == 3)
		{
			if (array[3][3] > 0) {
				trial[3][3] = array[3][3];
			} else {
				trial[3][3] = rowSums[3] - trial[3][0] - trial[3][1] - trial[3][2];
			}
			returnValue = checkSolution(trial);
		}
		else if (row == 3 && col < 3)
		{
			if (array[3][col] > 0) {
				trial[3][col] = array[3][col];
			} else {
				trial[3][col] = columnSums[col] - trial[0][col] - trial[1][col] - trial[2][col];
			}
			
			if (trial[3][col] > 9 || trial[3][col] < 1)
				returnValue = false;
			else
				returnValue = solve1(trial, 3, col + 1);
		}
		else if (row < 3)
		{
			int nextRow = row;
			int nextCol = col;
			
			if (col < 3) {
				nextCol = col + 1;
			} else if (col == 3) { 
				nextRow = row + 1;
			    nextCol = 0;
			}
			
			if (array[row][col] > 0)
			{
				trial[row][col] = array[row][col];
				returnValue = solve(trial, nextRow, nextCol);
			} else {
				if (col == 3)
				{
					trial[row][3] = rowSums[row] - trial[row][0] - trial[row][1] - trial[row][2];
					if (trial[row][3] > 9 && trial[row][3] < 1)	{
						returnValue = false;
					} else {
						returnValue = solve(trial, nextRow, nextCol);
					}
				} else {
					int i = 1;
					boolean solved = false;
					
					while (i <= 9 && !solved)
					{
						trial[row][col] = i;
						solved = solve(trial, nextRow, nextCol);
						i++;
					}
					
					returnValue = solved;
				}
			}
		}

		return returnValue;
	}

	public static void main(String[] args) {
		int[][] array = {{0,0,0,8},{9,0,0,0},{0,0,5,0},{0,1,0,0}};
		int[] rowSums = {11,16,24,21};
		int[] columnSums = {28,9,16,19};
		int diag1 = 12;
		int diag2 = 23;
		Puzzle p1 = new Puzzle(array,rowSums,columnSums,diag1,diag2);

		int[][] trial = new int[4][4];
		if(p1.solve1(trial, 0, 0)) {
			System.out.println(Arrays.toString(trial[0]));
			System.out.println(Arrays.toString(trial[1]));
			System.out.println(Arrays.toString(trial[2]));
			System.out.println(Arrays.toString(trial[3]));
		} else System.out.println("Failed");

		array = new int[][]{{6,0,0,0},{0,0,0,9},{0,9,0,0},{0,0,7,0}};
		rowSums = new int[]{27,27,30,30};
		columnSums = new int[]{28,32,24,30};
		diag1 = 26;
		diag2 = 31;
		Puzzle p2 = new Puzzle(array,rowSums,columnSums,diag1,diag2);

		trial = new int[4][4];
		if(p2.solve1(trial, 0, 0)) {
			System.out.println(Arrays.toString(trial[0]));
			System.out.println(Arrays.toString(trial[1]));
			System.out.println(Arrays.toString(trial[2]));
			System.out.println(Arrays.toString(trial[3]));
		} else System.out.println("Failed");
		long t1 = System.currentTimeMillis();
		trial = new int[4][4];
		if(p2.solve(trial, 0, 0)) {
			System.out.println(Arrays.toString(trial[0]));
			System.out.println(Arrays.toString(trial[1]));
			System.out.println(Arrays.toString(trial[2]));
			System.out.println(Arrays.toString(trial[3]));
		} else System.out.println("Failed");
		long t2 = System.currentTimeMillis();
		System.out.println("Time = " + ((t2-t1)/1000.0));
	}
}
