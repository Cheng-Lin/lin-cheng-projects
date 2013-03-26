/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * @author Kebang Huang
 *
 */
public class GameMenu extends JMenuBar
	implements ActionListener 
{
	private GamePanel game;
	private JMenuItem open, save;
	
	// Constructor
	public GameMenu(GamePanel game)
	{	
		this.game = game;
		
		open = new JMenuItem("Open");
		open.setMnemonic('O');
		open.addActionListener(this);
		
		save = new JMenuItem("Save");
		save.setMnemonic('S');
		save.addActionListener(this);
		
		add(open);
		add(save);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == open)
			try {
				game.OpenFile();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Open File Error: %S%N", 
						"File Error", JOptionPane.ERROR_MESSAGE);
			}
		else if (e.getSource() == save)
			game.SaveFile();
	}
}
