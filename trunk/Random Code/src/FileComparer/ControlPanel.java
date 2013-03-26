package FileComparer;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class ControlPanel extends JPanel
{
	public ControlPanel()
	{
		((FlowLayout)getLayout()).setAlignment(FlowLayout.RIGHT);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JButton convert = new JButton("Convert");
		convert.addActionListener(new ConvertListener());
		add(convert);
	}
	
	private class ConvertListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{

		}
	}
}
