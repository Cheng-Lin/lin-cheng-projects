package lab5;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
	Car car;
	@Before
	public void setUp() throws Exception {
		car = new Car(20);
	}

	@Test
	public void testCar() {
		assertNotNull("the constructor creates an object", car);
// NOTE: When checking double values, we need to give the
// permissible error as the last argument: 
		assertEquals("the initial gas in tank is 0", 
				0.0, car.getGasInTank(),1E-5);
	}

	@Test
	public void testGetGasConsumption() {
		assertEquals("verify that the consumption is set to 20", 
				20, car.getEfficiency());				
	}

	@Test
	public void testGetGasInTank() {
		car.addGas(10);
		assertEquals("verify that we are seeing 10 gallons", 
				10.0, car.getGasInTank(),1E-5);				
	}

	@Test
	public void testAddGas() {
		car.addGas(10);
		assertEquals("the gas in tank has increased to 10.0", 
				10.0, car.getGasInTank(),1E-5);		
		car.addGas(5);
		assertEquals("the gas in tank has increased to 15.0", 
				15.0, car.getGasInTank(),1E-5);		
	}

	@Test
	public void testDrive() {
		car.addGas(15);
		car.drive(200);
		assertEquals("the car cosumed 10 gallons", 
				5.0, car.getGasInTank(),1E-5);		
	}

}
