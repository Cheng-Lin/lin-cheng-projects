package assignment03;

/**
 * 
 * @author Ke-Bang Huang
 *
 */
public class Balloon
{
	double volume;
	double surfaceArea;
	double radius;
	
	/**
	 * Constructor method create an empty balloon
	 */
	public Balloon()
	{
		volume = 0.0;
		surfaceArea = 0.0;
		radius = 0.0;
	}
	
	/**
	 * Add air to the balloon
	 * Change the value for radius, surface area, and volume
	 * @param amount of air added in cm^3
	 */
	public void addAir(double amount)
	{
		volume += amount;
		radius = Math.pow(volume * 3.0 / 4.0 / Math.PI, 1.0 / 3.0);
		surfaceArea = 4 * Math.PI * radius * radius;
	}
	
	/**
	 * Getter method for volume
	 * @return volume
	 */
	public double getVolume()
	{
		return volume;
	}
	
	/**
	 * Getter method for surface area
	 * @return surfaceArea
	 */
	public double getSurfaceArea()
	{
		return surfaceArea;
	}
	
	/**
	 * Getter method for radius
	 * @return radius
	 */
	public double getRadius()
	{
		return radius;
	}
}
