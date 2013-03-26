package as8model;
public class Bacon extends BurgerDecorator {
	private static BurgerModel singleton = new Bacon();
	private Bacon () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
	public int getTotalCalories() {
		return 15 + next.getTotalCalories(); //do this in all ToppigDetails
	}

	public Double getTotalPrice() {
		return new Double(0.05) + next.getTotalPrice(); // use next in a similar to make things work for prices
	}
}
