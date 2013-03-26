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
public class FileLoader
{
	private MemberDataModel dataModel;
	private BufferedReader fileIn;

	// Constructor
	public FileLoader(MemberDataModel dataModel)
	{
		this.dataModel = dataModel;
	}

	public void OpenFile() throws IOException
	{
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			String path = fc.getSelectedFile().getPath();
			if (!path.substring(path.length() - 5).equals(".csra"))
			{
				JOptionPane.showMessageDialog(null, "Invalid File", 
						"File Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			File load = new File(path);
			try {
				fileIn = new BufferedReader(new FileReader(load));
			} catch (IOException x) {
				JOptionPane.showMessageDialog(null, "Open File Error: %S%N", 
						"File Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			ReadFile();
			fileIn.close();
		}
	}

	private void ReadFile() throws IOException
	{
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<ArrayList<String>> rowData = new ArrayList<ArrayList<String>>();

		String line = fileIn.readLine();
		if (line != null) {
			int lastQuote = 0;
			for (int i = 1; i < line.length(); i++) {
				if (line.charAt(i) == '"') {
					columnNames.add(line.substring(lastQuote + 1, i));
					lastQuote = i + 1;
					i += 2;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Invalid File", 
					"File Error", JOptionPane.ERROR_MESSAGE);			
		}

		line = fileIn.readLine();
		while (line != null) {
			rowData.add(new ArrayList<String>());

			int lastQuote = 0;
			String element = "";
			for (int i = 1; i < line.length(); i++) {
				if (line.charAt(i) == '"') {
					element = line.substring(lastQuote + 1, i);
					if (element.equals("null")) {
						rowData.get(rowData.size() - 1).add("");
					} else {
						rowData.get(rowData.size() - 1).add(element);
					}
					lastQuote = i + 1;
					i += 2;
				}
			} 
			line = fileIn.readLine();
		}
		
		dataModel.setTable(columnNames, rowData);
	}
}
