package assignment06;

public class FoodIngredient 
{
	private String name;
	private int calories;
	private double quantity;
	
	/**
	 * Constructor method 
	 * 
	 * @param name name of the food
	 * @param calories calories of the food
	 * @param quantity quantity of the food
	 */
	public FoodIngredient(String name, int calories, double quantity) 
	{
		this.name = name;
		this.calories = calories;
		this.quantity = quantity;
	}

	/**
	 * Getter method for food name
	 * @return food name 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for calories of the food
	 * @return food calories
	 */
	public int getCalories() {
		return calories;
	}

	/**
	 * Getter method for food quantity
	 * @return food quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	
	
}
