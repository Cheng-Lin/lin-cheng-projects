package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public class Blackberry
	implements Edible
{
	private Color color = E_BLACK;
	private String screenResponse = "tastes like Blackberry";
	private String outputValue = "Apple Blackberry";

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
