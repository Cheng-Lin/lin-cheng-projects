package assignment07;
import java.util.ArrayList;
import java.util.Arrays;

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
		BankAccount[] list = new BankAccount[10];
		list[0] = new BankAccount(1750.0, 1000);
		list[1] = new BankAccount(1500.0, 1001);
		list[2] = new BankAccount(500.0, 1002);
		list[3] = new BankAccount(2500.0, 1003);
		list[4] = new BankAccount(1200.0, 1004);
		list[5] = new BankAccount(700.0, 1005);
		list[6] = new BankAccount(2000.0, 1006);
		list[7] = new BankAccount(2200.0, 1007);
		list[8] = new BankAccount(10000.0, 1008);
		list[9] = new BankAccount(15000.0, 1009);
		
		ArrayList<BankAccount> arrayList = new ArrayList<BankAccount>();
		for (BankAccount b : list)
			arrayList.add(b);
		area.setList(arrayList);

		//Display the window.
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		JOptionPane.showMessageDialog(frame, "Click OK when you are ready to continue");
		BubbleSort.sort(list);
		arrayList = new ArrayList<BankAccount>();
		for (BankAccount b : list)
			arrayList.add(b);
		area.setList(arrayList);
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