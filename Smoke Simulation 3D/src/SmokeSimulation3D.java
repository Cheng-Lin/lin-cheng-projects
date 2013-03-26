/**
 * 
 */

import java.awt.*;
import javax.swing.*;

import com.sun.j3d.utils.applet.MainFrame;

/**
 * @author Kaito
 *
 */
public class SmokeSimulation3D extends JApplet
{
	SmokePanel smoke;
	
	// Initiating
	public void init()
	{
		smoke = new SmokePanel();
		
		ControlPanel control = new ControlPanel(smoke);
		
		// add panels to the applet windows
		Container c = getContentPane();
		c.add(control,BorderLayout.NORTH);
		c.add(smoke, BorderLayout.CENTER);
	}

	public void stop()
	{	smoke.stop();	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// convert applet into application
		new MainFrame(new SmokeSimulation3D(), 400, 436);
	}
}
