package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Ke-Bang Huang
 *
 */
public class Test 
{
	/**
	 * Main Method for testing Translate class
	 * @param args command line arguments not used
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		Translate test = new Translate();
		
		ArrayList<CodeSourceLine> code = new ArrayList<CodeSourceLine>();
		ArrayList<DataSourceLine> data = new ArrayList<DataSourceLine>();
		
		test.loadSource(code, data, new File("test.txt"));
		
		for (CodeSourceLine c : code) {
			System.out.println(c.toString());
		}
		
		for (DataSourceLine d : data) {
			System.out.println(d.toString());
		}
	}
}
