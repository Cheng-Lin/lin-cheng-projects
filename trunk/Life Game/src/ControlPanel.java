import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel
implements ActionListener
{
	GamePanel panel;
	private JTextField txtRows, txtColumns, txtLives;
	private JButton btnNewGen, btnNextGen, btnAutoON, btnAutoOFF;

	public ControlPanel(GamePanel gPanel)
	{
		panel = gPanel;

		setLayout(new GridLayout(2, 5, 6, 3));

		add(new JLabel("  Rows: "));
		add(new JLabel("  Columns: "));
		add(new JLabel("  Lives About: "));

		btnNewGen = new JButton("New");
		btnNewGen.addActionListener(this);
		add(btnNewGen);

		btnNextGen = new JButton("Next");
		btnNextGen.addActionListener(this);
		add(btnNextGen);

		txtRows = new JTextField(5);
		add(txtRows);

		txtColumns = new JTextField(5);
		add(txtColumns);

		txtLives = new JTextField(5);
		add(txtLives);

		btnAutoON = new JButton("Auto On");
		btnAutoON.addActionListener(this);
		add(btnAutoON);

		btnAutoOFF = new JButton("Auto Off");
		btnAutoOFF.addActionListener(this);
		add(btnAutoOFF);
	}

	public void actionPerformed(ActionEvent e)
	{
		String strRows, strColumns, strLives;
		int intRows, intColumns, intLives;

		if ((JButton)e.getSource() == btnNewGen)
		{
			strRows = txtRows.getText();
			intRows = Integer.parseInt(strRows);
			if (intRows <= 0)
				intRows = 1;

			strColumns = txtColumns.getText();
			intColumns = Integer.parseInt(strColumns);
			if (intColumns <=0)
				intColumns = 1;

			strLives = txtLives.getText();
			intLives = Integer.parseInt(strLives);
			if (intLives > intRows * intColumns)
				intLives = intRows * intColumns;

			panel.newGen(intRows, intColumns, intLives);
		}
		else if ((JButton)e.getSource() == btnNextGen)
		{
			panel.nextGen();
		}
		else if ((JButton)e.getSource() == btnAutoON)
		{
			panel.autoON();
		}
		else if ((JButton)e.getSource() == btnAutoOFF)
		{
			panel.autoOFF();
		}
	}
}