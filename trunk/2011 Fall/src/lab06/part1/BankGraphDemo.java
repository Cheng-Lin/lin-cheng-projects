package lab06.part1;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BankGraphDemo {

	/**
	 * Create the GUI and show it.  For thread safety, 
	 * this method should be invoked from the 
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);
		//Create and set up the window.
		JFrame frame = new JFrame("Bank Account Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set up the content pane.
		GraphArea area = new GraphArea();
		frame.add(area);
		ArrayList<BankAccount> list = new ArrayList<BankAccount> ();
		list.add(new BankAccount(1500.0, 1001));
		list.add(new BankAccount(500.0, 1002));
		list.add(new BankAccount(2500.0, 1003));
		list.add(new BankAccount(1200.0, 1004));
		list.add(new BankAccount(700.0, 1005));
		list.add(new BankAccount(2000.0, 1006));
		list.add(new BankAccount(2200.0, 1007));
		area.setList(list);

		//Display the window.
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		JOptionPane.showMessageDialog(frame, "Click OK when you are ready to continue");
		list.add(new BankAccount(1800.0, 1008));
		list.add(new BankAccount(1555.0, 1009));
		list.add(new BankAccount(2220.0, 1010));
		list.add(new BankAccount(1120.0, 1011));
		list.add(new BankAccount(70.0, 1012));
		list.add(new BankAccount(2111.0, 1013));
		list.add(new BankAccount(1888.0, 1014));
		frame.setSize(600, 400);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
			}
		});
	}

}