package lab5;
/**
 * Very simplistic representation of a Car
 * emphasizing its efficiency 
 * @author CS 140
 *
 */
public class Car {
	private int efficiency;
	private double gasInTank;
	/**
	 * Constructor that initializes the gas consumption 
	 * (miles per gallon) of the car
	 * @param consumption
	 */
	public Car(int efficiency) {
		this.efficiency = efficiency;
	}
	
	/**
	 * Adds gas to the gas tank--we assume the amount
	 * never overflows the tank
	 * @param amount amount of gas added to the tank--
	 * assume it is rounded to the nearest gallon 
	 */
	public void addGas(int amount) {
		gasInTank += amount;
	}
	
	/**
	 * Simulates driving the car a certain distance. The gas
	 * consumed is computed based on the gas consumption
	 * of the car
	 * @param distance the distance driven
	 */
	public void drive(int distance) {
		double gasConsumed = (double)distance/efficiency;
		gasInTank -= gasConsumed;
	}

	/**
	 * Returns the gas consumption of the car
	 * @return the value set for the gas consumption
	 */
	public int getEfficiency() {
		return efficiency;
	}

	/**
	 * Returns the current amount of gas in the tank
	 * @return the gas in the tank
	 */
	public double getGasInTank() {
		return gasInTank;
	}
}
