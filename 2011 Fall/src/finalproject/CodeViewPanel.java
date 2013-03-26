package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pippin.CodeMemory;

public class CodeViewPanel implements Observer {
	// choose your preferred color:
	private final Color HIGHLIGHT_COLOR = Color.LIGHT_GRAY;
	private JTextField[] instrFields = new JTextField[CodeMemory.CODE_SIZE];
	private JTextField[] binaryFields = new JTextField[CodeMemory.CODE_SIZE];
	private Machine machine;
	private int currentLocation = 0;

	public CodeViewPanel(Machine machine) {
		this.machine = machine;
		machine.addObserver(this);
	}

	public JComponent createCodeDisplay() {
		JPanel returnPanel = new JPanel();
		//TODO
		//Your code to build code panel here
		JPanel panel = new JPanel();
		JPanel numPanel = new JPanel();		
		JPanel instrPanel = new JPanel();
		JPanel binaryPanel = new JPanel();	

		panel.setLayout(new BorderLayout());
		numPanel.setLayout(new GridLayout(0, 1));
		instrPanel.setLayout(new GridLayout(0, 1));		
		binaryPanel.setLayout(new GridLayout(0, 1));

		panel.add(numPanel, BorderLayout.LINE_START);
		panel.add(instrPanel, BorderLayout.CENTER);
		panel.add(binaryPanel, BorderLayout.LINE_END);

		for (int i = 0; i < CodeMemory.CODE_SIZE; i++)
		{
			numPanel.add(new JLabel(" "+i+": ", JLabel.RIGHT));
			instrFields[i] = new JTextField(10);
			instrPanel.add(instrFields[i]);
			binaryFields[i] = new JTextField(30);
			binaryPanel.add(binaryFields[i]);
		}

		return new JScrollPane(panel);
	}


	@Override
	public void update(Observable o, Object msg) {
		if ("New Program".equals(msg)) {
			//TODO
			//read all the instruction sources and binary forms
			//using machine.getInstruction...(...)
			//and put the values in the instrFields and binaryFields 
			for (int i = 0; i < CodeMemory.CODE_SIZE; i++)
			{
				try {
					instrFields[i].setBackground(Color.WHITE);
					binaryFields[i].setBackground(Color.WHITE);
					instrFields[i].setText(machine.getInstructionSource(i));
					binaryFields[i].setText(machine.getInstructionBinaryForm(i));
				} catch (CodeAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			currentLocation = 0;
			//set the background of the fields at currentLocation
			//to HIGHLIGHT_COLOR
			instrFields[currentLocation].setBackground(HIGHLIGHT_COLOR);
			binaryFields[currentLocation].setBackground(HIGHLIGHT_COLOR);
		} else if ("Clear".equals(msg)) {
			// TODO
			// Set all the fields text to ""
			// Set all the background colors to WHITE
			for (int i = 0; i < CodeMemory.CODE_SIZE; i++)
			{
				instrFields[i].setText("");
				binaryFields[i].setText("");
				instrFields[i].setBackground(Color.WHITE);
				binaryFields[i].setBackground(Color.WHITE);
			}
		} else {
			//set the background of the fields at currentLocation
			//to WHITE
			if(0 <= currentLocation && currentLocation <= CodeMemory.CODE_SIZE) {
				instrFields[currentLocation].setBackground(Color.WHITE);
				binaryFields[currentLocation].setBackground(Color.WHITE);
			}
			// change currentLocation to the next instruction location
			currentLocation = machine.getIp();
			//set the background of the fields at currentLocation
			//to HIGHLIGHT_COLOR
			if(0 <= currentLocation && currentLocation <= CodeMemory.CODE_SIZE) {
				instrFields[currentLocation].setBackground(HIGHLIGHT_COLOR);
				binaryFields[currentLocation].setBackground(HIGHLIGHT_COLOR);
			}

		}

	}

}
