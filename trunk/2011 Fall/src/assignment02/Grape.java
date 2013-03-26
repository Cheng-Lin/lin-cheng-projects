package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public class Grape
	implements Edible
{
	private Color color = E_GREEN;
	private String screenResponse = "tastes like Grape";
	private String outputValue = "Grape selected";

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
