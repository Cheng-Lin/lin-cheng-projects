package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public interface Edible
{
	final Color E_ORANGE = Color.ORANGE; 
	final Color E_RED = Color.RED;
	final Color E_PURPLE = new Color(128,100,162); 
	final Color E_GREEN = Color.GREEN;
	final Color E_YELLOW = Color.YELLOW;
	final Color E_PEACH = new Color(245,140,55);
	final Color E_BLUE = Color.BLUE;
	final Color E_BLACK = Color.BLACK;

	Color getColor(); 
	
	String getTaste(PrintWriter outFile);
}
