package assignment02;

import java.awt.Color;
import java.io.PrintWriter;

public class Plum
	implements Edible
{
	private Color color = E_PURPLE;
	private String screenResponse = "tastes like Plum";
	private String outputValue = "Plum selected";

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
