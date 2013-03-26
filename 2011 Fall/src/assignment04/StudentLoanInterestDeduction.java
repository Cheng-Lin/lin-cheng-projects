package assignment04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * GUI application to help the user fill the 
 * Student Loan Interest Deduction Worksheet
 * from the 1040 Tax Instructions. 
 * @author CS 140
 *
 */
public class StudentLoanInterestDeduction {
	private JFrame frame = new JFrame();
	private JTextField[] formFields = new JTextField[9];
	private JRadioButton mfj = new JRadioButton();
	private JRadioButton notMfj = new JRadioButton();
	private JCheckBox no = new JCheckBox("No.");
	private JCheckBox yes = new JCheckBox("Yes.");
	private int item1;
	private int item2;
	private int item3;

	/**
	 * Constructor for the GUI. 
	 * Locates the GUI in the center of the screen.
	 */
	public StudentLoanInterestDeduction() {
		JPanel form = UglyPieceOfCode.createForm(formFields, mfj, notMfj, no, yes);
		addListeners();
		frame.add(form);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Compute the student interest deduction and fill the form
	 * @param mfj
	 */
	public void fillForm(boolean mfj) {
// TODO MODIFY THIS CODE SO THAT THE CORRECT VALUES
// APPEAR, WHICH YOU COMPUTED IN ASSIGNMENT 3.
		int item4 = item2 - item3;
		
		int item5 = 60000;
		if (mfj) {
			item5 = 120000;
		}
		
		int item6 = 0;
		double item7 = 0.0;
		double item8 = 0.0;
		int item9 = 0;
		
		boolean bool6 = item4 > item5;
		if (bool6) {
			item9 = item1;
		} else {
			item6 = item5 - item4;
			
			item7 = (Math.round(1000.0 * item6 / 15000)) / 1000.0;
			if(mfj) {
				item7 = (Math.round(1000.0 * item6 / 30000)) / 1000.0;
			} 
			if (item7 > 1.0) {
				 item7 = 1.0;
			}
			
			item8 = item1 * item7;
			item9 = (int)Math.round(item1 - item8);
		}
		
		formFields[0].setText("" + item1);
		formFields[1].setText("" + item2);
		formFields[2].setText("" + item3);
		formFields[3].setText("" + item4);
		formFields[4].setText("" + item5);
		formFields[5].setText("" + item6);
		formFields[6].setText("" + item7);
		formFields[7].setText("" + item8);
		formFields[8].setText("" + item9);
		no.setSelected(!bool6);
		yes.setSelected(bool6);
	}
	
	/**
	 * Add the listeners for the enabled fields on
	 * the form.
	 */
	public void addListeners() {
		formFields[0].addActionListener(new Line1Listener());
		formFields[1].addActionListener(new Line2Listener());
		formFields[2].addActionListener(new Line3Listener());
		notMfj.addActionListener(new Line5notMfjListener());
		mfj.addActionListener(new Line5MfjListener());
	}
	
	/**
	 * Standard way to start a Java GUI application.
	 * The form will be constructed and the focus is
	 * set to the Line 1 field.
	 * @param args command line arguments are not used
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StudentLoanInterestDeduction s = 
					new StudentLoanInterestDeduction();
				s.formFields[0].requestFocusInWindow();
			}
		});
	}

	/**
	 * Listener for Line 1. The listener is called when
	 * the user hits the <enter> key on the field for
	 * Line 1. If a number has not been entered, the user
	 * receives a warning.  If a number has been entered,
	 * the value is stored in the item1 field and the
	 * focus shifts to the field for Line 2.
	 * @author CS 140
	 *
	 */
	private class Line1Listener implements ActionListener {

		/**
		 * actionPerformed that implements the behavior
		 * described for this class above.
		 * @param action event passed when the method is called.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = formFields[0].getText();
			try {
				item1 = Integer.parseInt(text);
				formFields[1].requestFocusInWindow();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "You must enter a whole number in Line 1");
			}
		}
		
	}

	/**
	 * Listener for Line 2. The listener is called when
	 * the user hits the <enter> key on the field for
	 * Line 2. If a number has not been entered, the user
	 * receives a warning.  If a number has been entered,
	 * the value is stored in the item2 field and the
	 * focus shifts to the field for Line 3.
	 *
	 */
	private class Line2Listener implements ActionListener {

		/**
		 * actionPerformed that implements the behavior
		 * described for this class above.
		 * @param action event passed when the method is called.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = formFields[1].getText();
			try {
				item2 = Integer.parseInt(text);
				formFields[2].requestFocusInWindow();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "You must enter a whole number in Line 2");
			}
		}
		
	}

	/**
	 * Listener for Line 3. The listener is called when
	 * the user hits the <enter> key on the field for
	 * Line 3. If a number has not been entered, the user
	 * receives a warning.  If a number has been entered,
	 * the value is stored in the item3 field and the
	 * focus shifts to a radio button--although that will
	 * not be apparent on the screen. A message dialog
	 * then instructs the user how to complete the form.
	 * @author CS 140
	 *
	 */	
	private class Line3Listener implements ActionListener {

		/**
		 * actionPerformed that implements the behavior
		 * described for this class above.
		 * @param action event passed when the method is called.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = formFields[2].getText();
			try {
				item3 = Integer.parseInt(text);
				notMfj.requestFocusInWindow(); // no visible effect
				JOptionPane.showMessageDialog(frame, "Please select your filing status\non Line 5 to complete the form");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "You must enter a whole number in Line 3");
			}
		}
		
	}

	/**
	 * Listener for the mfj radio button. If the user
	 * clicks the button, the fields of the form are
	 * all completed for the married filing jointly 
	 * status. 
	 * @author CS 140
	 *
	 */
	private class Line5MfjListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fillForm(true);
		}
		
	}

	/**
	 * Listener for the not mfj radio button. If the user
	 * clicks the button, the fields of the form are
	 * all completed for the single status. 
	 */
	private class Line5notMfjListener implements ActionListener {

		/**
		 * actionPerformed that implements the behavior
		 * described for this class above.
		 * @param action event passed when the method is called.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			fillForm(false);			
		}
		
	}

}