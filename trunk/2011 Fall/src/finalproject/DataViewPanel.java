package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pippin.CodeMemory;

public class DataViewPanel implements Observer {
	private JTextField[] intFields = new JTextField[CodeMemory.CODE_SIZE];
	private JTextField[] binaryFields = new JTextField[CodeMemory.CODE_SIZE];
	private Machine machine;

	public DataViewPanel(Machine machine) {
		this.machine = machine;
		machine.addObserver(this);
	}

	public JComponent createDataDisplay() {
		JPanel returnPanel = new JPanel();
		//TODO
		// Make a data panel similar to the code view panel
		// the left column is the data value at index i
		// in decimal and the right column is the same value
		// in binary
		JPanel panel = new JPanel();
		JPanel numPanel = new JPanel();		
		JPanel intPanel = new JPanel();
		JPanel binaryPanel = new JPanel();	
		
		panel.setLayout(new BorderLayout());
		numPanel.setLayout(new GridLayout(0, 1));
		intPanel.setLayout(new GridLayout(0, 1));		
		binaryPanel.setLayout(new GridLayout(0, 1));
		
		panel.add(numPanel, BorderLayout.LINE_START);
		panel.add(intPanel, BorderLayout.CENTER);
		panel.add(binaryPanel, BorderLayout.LINE_END);
		
		for (int i = 0; i < CodeMemory.CODE_SIZE; i++)
		{
			numPanel.add(new JLabel(" "+i+": ", JLabel.RIGHT));
			intFields[i] = new JTextField(10);
			intPanel.add(intFields[i]);
			binaryFields[i] = new JTextField(30);
			binaryPanel.add(binaryFields[i]);
		}
		
		return new JScrollPane(panel);
	}

	@Override
	public void update(Observable o, Object msg) {
		if ("Clear".equals(msg)) {
			// TODO
			// set the text of all the fields to ""
			for (int i = 0; i < CodeMemory.CODE_SIZE; i++)
			{
				intFields[i].setText("");
				binaryFields[i].setText("");
			}
		} else {
			//TODO
			//for every data location,
			//get the binary form of the data from machine.getDataBinary
			//If it is a non-empty string, get the actual numeric value
			//fill in the two data fields, otherwise leave them blank
			for (int i = 0; i < CodeMemory.CODE_SIZE; i++)
			{
				String binary = "";
				try {
					binary = machine.getDataBinary(i);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (binary.length() > 0)
				{
					intFields[i].setText((Long.valueOf(binary, 2)).toString());
					binaryFields[i].setText(binary);
				}
			}
		}
	}
}
