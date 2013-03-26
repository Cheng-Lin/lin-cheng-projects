package assignment04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * Class to separate the construction of the
 * JPanel in the GUI.
 * @author CS 140
 *
 */
public class UglyPieceOfCode {
	private static String[] labels = {
			"Enter the total interest you paid in 2010 on qualified student loans (see above). Do not enter more than $2,500   ",
			"Enter the amount from Form 1040, line 22   ",
			"Enter the total of the amounts from Form 1040, lines 23 through 32, plus any write-in   ",
			"adjustments you entered on the dotted line next to line 36",
			"Subtract line 3 from line 2   ",
			"Enter the amount shown below for your filing status.   ",
			" Single, head of household, or qualifying widow(er)--$60,000   ",
			" Married filing jointly--$120,000   ",
			"Is the amount on line 4 more than the amount on line 5?   ",
			"   Skip lines 6 and 7, enter -0- on line 8, and go to line 9.   ",
			" Subtract line 5 from line 4   ",
			"Divide line 6 by $15,000 ($30,000) if married filing jointly). Enter the result as a decimal (rounded to at least   ",
			"three places). If the result is 1.000 or more, enter 1.000",
			"Multiply line 1 by line 7",
			"Student loan interest deduction. Subtract line 8 from line 1. Enter the result her and on    ",
			"Form 1040, line 33. Do not include this amount in figuring any other deduction on your return (such as on   ",
			"Schedule A, C, E, etc.)   "
	};

