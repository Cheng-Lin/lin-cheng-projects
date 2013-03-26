package as8model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import as8view.DynamicScreenManager;
import as8view.ScreenBuilder;
import as8view.ToppingsManager;

public class ToppingDetails {
	private boolean selected = false;
	private String name;
	private String screenName;
	private String moneyUnit = "cents";
	private String free = "free";
	private int calories;
	private int cost;
	private JLabel caloriesLabel;
	private JLabel costLabel;
	private JButton lineSelectorImage;
	private JButton lineSelectorText;
	public ToppingDetails (String s, int cals, int cost) {
		name = s;
		screenName = s;
		calories = cals;
		this.cost = cost;
		caloriesLabel = ScreenBuilder.createYellowTextLabel("", SwingConstants.CENTER);
		costLabel = ScreenBuilder.createYellowTextLabel("", SwingConstants.CENTER);
		lineSelectorImage = ScreenBuilder.createIconButton(new ImageIcon(name + ".jpg"), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction();
			}
		});	
		lineSelectorText = ScreenBuilder.createBlackTextButton(screenName, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				doAction();
			}
		});
		update();
	}
	private void doAction() {
		toggle();
		// choose a way to tell ToppingsManager
		// to add or remove the decorator for "name"
		// if selected is true, the decorator for "name"
		// should be part of the linked list "burger" held by 
		// ToppingsManager, e.g. call
		if (selected)
			ToppingsManager.addTopping(ToppingDetails.this);
		else
			ToppingsManager.removeTopping(ToppingDetails.this);		
		// if selected is false, ToppingsManager must ensure
		// that the decorator for "name" is NOT part of 
		// the linked list "burger" in ToppingsManager, e.g. call

		// NOTE MUST UPDATE AFTER CHANGING TOPPINGS
		DynamicScreenManager.getHandle().update();		
	}
	public JLabel getCaloriesLabel() {
		return caloriesLabel;
	}
	public JLabel getCostLabel() {
		return costLabel;
	}
	public JButton getSelectorImageButton () {
		return lineSelectorImage;
	}
	public JButton getSelectorButton () {
		return lineSelectorText;
	}
	public void toggle() {
		selected = !selected;
		update();
	}		
	public void update() {
		caloriesLabel.setText("" + calories);
		if (cost == 0) {
			costLabel.setText(free);
		} else {
			costLabel.setText(cost + " " + moneyUnit);
		}
		lineSelectorText.setText(screenName);
	}
	public String getScreenName() {
		return screenName;
	}
	public String getName() {
		return name;
	}
	public void setScreenName(String s) {
		if (selected) {
			screenName = s + ' ' + '\u2713';
		} else {
			screenName = s + "   ";
		}
	}
	public void setFreeWord(String s) {
		free = s;
	}
	public String getMoneyUnit() {
		return moneyUnit;
	}
	public void setMoneyUnit(String s) {
		moneyUnit = s;
	}
	public int getCalories() {
		return calories;
	}
	public int getCost() {
		return cost;
	}
}