package pippin;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class CodeViewPanel implements Observer 
{
	JTextField instrFields[] = new JTextField[CodeMemory.CODE_SIZE];
	JTextField binaryFields[] = new JTextField[CodeMemory.CODE_SIZE];	
	
	@Override
	public void update(Observable o, Object arg) 
	{
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CodeViewPanel().createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setSize(300,500);
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("Code Memory View", JLabel.CENTER), BorderLayout.PAGE_START);
        frame.add(createCodeDisplay(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instrFields[0].setText("LOD 16");
        instrFields[1].setText("LOD #16");
        instrFields[2].setText("STO 5");
        instrFields[3].setText("LOD &5");
        instrFields[4].setText("MUL 16");
        instrFields[5].setText("STO &10");
        instrFields[6].setText("ADD 32");
        instrFields[7].setText("DIV #8");
        String str = "";
        str = CodeUtilities.getInstrBinary(new LOD(null,null)) + CodeUtilities.getArgBinary(16);
        binaryFields[0].setText(str);
        str = CodeUtilities.getInstrBinary(new LODI(null,null)) + CodeUtilities.getArgBinary(22);
        binaryFields[1].setText(str);
        str = CodeUtilities.getInstrBinary(new STO(null,null)) + CodeUtilities.getArgBinary(5);
        binaryFields[2].setText(str);
        str = CodeUtilities.getInstrBinary(new LODN(null,null)) + CodeUtilities.getArgBinary(5);
        binaryFields[3].setText(str);
        str = CodeUtilities.getInstrBinary(new MUL(null,null)) + CodeUtilities.getArgBinary(22);
        binaryFields[4].setText(str);
        str = CodeUtilities.getInstrBinary(new STON(null,null)) + CodeUtilities.getArgBinary(16);
        binaryFields[5].setText(str);
        str = CodeUtilities.getInstrBinary(new ADD(null,null)) + CodeUtilities.getArgBinary(32);
        binaryFields[6].setText(str);
        str = CodeUtilities.getInstrBinary(new DIVI(null,null)) + CodeUtilities.getArgBinary(8);
        binaryFields[7].setText(str);
        frame.setVisible(true);
    }

	public JComponent createCodeDisplay() 
	{
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
}
