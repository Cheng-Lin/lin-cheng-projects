package as8view;

import java.util.Map;
import java.util.TreeMap;

import as8model.*;


public class ToppingsManager {
	// the "burger" variable will always point at the first 
	// decorator:
	private static BurgerModel burger = ConcreteBurgerModel.getHandle();
	public static Map<String,ToppingDetails> toppingsMap = new TreeMap<String,ToppingDetails>(); // sort alphabetically on keys
	public static Map<String,BurgerModel> toppingsObjects = new TreeMap<String,BurgerModel>(); // sort alphabetically on keys

	static {
		toppingsMap.put("bacon", new ToppingDetails("bacon",15,5)); 
		toppingsMap.put("mustard", new ToppingDetails("mustard",10,5)); 
		toppingsMap.put("lettuce", new ToppingDetails("lettuce", 4, 0)); 
		toppingsMap.put("tomato", new ToppingDetails("tomato", 5, 0)); 
		toppingsMap.put("ketchup", new ToppingDetails("ketchup", 5, 0)); 
		toppingsMap.put("pickles", new ToppingDetails("pickles", 5, 0)); 
		toppingsMap.put("onions", new ToppingDetails("onions", 5, 0)); 
		toppingsMap.put("mayonnaise", new ToppingDetails("mayonnaise", 5, 0)); 
		toppingsMap.put("cheese", new ToppingDetails("cheese", 5, 0)); 

		toppingsObjects.put("bacon", Bacon.getHandle()); 
		toppingsObjects.put("mustard", Mustard.getHandle()); 
		toppingsObjects.put("lettuce", Lettuce.getHandle()); 
		toppingsObjects.put("tomato", Tomato.getHandle()); 
		toppingsObjects.put("ketchup", Ketchup.getHandle()); 
		toppingsObjects.put("pickles", Pickles.getHandle()); 
		toppingsObjects.put("onions", Onions.getHandle()); 
		toppingsObjects.put("mayonnaise", Mayonnaise.getHandle()); 
		toppingsObjects.put("cheese", Cheese.getHandle()); 
	}
//	EXAMPLE OF WHERE TO ADD AND DELETE TOPPINGS
	public static void addTopping(ToppingDetails detail) {
		// TODO
		// get the topping object for this detail, 
		// using detail.getName() and the Map above, then
		BurgerModel topping = toppingsObjects.get(detail.getName());
		// YOU NEED:
		burger = ((BurgerDecorator)topping).addTopping(burger); 
		// which uses the addTopping from BurgerDecorator
	}
	public static void removeTopping(ToppingDetails detail) {
		// TODO
		// get the topping object for this detail, 
		// using detail.getName() and the Map above, then
		BurgerModel topping = toppingsObjects.get(detail.getName());
		// use removeTopping from BurgerDecorator
		burger = ((BurgerDecorator)topping).removeTopping((BurgerDecorator)burger);
	}
	public static int getTotalCalories() {
		return burger.getTotalCalories();
	}
	public static Double getTotalPrice() {
		return burger.getTotalPrice();
	}
	public static BurgerModel getBurger() {
		return burger;		
	}
}
