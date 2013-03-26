package MemberManager;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import java.io.IOException;

public class MemberManagerDataPanel extends JScrollPane 
{
	private JTable dataTable;
	private MemberDataModel dataModel;
	private FileLoader fl;
	private FileSaver fs;

	public MemberManagerDataPanel() 
	{
		dataModel = new MemberDataModel(this);
		dataTable = new JTable(dataModel);

		setDefaultColumnSize();
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setViewportView(dataTable);
		
		fl = new FileLoader(dataModel);
		fs = new FileSaver(dataModel);
	}

	public void setDefaultColumnSize() {
		TableColumn column = null;
		for (int i = 0; i < dataTable.getColumnCount(); i++) {
			column = dataTable.getColumnModel().getColumn(i);
			String s = dataTable.getColumnName(i);
			column.setPreferredWidth(s.length() * 10);
		}
	}

	public void addNewMember() {
		dataModel.addNewMember();
	}

	public void addNewCategory() {
		dataModel.addNewCategory();
	}

	public void removeMember() {
		int row = dataTable.getEditingRow();
		if (row != -1) {
			JOptionPane.showMessageDialog(null, "Please finish editing a cell before removing a member.", 
					"Stop Editing", JOptionPane.ERROR_MESSAGE);
		} else {
			row = dataTable.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Please select the member you want to remove.", 
						"Selection Required", JOptionPane.ERROR_MESSAGE);
			} else {
				dataModel.removeMember(row);
			}
		}
	}

	public void removeCategory() {
		int col = dataTable.getEditingColumn();
		if (col != -1) {
			JOptionPane.showMessageDialog(null, "Please finish editing a cell before removing a member.", 
					"Stop Editing", JOptionPane.ERROR_MESSAGE);
		} else {
			col = dataTable.getSelectedColumn();
			if (col == -1) {
				JOptionPane.showMessageDialog(null, "Please select the member you want to remove.", 
						"Selection Required", JOptionPane.ERROR_MESSAGE);
			} else {
				dataModel.removeCategory(col);
			}
		}
	}

	public void openFile() throws IOException {
		fl.OpenFile();
	}

	public void saveFile() {
		fs.SaveFile();
	}

	public void sortHours() {
		dataModel.sortHours();
	}
}
