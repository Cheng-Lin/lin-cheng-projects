package as8languageStrategy;

import java.util.Map;
import java.util.TreeMap;

import as8model.ToppingDetails;
import as8view.DynamicScreenManager;

public abstract class LanguageStrategy {
	protected Map<String,String> spanishDictionary = new TreeMap<String,String>();
	protected Map<String,String> englishDictionary = new TreeMap<String,String>();
	protected Map<String,String> germanDictionary = new TreeMap<String,String>();
	public LanguageStrategy () {
		populateEnglishDictionary();
		populateSpanishDictionary();
		populateGermanDictionary();
	}
	private void populateEnglishDictionary() {
		englishDictionary.put("mustard","mustard");
		englishDictionary.put("lettuce","lettuce");
		englishDictionary.put("tomato","tomato");
		englishDictionary.put("bacon","bacon");
		englishDictionary.put("ketchup", "ketchup");  
		englishDictionary.put("pickles", "pickles"); 
		englishDictionary.put("onions", "onions");  
		englishDictionary.put("mayonnaise", "mayonnaise"); 
		englishDictionary.put("caloriestitle", "CALORIES"); 
		englishDictionary.put("pricetitle", "PRICE"); 
		englishDictionary.put("topping", "TOPPING"); 
		englishDictionary.put("caloriestotal", "calories: "); 
		englishDictionary.put("pricetotal", "price: "); 
		englishDictionary.put("cheese", "cheese"); 
	}
	private void populateSpanishDictionary() {
		spanishDictionary.put("mustard","mostaza");
		spanishDictionary.put("lettuce","lechuga");
		spanishDictionary.put("tomato","tomate");
		spanishDictionary.put("bacon","tocino");
		spanishDictionary.put("ketchup", "ketchup");  
		spanishDictionary.put("pickles", "encurtidos"); 
		spanishDictionary.put("onions", "cebolla");  
		spanishDictionary.put("mayonnaise", "mayonesa");  
		spanishDictionary.put("caloriestitle", "CALORIAS"); 
		spanishDictionary.put("pricetitle", "PRECIO"); 
		spanishDictionary.put("topping", "CON ..."); 
		spanishDictionary.put("caloriestotal", "calorias"); 
		spanishDictionary.put("pricetotal", "precio"); 
		spanishDictionary.put("cheese", "queso"); 
	}
	private void populateGermanDictionary() {
		germanDictionary.put("mustard","Senf");
		germanDictionary.put("lettuce","Kopfsalat");
		germanDictionary.put("tomato","Tomate");
		germanDictionary.put("bacon","Speck");
		germanDictionary.put("ketchup", "Ketchup");  
		germanDictionary.put("pickles", "Pickles"); 
		germanDictionary.put("onions", "Zwiebeln");  
		germanDictionary.put("mayonnaise", "Mayonnaise");  
		germanDictionary.put("caloriestitle", "KALORIEN"); 
		germanDictionary.put("pricetitle", "PREIS"); 
		germanDictionary.put("topping", "TOPPING"); 
		germanDictionary.put("caloriestotal", "Kalorien"); 
		germanDictionary.put("pricetotal", "Preis"); 
		germanDictionary.put("cheese", "K" + (char)228 + "se"); 
	}
	public abstract void changeLanguage(Map<String,ToppingDetails> map);
	public abstract void changeTitles(DynamicScreenManager dsm);
	public abstract void changeTotals(DynamicScreenManager dsm);
}
