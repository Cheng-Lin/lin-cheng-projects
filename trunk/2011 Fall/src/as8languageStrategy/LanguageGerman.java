
package as8languageStrategy;
import java.util.Map;

import as8model.ToppingDetails;
import as8view.DynamicScreenManager;

public class LanguageGerman extends LanguageStrategy {
	public void changeLanguage(Map<String, ToppingDetails> map) {
		for(ToppingDetails t : map.values()) {
			t.setMoneyUnit("cent");
			t.setFreeWord("gratis");
			t.setScreenName((String)germanDictionary.get(t.getName()));
			t.update();
		}
	}
	public void changeTitles(DynamicScreenManager dsm) {
		dsm.getCaloriesTitle1().setText((String)germanDictionary.get("caloriestitle"));
		dsm.getToppingsTitle1().setText((String)germanDictionary.get("topping"));
		dsm.getPriceTitle1().setText((String)germanDictionary.get("pricetitle"));
		dsm.getCaloriesTitle2().setText((String)germanDictionary.get("caloriestitle"));
		dsm.getToppingsTitle2().setText((String)germanDictionary.get("topping"));
		dsm.getPriceTitle2().setText((String)germanDictionary.get("pricetitle"));
	}
	public void changeTotals(DynamicScreenManager dsm) {
		dsm.getCaloriesTotal().setText((String)germanDictionary.get("caloriestotal"));
		dsm.getPriceTotal().setText((String)germanDictionary.get("pricetotal"));
	}
}
