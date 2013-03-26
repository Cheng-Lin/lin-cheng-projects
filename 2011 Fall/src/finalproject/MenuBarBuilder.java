package finalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.junit.runner.notification.RunListener;

public class MenuBarBuilder implements Observer {
	private JMenuItem run = new JMenuItem("Run the Loaded Program");
	private JMenuItem translate = new JMenuItem("Translate Source...");
	private JMenuItem load = new JMenuItem("Load Program...");
	private JMenuItem exit = new JMenuItem("Exit");
	private Machine machine;

	public MenuBarBuilder(Machine machine) {
		this.machine = machine;
		machine.addObserver(this);
	}

	public JMenu createMenu() {
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		translate.setMnemonic(KeyEvent.VK_T);
		translate.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		translate.addActionListener(new TranslateListener());
		menu.add(translate);

		load.setMnemonic(KeyEvent.VK_L);
		load.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		load.addActionListener(new LoadListener());
		menu.add(load);

		run.setMnemonic(KeyEvent.VK_R);
		run.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		run.addActionListener(new RunListener());
		menu.add(run);

		menu.addSeparator(); // puts a line across the menu

		exit.setMnemonic(KeyEvent.VK_E);
		exit.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		exit.addActionListener(new ExitListener());
		menu.add(exit);

		return menu;
	}

	public void checkEnabledMenus() {
		translate.setEnabled(machine.getTranslateFileActive());
		load.setEnabled(machine.getLoadFileActive());
		run.setEnabled(machine.getStepActive());
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		checkEnabledMenus();
	}

	class RunListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			machine.run();
		}
	}

	class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			machine.exit();
		}
	}

	class LoadListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			machine.loadFile();
		}
	}

	class TranslateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			machine.translate();
		}
	}
}
