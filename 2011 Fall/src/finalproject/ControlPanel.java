package finalproject;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel implements Observer {
	private Machine machine;
	private JButton stepButton;
	private JButton clearButton;
	private JButton runButton;
	private JButton reloadButton;
	private JLabel runLabel = new JLabel("Run/", JLabel.CENTER);
	private JLabel suspendLabel = new JLabel("Suspend", JLabel.CENTER);

	public ControlPanel(Machine machine) {
		this.machine = machine;
		machine.addObserver(this);
	}

	public JComponent createControlDisplay() {
		//TODO
		// build the control panel
		JPanel retVal = new JPanel();
        retVal.setLayout(new GridLayout(1,0));
        
        stepButton = new JButton("Step");
        stepButton.setBackground(Color.WHITE);
        stepButton.addActionListener(new StepListener());
        retVal.add(stepButton);
        
        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.WHITE);
        clearButton.addActionListener(new ClearListener());
        retVal.add(clearButton);
        
        JPanel runBtnContent = new JPanel();
        runBtnContent.setLayout(new GridLayout(2,1));
        runBtnContent.add(runLabel);
        runBtnContent.add(suspendLabel);
        runButton = new JButton();
        runButton.add(runBtnContent);
        runBtnContent.setBackground(Color.WHITE);
        runButton.setBackground(Color.WHITE);
        runButton.addActionListener(new RunListener());
        retVal.add(runButton);
        
        reloadButton = new JButton("Reload");
        reloadButton.setBackground(Color.WHITE);
        reloadButton.addActionListener(new ReloadListener());
        retVal.add(reloadButton);
        
		return retVal;
	}

	public void checkEnabledButtons() {
		stepButton.setEnabled(machine.getStepActive());
		clearButton.setEnabled(machine.getClearActive());
		runButton.setEnabled(machine.getRunSuspendActive());
		if (machine.getRunSuspendActive()) {
			runLabel.setForeground(Color.BLACK);
			suspendLabel.setForeground(Color.BLACK);
		} else {
			runLabel.setForeground(Color.LIGHT_GRAY);
			suspendLabel.setForeground(Color.LIGHT_GRAY);			
		}
		reloadButton.setEnabled(machine.getReloadActive());		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		checkEnabledButtons();
	}
	
	//TODO
	// Create an ActionListener class for Step that calls machine.step()
	private class StepListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			machine.step();
		}
	}
	
	// Create an ActionListener class for Clear that calls machine.clearAll()
	private class ClearListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			machine.clearAll();			
		}
	}

	// Create an ActionListener class for Run/Suspend that changes the value
	// of machine.autoStepOn using the method provided by Machine
	private class RunListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (machine.isAutoStepOn())
				machine.setAutoStepOn(false);
			else
				machine.setAutoStepOn(true);
		}
	}

	// Create an ActionListener class for Reload that calls machine.reload()
	private class ReloadListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			machine.reload();
		}
	}
}