package as8model;
public class ConcreteBurgerModel extends BurgerModel {
	private static BurgerModel singleton = new ConcreteBurgerModel();
	private static Double PRICE = new Double (2.0);
	private ConcreteBurgerModel() {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
	public int getTotalCalories() {
		return 200; //find out the correct amount
	}
	public Double getTotalPrice() {		
		return PRICE;
	}		
}
