package pippin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class ControlPanel implements Observer {
	JButton stepButton;
	JButton runButton;
	JButton clrButton;
	JButton reloadButton;
	
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
				new ControlPanel().createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {
		JFrame frame = new JFrame();
        frame.setSize(400,75);
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1,0));
        
        stepButton = new JButton("Step");
        stepButton.setBackground(Color.WHITE);
        stepButton.addActionListener(new StepListener());
        buttons.add(stepButton);
        
        clrButton = new JButton("Clear");
        clrButton.setBackground(Color.WHITE);
        clrButton.addActionListener(new ClearListener());
        buttons.add(clrButton);
        
        JLabel runLabel = new JLabel("Run/", JLabel.CENTER);
        JLabel suspendLabel = new JLabel("Suspend", JLabel.CENTER);
        JPanel runBtnContent = new JPanel();
        runBtnContent.setLayout(new GridLayout(2,1));
        runBtnContent.add(runLabel);
        runBtnContent.add(suspendLabel);
        runButton = new JButton();
        runButton.add(runBtnContent);
        runBtnContent.setBackground(Color.WHITE);
        runButton.setBackground(Color.WHITE);
        runButton.addActionListener(new RunListener());
        buttons.add(runButton);
        
        reloadButton = new JButton("Reload");
        reloadButton.setBackground(Color.WHITE);
        reloadButton.addActionListener(new ReloadListener());
        buttons.add(reloadButton);
        
        frame.add(buttons);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	private class StepListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class ClearListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class RunListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class ReloadListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}