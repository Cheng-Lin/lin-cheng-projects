package FileComparer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class FileComparer extends JFrame 
{
	public FileComparer()
	{
		super("File Comparer");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel filesPanel = new JPanel();
		filesPanel.setLayout(new GridLayout(1, 2));
		
		FilePanel1 file1 = new FilePanel1();
		JScrollPane js1 = new JScrollPane(file1);
	    js1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	    filesPanel.add(js1);
		
		FilePanel2 file2 = new FilePanel2();		
		JScrollPane js2 = new JScrollPane(file2);
	    js2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	    filesPanel.add(js2);
	    
	    ControlPanel control = new ControlPanel();
		
		Container c = getContentPane();
		c.add(filesPanel, BorderLayout.CENTER);
		c.add(control, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) 
	{
		FileComparer windows = new FileComparer();
		windows.setSize(600, 450);
		windows.setVisible(true);
	}
}
