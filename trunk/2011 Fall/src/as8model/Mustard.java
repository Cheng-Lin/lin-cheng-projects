package as8model;
public class Mustard extends BurgerDecorator {
	private static BurgerModel singleton = new Mustard();
	private Mustard () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
	public int getTotalCalories() {
		return 10 + next.getTotalCalories(); //do this in all ToppigDetails
	}

	public Double getTotalPrice() {
		return new Double(0.05) + next.getTotalPrice(); // use next in a similar to make things work for prices
	}
}
