package as8view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import as8model.ToppingDetails;


public class ScreenBuilder {
	private static Font font = new Font("Dialog",Font.BOLD, 18);
	private static Font ital = new Font("SansSerif",Font.ITALIC|Font.BOLD, 18);
	private static Font giantFont = new Font("Dialog",Font.BOLD, 36);
	private static Color background = Color.BLACK;
	private DynamicScreenManager screen = DynamicScreenManager.getHandle();	

// NO NEED TO PASS THE INSTANCE OF ToppingsManager SO CONSTRUCTOR REMOVED
// ALL REFERENCES TO ToppingsManager ARE REFERENCES TO THE CLASS

	public void makeLanguageChoice (JPanel languages) {
		languages.setLayout(new BoxLayout(languages, BoxLayout.Y_AXIS));
		languages.setBackground(Color.LIGHT_GRAY);
		languages.add(createBlackTextButton("English", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ToppingsManager.getBurger().setLanguage("English");
				screen.update();
			}
		}));
		languages.add(createBlackTextButton("Deutsch", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ToppingsManager.getBurger().setLanguage("German");
				screen.update();
			}
		}));
		languages.add(createBlackTextButton("Espa"+ (char)241 + "ol", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ToppingsManager.getBurger().setLanguage("Spanish");
				screen.update();
			}
		}));
	}
	public void makeTitleArea (JPanel titles, DynamicScreenManager dsm) {
		titles.setLayout(new GridLayout(0,8,0,0));
		titles.setBackground(background);
		titles.add(new JLabel());
		titles.add(dsm.getToppingsTitle1());
		titles.add(dsm.getCaloriesTitle1());
		titles.add(dsm.getPriceTitle1());
		titles.add(new JLabel());
		titles.add(dsm.getToppingsTitle2());
		titles.add(dsm.getCaloriesTitle2());
		titles.add(dsm.getPriceTitle2());
	}
	public void makeButtonArea (JPanel buttonsEtc, JPanel buttonsEtcLeft, JPanel buttonsEtcRight) {
		buttonsEtc.setLayout(new GridLayout(1,2,5,0));
		buttonsEtcLeft.setLayout(new GridLayout(0,4,0,0));
		buttonsEtcRight.setLayout(new GridLayout(0,4,0,0));
		buttonsEtc.setOpaque(true);
		buttonsEtc.setBackground(Color.LIGHT_GRAY);
		buttonsEtcLeft.setBackground(Color.BLACK);
		buttonsEtcRight.setBackground(Color.BLACK);
		buttonsEtc.add(buttonsEtcLeft);
		buttonsEtc.add(buttonsEtcRight);
	}
	public void makeButtonLine (JPanel buttonsEtc, ToppingDetails topping) { 
		buttonsEtc.add(topping.getSelectorImageButton());
		buttonsEtc.add(topping.getSelectorButton());
		buttonsEtc.add(topping.getCaloriesLabel());
		buttonsEtc.add(topping.getCostLabel());
	}
	public void makeTotalArea (JPanel totals, DynamicScreenManager dsm) {
		totals.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		totals.setBackground(background);
		totals.add(createItalLabel("TOTALS: ", SwingConstants.RIGHT));
		totals.add(dsm.getCaloriesTotal());
		totals.add(dsm.getCaloriesLabel());
		totals.add(dsm.getPriceTotal());
		totals.add(dsm.getPriceField());
	}

	public static JButton createZellowTextButton(String label, ActionListener action) {
		JButton b = new JButton(label);
		b.setOpaque(false);
		b.setForeground(Color.YELLOW);		
		b.setFont(font);
		b.setBorder(BorderFactory.createLineBorder(background));
		b.addActionListener(action);
		return b;		
	}
	public static JButton createBlackTextButton(String label, ActionListener action) {
		JButton b = new JButton(label);
		b.setOpaque(false);
		b.setForeground(Color.BLACK);		
		b.setFont(font);
		b.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		b.addActionListener(action);
		return b;		
	}
	public static JButton createIconButton(Icon icon, ActionListener action) {
		JButton b = new JButton(icon);
		b.setOpaque(false);
		b.setBorder(BorderFactory.createLineBorder(background));
		b.addActionListener(action);
		return b;
	}	
	public static JLabel createYellowTextLabel (String label, int alignment) {
		JLabel lbl = new JLabel(label, alignment);
		lbl.setForeground(Color.YELLOW);		
		lbl.setFont(font);	
		return lbl;	
	}
	public static JLabel createItalLabel (String label, int alignment) {
		JLabel lbl = new JLabel(label, alignment);
		lbl.setForeground(Color.YELLOW);		
		lbl.setFont(ital);	
		return lbl;	
	}
	public static JFormattedTextField createYellowTextField() {
		JFormattedTextField t = new JFormattedTextField(NumberFormat.getCurrencyInstance());
		t.setHorizontalAlignment(SwingConstants.CENTER);
		t.setColumns(6);
		t.setOpaque(false);
		t.setEditable(false);
		t.setBorder(BorderFactory.createLineBorder(background));
		t.setForeground(Color.YELLOW);		
		t.setFont(font);
		return t;
	}	
}
