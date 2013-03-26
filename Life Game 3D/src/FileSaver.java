/**
 * 
 */

import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;

import javax.media.j3d.RenderingAttributes;

/**
 * @author Kebang Huang
 *
 */
public class FileSaver
{
	private PrintWriter fileOut;
	
	public void SaveFile(RenderingAttributes ra[][][])
	{
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			String path = fc.getSelectedFile().getPath();
			if (!path.substring(path.length() - 4).equals(".gol"))
				path += ".gol";
			
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
			
			WriteFile(ra);
			fileOut.close();
		}
	}
	
	private void WriteFile(RenderingAttributes ra[][][])
	{
		int rows = ra.length;
		int columns = ra[0].length;
		int steps = ra[0][0].length;
		
		DecimalFormat formatter = new DecimalFormat("000");
		fileOut.println(formatter.format(rows) + formatter.format(columns) + formatter.format(steps));
		
		for (int x = 0; x < rows; x++)
			for (int y = 0; y < columns; y++)
				for (int z = 0; z < steps; z++)
					fileOut.println(ra[x][y][z].getVisible() + " " + 
							formatter.format(x) + formatter.format(y) + formatter.format(z));		
	}
}