package as8model;
public class Tomato extends BurgerDecorator {
	private static BurgerModel singleton = new Tomato();
	private Tomato () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
	public int getTotalCalories() {
		return 5 + next.getTotalCalories(); //do this in all ToppigDetails
	}

	public Double getTotalPrice() {
		return new Double(0) + next.getTotalPrice(); // use next in a similar to make things work for prices
	}
}
