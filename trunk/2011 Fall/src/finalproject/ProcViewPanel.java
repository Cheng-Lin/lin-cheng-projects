package finalproject;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class ProcViewPanel implements Observer {

	JTextField acc;
	JTextField pc;
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ProcViewPanel().createAndShowGUI();
			}
		});
	}
	private void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.add(new JLabel("Processor Memory View",JLabel.CENTER),BorderLayout.PAGE_START);
        frame.setSize(400,200);
        frame.add(createCodeDisplay());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
	private Component createCodeDisplay() {
		// TODO Auto-generated method stub
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,4));
		panel.add(new JLabel("Accumulator: ", JLabel.RIGHT));
		acc = new JTextField(10);
		
		panel.add(acc);
		panel.add(new JLabel("ProgramCounter: ", JLabel.RIGHT));
		pc = new JTextField(10);
		panel.add(pc);
		
//		
//		JPanel accPanel = new JPanel();
//		JPanel pcPanel = new JPanel();
//		panel.setLayout(new BorderLayout());
//		
//		accPanel.setLayout(new GridLayout(0,1));
//		pcPanel.setLayout(new GridLayout(0,1));
//		panel.add(accPanel, BorderLayout.WEST);
//		panel.add(pcPanel, BorderLayout.EAST);
//		
//		acc = new JTextField(10);
//		pc = new JTextField(10);
//		
//		accPanel.add(acc);
//		pcPanel.add(pc);
//		accPanel.add(new JLabel("Accumulator: ", JLabel.LEFT), BorderLayout.WEST);
//		accPanel.add(new JLabel("ProgramCounter: ", JLabel.LEFT), BorderLayout.WEST);
//		
//		
		return panel;
	}
}