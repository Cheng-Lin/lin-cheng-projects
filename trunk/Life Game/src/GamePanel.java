import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel
	implements ActionListener, MouseListener
{
	private int rows, columns, lives;
	private double gridWidth, gridHeight;
	private int lifes[][];
	GameCell cells;
	Timer gen;

	public GamePanel()
	{
		rows = 1;
		columns = 1;
		lifes = new int[rows][columns];
		lives = 0;
		gridWidth = (double)super.getWidth() / (columns > 1? columns:1);
		gridHeight = (double)super.getHeight() / (rows > 1? rows:1);
		gen = new Timer(100, this);
		cells = new GameCell();
		addMouseListener(this);
	}

	public void newGen(int numRows, int numColumns, int numLives)
	{
		rows = numRows;
		columns = numColumns;
		lifes = new int[rows][columns];

		lives = numLives;

		int ramRows, ramColumns;
		for (int i = 1; i <= lives; i++)
		{
			ramRows = (int)((rows - 1) * Math.random() + .5);
			ramColumns = (int)((columns - 1) * Math.random() + .5);
			if (lifes[ramRows][ramColumns] != 1)
				lifes[ramRows][ramColumns] = 1;
			else
			{
				while (lifes[ramRows][ramColumns] == 1)
				{
					ramRows = (int)((rows - 1) * Math.random() + .5);
					ramColumns = (int)((columns - 1) * Math.random() + .5);
				}
				lifes[ramRows][ramColumns] = 1;
			}
		}

		repaint();
	}

	public void nextGen()
	{
		lifes = cells.nextGen(rows, columns, lifes);

		repaint();
	}

	public void autoON()
	{
		gen.start();
	}

	public void autoOFF()
	{
		gen.stop();
	}

	public void paint(Graphics g)
	{
		super.paint(g);    

		int r, c;
		Color myColors;
		Graphics2D g2 = (Graphics2D)g;
		Line2D lines;
		Rectangle2D rects;

		gridWidth = (double)super.getWidth() / (columns > 1? columns:1);
		gridHeight = (double)super.getHeight() / (rows > 1? rows:1);

		for (r = 0; r < rows; r++)
		{
			for (c = 0; c < columns; c++)
			{
				if (lifes[r][c] <= 15 && lifes[r][c] > 0)
				{
					myColors = new Color(0, 255 - (lifes[r][c] * 17), 0);
				}
				else if (lifes[r][c] > 15)
				{
					myColors = new Color(0, 0, 0);
				}
				else
				{
					myColors = new Color(255, 255, 255);
				}

				g2.setColor(myColors);
				rects = new Rectangle2D.Double(c * gridWidth, r * gridHeight, gridWidth, gridHeight);
				g2.fill(rects);
			}
		}

		for (r = 1; r < rows; r++)
		{
			g2.setColor(Color.black);
			lines = new Line2D.Double(0, r * gridHeight, getWidth(), r * gridHeight);
			g2.draw(lines);
		}
		for (c = 1; c < columns; c++)
		{
			g2.setColor(Color.black);
			lines = new Line2D.Double(c * gridWidth, 0, c * gridWidth, getHeight());
			g2.draw(lines);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		lifes = cells.nextGen(rows, columns, lifes);

		repaint();
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	// Not used:
	public void mousePressed(MouseEvent e)
	{
		double x = e.getX();
		double y = e.getY();

		int positionX = (int)(x / gridWidth), positionY = (int)(y / gridHeight);

		if (lifes[positionY][positionX] >= 1)
			lifes[positionY][positionX] = 0;
		else
			lifes[positionY][positionX] = 1;

		//lifes[positionY][positionX] = (lifes[positionX][positionY] > 0 ? 0:1);

		repaint();
	}
	public void mouseReleased(MouseEvent e)
	{
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
}