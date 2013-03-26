package MemberManager;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MemberDataModel extends AbstractTableModel 
{
	private MemberManagerDataPanel parentPanel;
	private ArrayList<String> columnNames = new ArrayList<String>();
	private ArrayList<ArrayList<String>> rowData = new ArrayList<ArrayList<String>>();

	public MemberDataModel(MemberManagerDataPanel parentPanel) {
		this.parentPanel = parentPanel;

		columnNames.add("Last Name");
		columnNames.add("First Name");
		columnNames.add("Major");
		columnNames.add("Prog Lang Known");
		columnNames.add("Hours/Week");
		columnNames.add("Current Project");
		columnNames.add("Past Projects");

		rowData.add(new ArrayList<String>());
		for (int i = 0; i < columnNames.size(); i++) {
			rowData.get(0).add("");
		}
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public int getRowCount() {
		return rowData.size();
	}

	public String getColumnName(int col) {
		return columnNames.get(col);
	}

	public Object getValueAt(int row, int col) {
		return rowData.get(row).get(col);
	}

	public boolean isCellEditable(int row, int col) {
		return true;
	}

	public void setValueAt(Object value, int row, int col) {
		((String)value).trim();
		if (columnNames.get(col).equals("Hours/Week")) {
			try {
				double num = Double.parseDouble((String)value);
				rowData.get(row).set(col, (String)value);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a number for Hours/Week", 
						"Bad Input", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			rowData.get(row).set(col, (String)value);
		}
		fireTableCellUpdated(row, col);
	}

	public void addNewMember() {
		rowData.add(new ArrayList<String>());
		int lastRow = getRowCount();
		for (int i = 0; i < getColumnCount(); i++) {
			rowData.get(lastRow - 1).add("");
		}
		fireTableRowsInserted(lastRow - 1, lastRow - 1);
	}

	public void addNewCategory() {
		String newCriterion = JOptionPane.showInputDialog(null, 
				"Enter a name for the new category: ", 
				"New Category", JOptionPane.PLAIN_MESSAGE).trim();
		if (newCriterion.equals("")) {
			JOptionPane.showMessageDialog(null, "Invalid Input", 
					"Bad Input", JOptionPane.ERROR_MESSAGE);
		} else {
			columnNames.add(newCriterion);
			for (int i = 0; i < getRowCount(); i++) {
				rowData.get(i).add("");
			}
			fireTableStructureChanged();
			parentPanel.setDefaultColumnSize();
		}
	}

	public void removeMember(int row) {
		rowData.remove(row);
		fireTableRowsDeleted(row, row);		
	}

	public void removeCategory(int col) {
		// TODO Auto-generated method stub
		columnNames.remove(col);
		for (int i = 0; i < getRowCount(); i++) {
			rowData.get(i).remove(col);
		}
		fireTableStructureChanged();
		parentPanel.setDefaultColumnSize();
	}

	public void setTable(ArrayList<String> columnNames, ArrayList<ArrayList<String>> rowData) {
		this.columnNames = columnNames;
		this.rowData = rowData;
		fireTableStructureChanged();
		parentPanel.setDefaultColumnSize();		
	}

	public ArrayList<String> getColumn() {
		return columnNames;
	}

	public ArrayList<ArrayList<String>> getRow() {
		return rowData;
	}

	public void sortHours() {
		int indexHours = -1;
		for (int i = 0; i < columnNames.size() && indexHours == -1; i++) {
			if (columnNames.get(i).equals("Hours/Week")) {
				indexHours = i;
			}
		}

		if (indexHours != -1) {
			for (int i = 0; i < rowData.size(); i++) {
				try {
					double temp = Double.parseDouble(rowData.get(i).get(indexHours));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please make sure all data in Hours/Week column are filled", 
							"Column Not Filled Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			quickSort(0, rowData.size() - 1, indexHours);
			fireTableDataChanged();
		} else {
			JOptionPane.showMessageDialog(null, "Missing Hours/Week category", 
					"Category Not Found Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void quickSort(int lowIn, int highIn, int index) {
		int low = lowIn;
		int high = highIn;

		if (low < highIn) {
			double middle = Double.parseDouble(rowData.get((high + low) / 2).get(index));
			double temp = 0.0;
			while (low < high) {
				temp = Double.parseDouble(rowData.get(low).get(index));
				while (low < high && temp < middle) {
					low++;
					temp = Double.parseDouble(rowData.get(low).get(index));
				}
				
				temp = Double.parseDouble(rowData.get(high).get(index));
				while (low < high && temp > middle) {
					high--;
					temp = Double.parseDouble(rowData.get(high).get(index));
				}
				
				if (low < high) {
					ArrayList<String> swapT = rowData.get(low);
					rowData.set(low, rowData.get(high));
					rowData.set(high, swapT);
				}
			}
			
			if (high < low) {
				int swapI = low;
				low = high;
				high = swapI;
			}
			
			quickSort(lowIn, low, index);
			if (low == lowIn) {
				quickSort(low + 1, highIn, index);
			} else {
				quickSort(low, highIn, index);
			}
		}
	}
}
