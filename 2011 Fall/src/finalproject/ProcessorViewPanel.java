package finalproject;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProcessorViewPanel implements Observer {
	private JTextField accumulator = new JTextField();
	private JTextField programCounter = new JTextField();
	private Machine machine;

	public ProcessorViewPanel(Machine machine) {
		this.machine =machine;
		machine.addObserver(this);
	}
	
	public JComponent createProcessorDisplay() {
		//TODO
		//build the processor display
        JPanel retVal = new JPanel();
        retVal.setLayout(new GridLayout(1,0));
        
        accumulator = new JTextField();
        retVal.add(new JLabel("Accumulator:", JLabel.RIGHT));
        retVal.add(accumulator);
        programCounter = new JTextField();
        retVal.add(new JLabel("ProgramCounter:", JLabel.RIGHT));
        retVal.add(programCounter);
		return retVal;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		//TODO
		// set the accumulator and ip fields using
		// the appropriate methods of machine
		accumulator.setText(Integer.toString(machine.getAcc()));
		programCounter.setText(Integer.toString(machine.getIp()));
	}

}
