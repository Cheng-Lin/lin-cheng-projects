package assignment02;

/**
 * @author Ke-Bang Huang
 *
 */
public class Car
{
	int efficiency;
	int fuel;
	
	/**
	 * Constructor method
	 * 
	 * @param efficiency fuel efficiency of the car in miles/gallon with type int
	 */
	public Car(int efficiency)
	{
		this.efficiency = efficiency;
		this.fuel = 0;
	}
	
	/**
	 * Reduce fuel in the tank corresponding to the distance
	 * the car has driven in miles
	 * 
	 * @param miles distance the car drove in miles with type int
	 */
	public void drive(int miles)
	{
		fuel -= (int)((double)miles / efficiency + .5);		//round fuel used to a whole num
	}
	
	/**
	 * Getter method for the fuel in gallon left in the tank
	 * 
	 * @return fuel left in the tank in int
	 */
	public double getGasInTank()
	{
		return fuel;
	}
	
	/**
	 * Add fuels to the tank
	 * 
	 * @param gasoline amount of gasoline in gallon added
	 */
	public void addGas(int gasoline)
	{
		fuel += gasoline;
	}
}
