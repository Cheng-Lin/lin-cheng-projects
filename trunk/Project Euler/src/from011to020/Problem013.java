package from011to020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem013 
{
	public static void main(String[] args) 
	{
		File inputFile = new File("problem/from011to020/Problem013.txt");
		Scanner fin = null;
		
		double num = 0;
		double sum = 0;
		
		try {
			fin = new Scanner(inputFile);
			
			while (fin.hasNextDouble())
			{
				num = fin.nextDouble();
				sum += num;
			}
			
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			System.err.println("Invalid Input File. Error Message: "
					+ e.toString());
			System.exit(1);
		} finally {
			if (fin != null) {
				fin.close();
			}
		}	
	}
}