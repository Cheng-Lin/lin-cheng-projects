package as8model;
public abstract class BurgerDecorator extends BurgerModel {
	protected BurgerModel next;
	protected int calories;
	protected Double price;
	public BurgerModel addTopping(BurgerModel burger) {
		this.next = burger;// make "this" point at burger 
		return this;  
	}
	public BurgerModel removeTopping (BurgerDecorator topping) {
		// if this is the topping to be removed, return next
		// otherwise next = next.removeTopping (topping)
		// and
		if (this == topping)
			return next;
		else
			next = ((BurgerDecorator)next).removeTopping(topping);
		return this;
	}
}
