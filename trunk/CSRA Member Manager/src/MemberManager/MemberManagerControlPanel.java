package MemberManager;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MemberManagerControlPanel extends JPanel 
{
	public MemberManagerControlPanel(final MemberManagerMain main) 
	{
		JButton btnAddRows = new JButton("Add Member");
		btnAddRows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.addNewMember();
			}
		});
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		add(btnAddRows);
		
		JButton btnAddCriterion = new JButton("Add Category");
		btnAddCriterion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.addNewCategory();
			}
		});
		
		JButton btnRemoveMember = new JButton("Remove Member");
		btnRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.removeMember();
			}
		});
		add(btnRemoveMember);
		add(btnAddCriterion);
		
		JButton btnRemoveCategory = new JButton("Remove Category");
		btnRemoveCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.removeCategory();
			}
		});
		add(btnRemoveCategory);
	}
}
