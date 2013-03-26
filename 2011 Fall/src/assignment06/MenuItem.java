package assignment06;

import java.util.*;

public class MenuItem 
{
	private ArrayList<FoodIngredient> ingredients = new ArrayList<FoodIngredient>();
	private String name; 
	private String menuSummary;
	
	/**
	 * Constructor Method
	 * 
	 * @param name name of the menu
	 * @param menuSummary summary of the menu
	 */
	public MenuItem(String name, String menuSummary)
	{
		this.name = name;
		this.menuSummary = menuSummary;
	}
	
	/**
	 * add FoodIngredient to the ingredient list
	 * @param food FoodIngredient thats add to the list
	 */
	public void addIngredient(FoodIngredient food)
	{
		ingredients.add(food);
	}

	/**
	 * Add up calories of all the food ingredient in the list
	 * @return sum of the calories
	 */
	public int getCalories()
	{
		int sum = 0;
		
		if (!ingredients.isEmpty())
		{
			for (FoodIngredient f : ingredients)
			{
				if (f != null)
				{
					sum += f.getCalories();
				}
			}
		}
		
		return sum;
	}
}
