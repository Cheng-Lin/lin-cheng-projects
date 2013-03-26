package MemberManager;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MemberManagerMenuBar extends JMenuBar 
{
	public MemberManagerMenuBar(final MemberManagerMain main) {
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		add(mnFile);
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					main.openFile();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error encountered when reading the file", 
							"File Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		mntmOpenFile.setMnemonic('O');
		mnFile.add(mntmOpenFile);
		
		JMenuItem mntmSaveFile = new JMenuItem("Save File");
		mntmSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.saveFile();
			}
		});
		mntmSaveFile.setMnemonic('S');
		mnFile.add(mntmSaveFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.dispose();
			}
		});
		mntmExit.setMnemonic('E');
	    mnFile.addSeparator();
		mnFile.add(mntmExit);
		
		JMenu mnSort = new JMenu("Sort");
		mnSort.setMnemonic('r');
		add(mnSort);
		
		JMenuItem mntmSortByHoursweek = new JMenuItem("Sort by Hours/Week");
		mntmSortByHoursweek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.sortHours();
			}
		});
		mnSort.setMnemonic('H');
		mnSort.add(mntmSortByHoursweek);
	}
}
