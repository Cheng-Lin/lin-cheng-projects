package assignment03;

public class BalloonTester
{
	/**
	 * Tester for balloon class
	 * @param args
	 */
	public static void main(String[] args)
	{
		Balloon balloon = new Balloon();

		balloon.addAir(100);
		System.out.println("The expect radius of the balloon is 2.879 cm");
		System.out.println("The actual radius of the balloon is: " + balloon.getRadius());
		System.out.println("The expect surface area of the balloon is 104.188 cm^2");
		System.out.println("The actual surface area of the balloon is: " + balloon.getSurfaceArea());
		System.out.println("The expect volume of the balloon is 100 cm^3");
		System.out.println("The actual volume of the balloon is: " + balloon.getVolume());
		
		System.out.println();
		
		balloon.addAir(100);
		System.out.println("The expect radius of the balloon is 3.628 cm");
		System.out.println("The actual radius of the balloon is: " + balloon.getRadius());
		System.out.println("The expect surface area of the balloon is 165.388 cm^2");
		System.out.println("The actual surface area of the balloon is: " + balloon.getSurfaceArea());
		System.out.println("The expect volume of the balloon is 200 cm^3");
		System.out.println("The actual volume of the balloon is: " + balloon.getVolume());
	}
}
