import javax.swing.*;
import java.awt.event.*;

public class AppMenuBar extends JMenuBar 
{
	public AppMenuBar(final ImageProcessor driver) 
	{
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		add(fileMenu);
		
		JMenuItem loadPic = new JMenuItem("Load Picture");
		loadPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				driver.loadPicture();
			}
		});
		loadPic.setMnemonic('L');
		fileMenu.add(loadPic);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				driver.dispose();
			}
		});
		exit.setMnemonic('E');
		fileMenu.addSeparator();
		fileMenu.add(exit);
	}
}