	/**
	 * Method that builds the JPanel that is shown in the
	 * GUI. No effort has been made to separate
	 * out similar chunks of code into a different
	 * method to cut down on repetition. Instead, there
	 * was a lot of cut-and-paste and modify.
	 * @param formFields the fields that contain the data of the form
	 * @param mfj the radio button signaling married filing jointly
	 * @param notMfj the radio button signaling not married filing jointly
	 * @param no the "No" check box for Line 6 
	 * @param yes the "Yes" check box for Line 6
	 * @return the JPanel containing the tax worksheet
	 */
	public static JPanel createForm(JTextField[] formFields,
			JRadioButton mfj, JRadioButton notMfj, 
			JCheckBox no, JCheckBox yes) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(0,1));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,1));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(0,1));

		panel.add(leftPanel, BorderLayout.LINE_START);
		panel.add(centerPanel);
		panel.add(rightPanel, BorderLayout.LINE_END);
		
		leftPanel.add(new JLabel("  1.  "));
		centerPanel.add(new JLabel(labels[0]));

		JPanel item1Panel = new JPanel();
		item1Panel.setLayout(new BoxLayout(item1Panel,BoxLayout.LINE_AXIS));
		item1Panel.add(new JLabel("1. "));
		formFields[0] = new JTextField(10);
		item1Panel.add(formFields[0]);
		rightPanel.add(item1Panel);
		
		JPanel line2Panel = new JPanel();
		line2Panel.setLayout(new BorderLayout());
		line2Panel.add(new JLabel(labels[1]));

		JPanel item2Panel = new JPanel();
		item2Panel.setLayout(new BoxLayout(item2Panel,BoxLayout.LINE_AXIS));
		item2Panel.add(new JLabel("  2. "));
		formFields[1] = new JTextField(10);
		item2Panel.add(formFields[1]);
		line2Panel.add(item2Panel, BorderLayout.LINE_END);

		leftPanel.add(new JLabel("  2.  "));
		centerPanel.add(line2Panel);
		rightPanel.add(new JLabel());
		
		leftPanel.add(new JLabel("  3.  "));
		centerPanel.add(new JLabel(labels[2]));
		rightPanel.add(new JLabel());

		JPanel line3Panel = new JPanel();
		line3Panel.setLayout(new BorderLayout());
		line3Panel.add(new JLabel(labels[3]));

		JPanel item3Panel = new JPanel();
		item3Panel.setLayout(new BoxLayout(item3Panel,BoxLayout.LINE_AXIS));
		item3Panel.add(new JLabel("3. "));
		formFields[2] = new JTextField(10);
		item3Panel.add(formFields[2]);
		line3Panel.add(item3Panel, BorderLayout.LINE_END);

		leftPanel.add(new JLabel());
		centerPanel.add(line3Panel);
		rightPanel.add(new JLabel());

		JPanel line4Panel = new JPanel();
		line4Panel.setLayout(new BorderLayout());
		line4Panel.add(new JLabel(labels[4]));

		JPanel item4Panel = new JPanel();
		item4Panel.setLayout(new BoxLayout(item4Panel,BoxLayout.LINE_AXIS));
		item4Panel.add(new JLabel("4. "));
		formFields[3] = new JTextField(10);
		formFields[3].setEditable(false);
		formFields[3].setBackground(Color.WHITE);
		item4Panel.add(formFields[3]);
		line4Panel.add(item4Panel, BorderLayout.LINE_END);

		leftPanel.add(new JLabel("  4. "));
		centerPanel.add(line4Panel);
		rightPanel.add(new JLabel());

		leftPanel.add(new JLabel("  5.  "));
		centerPanel.add(new JLabel(labels[5]));
		rightPanel.add(new JLabel());

		JPanel line5aPanel = new JPanel();
		line5aPanel.setLayout(new BorderLayout());
		line5aPanel.add(notMfj, BorderLayout.LINE_START);
		line5aPanel.add(new JLabel(labels[6]));

		leftPanel.add(new JLabel());
		centerPanel.add(line5aPanel);
		rightPanel.add(new JLabel());
		
		JPanel line5bPanel = new JPanel();
		line5bPanel.setLayout(new BorderLayout());
		line5bPanel.add(mfj, BorderLayout.LINE_START);
		line5bPanel.add(new JLabel(labels[7]));

		ButtonGroup group = new ButtonGroup();
		group.add(mfj);
		group.add(notMfj);
		
		JPanel item5Panel = new JPanel();
		item5Panel.setLayout(new BoxLayout(item5Panel,BoxLayout.LINE_AXIS));
		item5Panel.add(new JLabel("5. "));
		formFields[4] = new JTextField(10);
		formFields[4].setEditable(false);
		formFields[4].setBackground(Color.WHITE);
		item5Panel.add(formFields[4]);
		line5bPanel.add(item5Panel, BorderLayout.LINE_END);
				
		leftPanel.add(new JLabel());
		centerPanel.add(line5bPanel);
		rightPanel.add(new JLabel());
		
		leftPanel.add(new JLabel("  6.  "));
		centerPanel.add(new JLabel(labels[8]));
		rightPanel.add(new JLabel());

		JPanel line6aPanel = new JPanel();
		line6aPanel.setLayout(new BorderLayout());
		line6aPanel.add(no, BorderLayout.LINE_START);
		line6aPanel.add(new JLabel(labels[9]));

		no.setEnabled(false);

		leftPanel.add(new JLabel());
		centerPanel.add(line6aPanel);
		rightPanel.add(new JLabel());
		
		JPanel line6bPanel = new JPanel();
		line6bPanel.setLayout(new BorderLayout());
		line6bPanel.add(yes, BorderLayout.LINE_START);
		line6bPanel.add(new JLabel(labels[10]));

		yes.setEnabled(false);

		JPanel item6Panel = new JPanel();
		item6Panel.setLayout(new BoxLayout(item6Panel,BoxLayout.LINE_AXIS));
		item6Panel.add(new JLabel("6. "));
		formFields[5] = new JTextField(10);
		formFields[5].setEditable(false);
		formFields[5].setBackground(Color.WHITE);
		item6Panel.add(formFields[5]);
		line6bPanel.add(item6Panel, BorderLayout.LINE_END);
				
		leftPanel.add(new JLabel());
		centerPanel.add(line6bPanel);
		rightPanel.add(new JLabel());
		
		leftPanel.add(new JLabel("  7.  "));
		centerPanel.add(new JLabel(labels[11]));
		rightPanel.add(new JLabel());

		leftPanel.add(new JLabel());
		centerPanel.add(new JLabel(labels[12]));

		JPanel line7bPanel = new JPanel();
		line7bPanel.setLayout(new BoxLayout(line7bPanel,BoxLayout.LINE_AXIS));
		line7bPanel.add(new JLabel("7. "));
		formFields[6] = new JTextField(10);
		formFields[6].setEditable(false);
		formFields[6].setBackground(Color.WHITE);
		line7bPanel.add(formFields[6]);
		rightPanel.add(line7bPanel);
		
		leftPanel.add(new JLabel("  8.  "));
		centerPanel.add(new JLabel(labels[13]));

		JPanel line8Panel = new JPanel();
		line8Panel.setLayout(new BoxLayout(line8Panel,BoxLayout.LINE_AXIS));
		line8Panel.add(new JLabel("8. "));
		formFields[7] = new JTextField(10);
		formFields[7].setEditable(false);
		formFields[7].setBackground(Color.WHITE);
		line8Panel.add(formFields[7]);
		rightPanel.add(line8Panel);
		
		leftPanel.add(new JLabel("  9.  "));
		centerPanel.add(new JLabel(labels[14]));
		rightPanel.add(new JLabel());

		leftPanel.add(new JLabel());
		centerPanel.add(new JLabel(labels[15]));
		rightPanel.add(new JLabel());

		leftPanel.add(new JLabel());
		centerPanel.add(new JLabel(labels[16]));

		JPanel line9Panel = new JPanel();
		line9Panel.setLayout(new BoxLayout(line9Panel,BoxLayout.LINE_AXIS));
		line9Panel.add(new JLabel("9. "));
		formFields[8] = new JTextField(10);
		formFields[8].setEditable(false);
		formFields[8].setBackground(Color.WHITE);
		line9Panel.add(formFields[8]);
		rightPanel.add(line9Panel);
		
		return panel;
	}
}
