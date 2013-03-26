package as8view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import as8model.BurgerModel;


public class ScreenDirector {
	public static JFrame buildScreen(
			ScreenBuilder screenBuilder, 
			BurgerModel burger) {
		final JFrame frame = new JFrame();
		Container container = frame.getContentPane();
		JPanel content = new JPanel();
		JPanel menu = new JPanel();
		container.add(new JScrollPane(content));
		content.setLayout(new BorderLayout(0,0));
		menu.setLayout(new BorderLayout(0,0));
		JPanel languages = new JPanel();
		JPanel titles = new JPanel();
		JPanel buttonsEtc = new JPanel();
		JPanel buttonsEtcLeft = new JPanel();
		JPanel buttonsEtcRight = new JPanel();
		JPanel totals = new JPanel();
		content.add(languages,BorderLayout.WEST);
		content.add(menu); // added to CENTER
		menu.add(titles,BorderLayout.NORTH);
		menu.add(totals,BorderLayout.SOUTH);
		menu.add(buttonsEtc); // added to CENTER

		screenBuilder.makeLanguageChoice(languages);
		screenBuilder.makeTitleArea(titles, DynamicScreenManager.getHandle());
		screenBuilder.makeButtonArea(buttonsEtc, buttonsEtcLeft, buttonsEtcRight);
		int count = 0;
		for (String s : ToppingsManager.toppingsMap.keySet()) {
			if (count < ToppingsManager.toppingsMap.size()/2) { 
				screenBuilder.makeButtonLine(buttonsEtcLeft, ToppingsManager.toppingsMap.get(s));
			} else {
				screenBuilder.makeButtonLine(buttonsEtcRight, ToppingsManager.toppingsMap.get(s));
			}
			count++;
		}
		screenBuilder.makeTotalArea(totals, DynamicScreenManager.getHandle());



		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(
						frame,
						"Do you want to exit?", 
						"Confirm Exit",
						JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		// get the whole screen:
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setUndecorated(true);
		frame.setVisible(true);
		return frame;		
	}
}
