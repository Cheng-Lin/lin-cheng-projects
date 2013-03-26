package pippin;

import java.io.*;
import java.util.Scanner;

public class Loader 
{
	public static void load(CodeMemory code, DataMemory data, File file) throws FileNotFoundException, 
		NumberFormatException, CodeAccessException, DataAccessException, IllegalBinaryFormatException 
	{
		Scanner readFile = new Scanner(file);
		int count = 0;

		while (readFile.hasNextLine())
		{
			String line = readFile.nextLine();
			if (line.length() != 40 && line.length() != 64) {
				throw new IllegalBinaryFormatException("illegal index " + "Illegal Line " + line);
			}

			if (line.length() == 40) {
				long binary = Long.parseLong(line, 2);
				code.setInstruction(count, binary);
			} else {
				int address = Integer.parseInt(line.substring(0, 32), 2);
				int value = Integer.parseInt(line.substring(32), 2);
				data.setData(address, value);
			}
			
			count++;
		}
	}
}
