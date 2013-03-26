package as8languageStrategy;
import java.util.Map;

import as8model.ToppingDetails;
import as8view.DynamicScreenManager;

public class LanguageSpanish extends LanguageStrategy {
	public void changeLanguage(Map<String, ToppingDetails> map) {
		for(ToppingDetails t : map.values()) {
			t.setMoneyUnit("cent");
			t.setFreeWord("gratis");
			t.setScreenName((String)spanishDictionary.get(t.getName()));
			t.update();
		}
	}
	public void changeTitles(DynamicScreenManager dsm) {
		dsm.getCaloriesTitle1().setText((String)spanishDictionary.get("caloriestitle"));
		dsm.getToppingsTitle1().setText((String)spanishDictionary.get("topping"));
		dsm.getPriceTitle1().setText((String)spanishDictionary.get("pricetitle"));
		dsm.getCaloriesTitle2().setText((String)spanishDictionary.get("caloriestitle"));
		dsm.getToppingsTitle2().setText((String)spanishDictionary.get("topping"));
		dsm.getPriceTitle2().setText((String)spanishDictionary.get("pricetitle"));
	}
	public void changeTotals(DynamicScreenManager dsm) {
		dsm.getCaloriesTotal().setText((String)spanishDictionary.get("caloriestotal"));
		dsm.getPriceTotal().setText((String)spanishDictionary.get("pricetotal"));
	}
}
