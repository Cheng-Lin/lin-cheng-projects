/**
 * 
 */

import java.io.*;
import javax.swing.*;

import javax.media.j3d.RenderingAttributes;

/**
 * @author Kebang Huang
 *
 */
public class FileLoader
{
	private GamePanel game;
	private BufferedReader fileIn;
	
	// Constructor
	public FileLoader(GamePanel game)
	{
		this.game = game;
	}
	
	public void OpenFile() throws IOException
	{
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			String path = fc.getSelectedFile().getPath();
			if (!path.substring(path.length() - 4).equals(".gol"))
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
		String dimension = fileIn.readLine();
		
		int rows = Integer.parseInt(dimension.substring(0, 3));
		int columns = Integer.parseInt(dimension.substring(3, 6));
		int steps = Integer.parseInt(dimension.substring(6));
		
		game.createLifeCube(rows, columns, steps, 0);
		RenderingAttributes[][][] ra = game.getRA();
		
		for (int x = 0; x < rows; x++)
			for (int y = 0; y < columns; y++)
				for (int z = 0; z < steps; z++)
					ra[x][y][z].setVisible(Boolean.parseBoolean(
							fileIn.readLine().substring(0, 4)));
	}
}
