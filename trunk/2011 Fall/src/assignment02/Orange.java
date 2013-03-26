package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public class Orange
	implements Edible
{
	private Color color = E_ORANGE;
	private String screenResponse = "tastes like Orange";
	private String outputValue = "Orange selected";

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
