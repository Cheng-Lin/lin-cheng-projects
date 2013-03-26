package pippin;

import java.io.*;
import java.util.*;

public class Translate 
{
	public static boolean loadSource(ArrayList<CodeSourceLine> code, ArrayList<DataSourceLine> data, File file) throws FileNotFoundException
	{
		boolean returnValue = true;
		Scanner readFile = new Scanner(file);
		int lineNumber = 0;

		while (readFile.hasNextLine())
		{
			String line = readFile.nextLine();
			lineNumber++;

			if (line.trim().length() != 0)
			{
				if (line.charAt(0) == ' ' || line.charAt(0) == '\t') {
					code.add(new CodeSourceLine("ERROR: White space at start of line", 0, lineNumber, line)); 
					returnValue = false;
				} else {
					String[] parts = line.trim().split("\\s+");
					if (parts.length > 3)
					{
						code.add(new CodeSourceLine("ERROR: Too many arguments on the line", 0, lineNumber, line));
						returnValue = false;
					}
					else if (parts.length == 3)
					{
						if (parts[1].equals("#")) 
						{
							parts = new String[]{parts[0], "#" + parts[2]};
						}
						else if (parts[1].equals("&")) 
						{
							parts = new String[]{parts[0], "&" + parts[2]};
						} 
						else 
						{
							code.add(new CodeSourceLine("ERROR: Too many arguments on the line", 0, lineNumber, line));
							returnValue = false;
						}
					}

					if (parts.length == 2) 
					{
						if (CodeSourceLine.INSTR_NUM_ARGS.containsKey(parts[0])) {
							if (parts[0].equals("STO") && parts[1].charAt(0) == '#') {
								code.add(new CodeSourceLine("ERROR: STO cannot have immediate argument", 0, lineNumber, line));
								returnValue = false;
							} else {
								int x = CodeSourceLine.INSTR_NUM_ARGS.get(parts[0]);
								if (x == 1) {
									if (parts[1].charAt(0) == '#')
									{
										try {
											int arg = Integer.parseInt(parts[1].substring(1), 16);
											code.add(new CodeSourceLine(parts[0]+"I", arg, lineNumber, line));
										} catch (NumberFormatException e) {
											code.add(new CodeSourceLine("ERROR: Argument is badly formatted", 0, lineNumber, line)); 
											returnValue = false;
										}
									}
									else if (parts[1].charAt(0) == '&')
									{
										try {
											int arg = Integer.parseInt(parts[1].substring(1), 16);
											code.add(new CodeSourceLine(parts[0]+"N", arg, lineNumber, line));
										} catch (NumberFormatException e) {
											code.add(new CodeSourceLine("ERROR: Argument is badly formatted", 0, lineNumber, line)); 
											returnValue = false;
										}
									}
									else
									{
										try {
											int arg = Integer.parseInt(parts[1].substring(0), 16);
											code.add(new CodeSourceLine(parts[0], arg, lineNumber, line));
										} catch (NumberFormatException e) {
											code.add(new CodeSourceLine("ERROR: Argument is badly formatted", 0, lineNumber, line)); 
											returnValue = false;
										}
									}
								} else {
									code.add(new CodeSourceLine("ERROR: Argument not required", 0, lineNumber, line)); 
									returnValue = false;
								}
							}
						} else {
							try {
								int x = Integer.parseInt(parts[0], 16);
								int y = Integer.parseInt(parts[1], 16);
								data.add(new DataSourceLine(x, y, lineNumber, line));
							} catch (NumberFormatException e) {
								code.add(new CodeSourceLine("ERROR: illegal instruction", 0, lineNumber, line)); 
								returnValue = false;
							}
						}
					}
					else if (parts.length == 1)
					{
						if (CodeSourceLine.INSTR_NUM_ARGS.get(parts[0]) == 0) {
							code.add(new CodeSourceLine(parts[0], 0, lineNumber, line));
						} else {
							code.add(new CodeSourceLine("ERROR: Argument is missing", 0, lineNumber, line)); 
							returnValue = false;
						}
					}
				}
			}
		}

		return returnValue;
	}
}