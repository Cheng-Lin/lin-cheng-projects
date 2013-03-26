package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public class Banana
	implements Edible
{
	private Color color = E_YELLOW;
	private String screenResponse = "tastes like Yellow";
	private String outputValue = "Yellow selected";

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
