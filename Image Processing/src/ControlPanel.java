import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.Choice;
import java.awt.List;

public class ControlPanel extends JPanel
	implements ActionListener, ChangeListener
{
	private ImageProcessor imgProc;
	private JCheckBox scaling, translation;
	private JSpinner rotation;
	private JLabel lblDegree;
	
	public ControlPanel(ImageProcessor imgProcIn) 
	{
		imgProc = imgProcIn;		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		scaling = new JCheckBox("Scaling", true);
		scaling.addActionListener(this);
		add(scaling);		
		
		translation = new JCheckBox("Translation", true);
		translation.addActionListener(this);
		add(translation);		
		
		JLabel lblRotation = new JLabel("Rotation:");
		add(lblRotation);
		
		rotation = new JSpinner();
		rotation.setModel(new SpinnerNumberModel(0, -360, 360, 1));
		rotation.addChangeListener(this);
		add(rotation);
		
		lblDegree = new JLabel("degree");
		add(lblDegree);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == translation) {
			imgProc.translationEnable(translation.isSelected());
		} else if (e.getSource() == scaling) {
			imgProc.scalingEnable(scaling.isSelected());
		}
	}

	public void stateChanged(ChangeEvent e) {
		imgProc.setRotation(((Integer)rotation.getValue()).intValue());
	}
}
