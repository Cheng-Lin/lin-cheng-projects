import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LifeGame extends JApplet
{
	GamePanel games;
	ControlPanel controls;
	Container c;

	public void init()
	{
		games = new GamePanel();
		games.setBackground(Color.white);

		controls = new ControlPanel(games);

		c = getContentPane();
		c.add(controls, BorderLayout.NORTH);
		c.add(games, BorderLayout.CENTER);
	}
}