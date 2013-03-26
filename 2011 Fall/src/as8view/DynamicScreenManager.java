package as8view;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import as8languageStrategy.LanguageStrategy;
import as8model.BurgerModel;


public class DynamicScreenManager {
	private JFrame frame;
	private JLabel toppingTitle1;
	private JLabel priceTitle1;
	private JLabel caloriesTitle1;
	private JLabel toppingTitle2;
	private JLabel priceTitle2;
	private JLabel caloriesTitle2;
	private JLabel calories;
	private JFormattedTextField price;  
	private JLabel priceTotal;
	private JLabel caloriesTotal;
	private static DynamicScreenManager singleton = new DynamicScreenManager();
	private DynamicScreenManager () {
		calories = ScreenBuilder.createYellowTextLabel("0", SwingConstants.CENTER);
		price = ScreenBuilder.createYellowTextField();
		toppingTitle1 = ScreenBuilder.createYellowTextLabel("TOPPING", SwingConstants.CENTER);
		caloriesTitle1 = ScreenBuilder.createYellowTextLabel("CALORIES", SwingConstants.CENTER);
		priceTitle1 = ScreenBuilder.createYellowTextLabel("PRICE", SwingConstants.CENTER);
		toppingTitle2 = ScreenBuilder.createYellowTextLabel("TOPPING", SwingConstants.CENTER);
		caloriesTitle2 = ScreenBuilder.createYellowTextLabel("CALORIES", SwingConstants.CENTER);
		priceTitle2 = ScreenBuilder.createYellowTextLabel("PRICE", SwingConstants.CENTER);
		caloriesTotal = ScreenBuilder.createYellowTextLabel("calories", SwingConstants.CENTER);
		priceTotal = ScreenBuilder.createYellowTextLabel("price", SwingConstants.CENTER);
	}
	public static DynamicScreenManager getHandle() {
		return singleton;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JLabel getCaloriesLabel() {
		return calories;
	}
	public JLabel getPriceTitle1() {
		return priceTitle1;
	}
	public JLabel getToppingsTitle1() {
		return toppingTitle1;
	}
	public JLabel getCaloriesTitle1() {
		return caloriesTitle1;
	}
	public JLabel getPriceTitle2() {
		return priceTitle2;
	}
	public JLabel getToppingsTitle2() {
		return toppingTitle2;
	}
	public JLabel getCaloriesTitle2() {
		return caloriesTitle2;
	}
	public JTextField getPriceField() {
		return price;
	}
	public JLabel getCaloriesTotal() {
		return caloriesTotal;
	}
	public JLabel getPriceTotal() {
		return priceTotal;
	}
	public void update(){
		BurgerModel burger = ToppingsManager.getBurger();
		LanguageStrategy strategy = null;  
		try {
			strategy = (LanguageStrategy)Class.forName("as8languageStrategy.Language" + burger.getLanguage()).newInstance();
			strategy.changeLanguage(ToppingsManager.toppingsMap);
			strategy.changeTitles(this);
			strategy.changeTotals(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		calories.setText("" + burger.getTotalCalories());
		price.setValue(burger.getTotalPrice());
		frame.validate();
	}
}
