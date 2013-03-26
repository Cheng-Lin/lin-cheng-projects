package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public class Strawberry
	implements Edible
{
	private Color color = E_RED;
	private String screenResponse = "tastes like Strawberry";
	private String outputValue = "Strawberry selected";

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
