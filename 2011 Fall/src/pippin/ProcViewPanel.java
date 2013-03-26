package pippin;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class ProcViewPanel implements Observer
{
	JTextField accFields;
	JTextField ipFields;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ProcViewPanel().createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {
		JFrame frame = new JFrame();
        frame.setSize(500,60);
        
        JPanel procPanel = new JPanel();
        procPanel.setLayout(new GridLayout(1,0));
        
        accFields = new JTextField();
        procPanel.add(new JLabel("Accumulator:", JLabel.RIGHT));
        procPanel.add(accFields);
        ipFields = new JTextField();
        procPanel.add(new JLabel("ProgramCounter:", JLabel.RIGHT));
        procPanel.add(ipFields);
        frame.add(procPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}
