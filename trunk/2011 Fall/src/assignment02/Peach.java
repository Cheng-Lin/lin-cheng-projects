package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public class Peach
	implements Edible
{
	private Color color = E_PEACH;
	private String screenResponse = "tastes like Peach";
	private String outputValue = "Peach selected";

	public Color getColor()
	{
		return color;
	}

	public String getTaste(PrintWriter outFile) 
	{
		outFile.println(outputValue); 
		return screenResponse;
	}
}
