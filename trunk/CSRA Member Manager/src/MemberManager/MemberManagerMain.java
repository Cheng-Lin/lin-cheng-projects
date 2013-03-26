package MemberManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class MemberManagerMain extends JFrame {

	private JPanel contentPane;
	private MemberManagerDataPanel dataPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagerMain frame = new MemberManagerMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberManagerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		MemberManagerMenuBar menuBar = new MemberManagerMenuBar(this);
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		dataPanel = new MemberManagerDataPanel();
		dataPanel.setOpaque(true);
		contentPane.add(dataPanel, BorderLayout.CENTER);
		
		MemberManagerControlPanel contrPanel = new MemberManagerControlPanel(this);
		contentPane.add(contrPanel, BorderLayout.SOUTH);
	}

	public void addNewMember() {
		dataPanel.addNewMember();
	}
	
	public void addNewCategory() {
		dataPanel.addNewCategory();
	}

	public void removeMember() {
        dataPanel.removeMember();
	}

	public void removeCategory() {
        dataPanel.removeCategory();
	}

	public void openFile() throws IOException {
		dataPanel.openFile();
	}

	public void saveFile() {
        dataPanel.saveFile();	
	}

	public void sortHours() {
		dataPanel.sortHours();
	}
}
