package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public class Blueberry
	implements Edible
{
	private Color color = E_BLUE;
	private String screenResponse = "tastes like Blueberry";
	private String outputValue = "Blueberry selected";

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
