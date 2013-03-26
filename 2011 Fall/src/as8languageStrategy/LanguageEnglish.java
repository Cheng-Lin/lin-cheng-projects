package as8languageStrategy;
import java.util.Map;

import as8model.ToppingDetails;
import as8view.DynamicScreenManager;

public class LanguageEnglish extends LanguageStrategy {
	public void changeLanguage(Map<String, ToppingDetails> map) {
		for(ToppingDetails t : map.values()) {
			t.setMoneyUnit("cents");
			t.setFreeWord("free");
			t.setScreenName((String)englishDictionary.get(t.getName()));
			t.update();			
		}
	}
	public void changeTitles(DynamicScreenManager dsm) {
		dsm.getCaloriesTitle1().setText((String)englishDictionary.get("caloriestitle"));
		dsm.getToppingsTitle1().setText((String)englishDictionary.get("topping"));
		dsm.getPriceTitle1().setText((String)englishDictionary.get("pricetitle"));
		dsm.getCaloriesTitle2().setText((String)englishDictionary.get("caloriestitle"));
		dsm.getToppingsTitle2().setText((String)englishDictionary.get("topping"));
		dsm.getPriceTitle2().setText((String)englishDictionary.get("pricetitle"));
	}
	public void changeTotals(DynamicScreenManager dsm) {
		dsm.getCaloriesTotal().setText((String)englishDictionary.get("caloriestotal"));
		dsm.getPriceTotal().setText((String)englishDictionary.get("pricetotal"));
	}
}
