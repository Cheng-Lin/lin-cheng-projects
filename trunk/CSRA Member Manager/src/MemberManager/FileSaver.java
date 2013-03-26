package MemberManager;
/**
 * 
 */

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * @author Kebang Huang
 *
 */
public class FileSaver
{
	MemberDataModel dataModel;
	private PrintWriter fileOut;
	
	public FileSaver(MemberDataModel dataModel)
	{
		this.dataModel = dataModel;
	}
	
	public void SaveFile()
	{
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			String path = fc.getSelectedFile().getPath();
			if (!path.substring(path.length() - 5).equals(".csra"))
				path += ".csra";
			
			File load = new File(path);
			try {
				if (!load.createNewFile())
				{
					JOptionPane.showMessageDialog(null, "File Already Exist", 
							"File Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				fileOut = new PrintWriter(new BufferedWriter(new FileWriter(load)));
			} catch (IOException x) {
				JOptionPane.showMessageDialog(null, "Ccreate File Error: %S%N", 
						"File Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			WriteFile(dataModel.getColumn(), dataModel.getRow());
			fileOut.close();
		}
	}
	
	private void WriteFile(ArrayList<String> columnNames, ArrayList<ArrayList<String>> rowData)
	{
		int colSize = columnNames.size();
		for (int i = 0; i < colSize; i++) {
			fileOut.print("\"" + columnNames.get(i) + "\"");
		} 
		fileOut.println();
		
		for (int i = 0; i < rowData.size(); i++) {
			for (int j = 0; j < colSize; j++) {
				if (rowData.get(i).get(j).equals("")) {
					fileOut.print("\"" + "null" + "\"");
				} else {
					fileOut.print("\"" + rowData.get(i).get(j) + "\"");
				}
			}
			fileOut.println();
		}
	}
}