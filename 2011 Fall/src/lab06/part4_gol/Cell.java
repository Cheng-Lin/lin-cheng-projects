package lab06.part4_gol;
/**
 * Individual Cell in the grid of the Game of Life. It has a state called
 * "alive" which indicates whether it should appear as a black square or a
 * white square in the graphic
 * @author CS 140
 */
public class Cell
{
	private boolean alive;
	private int myRow;
	private int myCol;
	private Cell[] neighbors;
	/**
	 * Initialize the position and "alive" status of the Cell
	 * @param row the row location of this cell
	 * @param col the column location of this cell
	 */
	public Cell(int row, int col) 
	{
		alive = false;
		myRow = row;
		myCol = col;
		neighbors = new Cell[8];
	}
	/**
	 * Called by CellGrid at the beginning of the simulation to set up the
	 * list of neighbors of each Cell
	 * @param cells
	 */
	public void populateNeighbors(Cell[][] cells) 
	{
		if (myRow == 0)
		{
			neighbors[0] = null;
			neighbors[1] = null;
			neighbors[2] = null;
			neighbors[6] = cells[myRow + 1][myCol];
			if (myCol == 0)
			{
				neighbors[3] = null;
				neighbors[4] = cells[myRow][myCol + 1];
				neighbors[5] = null;
				neighbors[7] = cells[myRow + 1][myCol + 1];
			}
			else if (myCol == cells[myRow].length - 1)
			{
				neighbors[3] = cells[myRow][myCol - 1];
				neighbors[4] = null;
				neighbors[5] = cells[myRow + 1][myCol - 1];
				neighbors[7] = null;
			}
			else
			{
				neighbors[3] = cells[myRow][myCol - 1];
				neighbors[4] = cells[myRow][myCol + 1];
				neighbors[5] = cells[myRow + 1][myCol - 1];
				neighbors[7] = cells[myRow + 1][myCol + 1];
			}
		}
		else if (myRow == cells.length - 1)
		{
			neighbors[5] = null;
			neighbors[6] = null;
			neighbors[7] = null;
			neighbors[1] = cells[myRow - 1][myCol];
			if (myCol == 0)
			{
				neighbors[0] = null;
				neighbors[2] = cells[myRow - 1][myCol + 1];
				neighbors[3] = null;
				neighbors[4] = cells[myRow][myCol + 1];

			}
			else if (myCol == cells[myRow].length - 1)
			{
				neighbors[0] = cells[myRow - 1][myCol - 1];
				neighbors[2] = null;
				neighbors[3] = cells[myRow][myCol - 1];
				neighbors[4] = null;
			}
			else
			{
				neighbors[0] = cells[myRow - 1][myCol - 1];
				neighbors[2] = cells[myRow - 1][myCol + 1];
				neighbors[3] = cells[myRow][myCol - 1];
				neighbors[4] = cells[myRow][myCol + 1];
			}
		}
		else
		{
			neighbors[1] = cells[myRow - 1][myCol];
			neighbors[6] = cells[myRow + 1][myCol];
			if (myCol == 0)
			{
				neighbors[0] = null;
				neighbors[2] = cells[myRow - 1][myCol + 1];
				neighbors[3] = null;
				neighbors[4] = cells[myRow][myCol + 1];
				neighbors[5] = null;
				neighbors[7] = cells[myRow + 1][myCol + 1];
			}
			else if (myCol == cells[myRow].length - 1)
			{
				neighbors[0] = cells[myRow - 1][myCol - 1];
				neighbors[2] = null;
				neighbors[3] = cells[myRow][myCol - 1];
				neighbors[4] = null;
				neighbors[5] = cells[myRow + 1][myCol - 1];
				neighbors[7] = null;
			}	
			else
			{
				neighbors[0] = cells[myRow - 1][myCol - 1];
				neighbors[2] = cells[myRow - 1][myCol + 1];
				neighbors[3] = cells[myRow][myCol - 1];
				neighbors[4] = cells[myRow][myCol + 1];
				neighbors[5] = cells[myRow + 1][myCol - 1];
				neighbors[7] = cells[myRow + 1][myCol + 1];
			}
		}
	}
	/**
	 * Gets the "alive" state of this cell
	 * @return the alive value
	 */
	public boolean isAlive()
	{
		return alive;
	}
	/**
	 * Sets the "alive" status of this cell
	 * @param alive the value of alive to be set
	 */
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}
	/**
	 * This is the key to the whole Game of Life.
	 * You can read more online and at the end of Chapter 7
	 * of Horstman. 
	 * + Calculate the number of live neighbors, call that "count"
	 * + If this cell is alive and "count" is 0,1,4,5,6,7,8 return false
	 *   (the cell dies of loneliness (count = 0,1) or dies of starvation 
	 *   (count = 4,5,6,7,8)
	 * + If this cell is not alive and "count" is _exactly_ 3, return true
	 *   a new cell is born
	 * + in all other cases return "alive" the current state of the cell.
	 * @return true if this Cell will be alive in next generation
	 */
	public boolean aliveNextTime() {
		// YOU ARE ALLOWED TO USE MULTIPLE RETURNS
		// REMEMBER SOME neighbors[i] can be null
		// on the sides and the corners
		boolean alive = false;
		int count = 0;
		
		for (int i = 0; i < neighbors.length; i++)
		{
			if (neighbors[i] != null)
			{
				if (neighbors[i].isAlive())
					count++;
			}
		}
		
		if ((isAlive() && count == 2) || count == 3)
			alive = true;
		
		return alive;
	}
}
