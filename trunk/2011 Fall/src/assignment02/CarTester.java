package assignment02;

/**
 * @author Ke-Bang Huang
 * 
 */
public class CarTester
{
	/**
	 * Main method with tests of the method of Car
	 * 
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args)
	{
		Car myHybrid = new Car(50); 					// 50 miles to the gallon 
		myHybrid.addGas(30);							// Tank 30 gallons 
		myHybrid.drive(100); 							// Drive 100 miles 
		System.out.println(myHybrid.getGasInTank()); 	// Get gas remaining in tank 
	}
}
