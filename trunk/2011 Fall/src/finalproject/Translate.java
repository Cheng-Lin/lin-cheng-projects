package finalproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Translate {

	public static boolean loadSource(ArrayList<CodeSourceLine> code, 
			ArrayList<DataSourceLine> data, File file) 
					throws FileNotFoundException {
		boolean retVal = true;
		int lineNumber = 0;
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			lineNumber++;
			if(line.trim().length() > 0) {
				if (line.charAt(0) == ' ' || line.charAt(0) == '\t') {
					code.add(new CodeSourceLine("ERROR: White space at start of line", 0, lineNumber, line));
					retVal = false;
				}
				String[] parts = line.split("\\s+");
				if (parts.length > 3) {
					code.add(new CodeSourceLine("ERROR: Too many arguments on the line", 0, lineNumber, line) );
					retVal = false;
				}
				if (parts.length == 3) {
					if (parts[1].equals("#")) {
						parts = new String[] {parts[0], "#" + parts[2]};
					} else if (parts[1].equals("&")) {
						parts = new String[] {parts[0], "&" + parts[2]};
					} else {
						code.add(new CodeSourceLine("ERROR: Too many arguments on the line", 0, lineNumber, line) );
						retVal = false;					
					}
				}
				if (parts.length == 2) {
					if(CodeSourceLine.INSTR_NUM_ARGS.containsKey(parts[0])) {
						if(parts[0].equals("STO") && parts[1].charAt(0) == '#') {
							code.add(new CodeSourceLine("ERROR: STO cannot have immediate argument", 0, lineNumber, line));
							retVal = false;
						} else {
							int numArgs = CodeSourceLine.INSTR_NUM_ARGS.get(parts[0]);
							if (numArgs == 0) {
								code.add(new CodeSourceLine("ERROR: Argument not required", 0, lineNumber, line));
								retVal = false;					
							} else {
								if(parts[1].charAt(0) == '#') {
									parts[0] = parts[0] + "I";
									parts[1] = parts[1].substring(1);
								} else if(parts[1].charAt(0) == '&') {
									parts[0] = parts[0] + "N";
									parts[1] = parts[1].substring(1);							
								}
								int arg = 0;
								try {
									arg = Integer.parseInt(parts[1],16);
									code.add(new CodeSourceLine(parts[0], arg, lineNumber, line));
								} catch(NumberFormatException nfe) {
									code.add(new CodeSourceLine("ERROR: Argument not a number", 0, lineNumber, line));
									retVal = false;												
								}
							}
						}
					} else {
						int x = 0;
						int y = 0;
						try {
							x = Integer.parseInt(parts[0],16);
							y = Integer.parseInt(parts[1],16);
							data.add(new DataSourceLine(x, y, lineNumber, line));
						} catch(NumberFormatException nfe) {
							code.add(new CodeSourceLine("ERROR: Illegal instruction", 0, lineNumber, line));
							retVal = false;												
						}					
					}
				}
				if (parts.length == 1) {
					if(CodeSourceLine.INSTR_NUM_ARGS.containsKey(parts[0])) {
						int numArgs = CodeSourceLine.INSTR_NUM_ARGS.get(parts[0]);
						if (numArgs == 0) {
							code.add(new CodeSourceLine(parts[0], 0, lineNumber, line));
						} else {
							code.add(new CodeSourceLine("ERROR: Missing Argument", 0, lineNumber, line));
							retVal = false;
						}
					} else {
						code.add(new CodeSourceLine("ERROR: Illegal instruction", 0, lineNumber, line));
						retVal = false;																	
					}
				}
			}
		}
		return retVal;
	}

	public static void translate(String in, String out, String err) {
		PrintWriter pw = null;
		ArrayList<CodeSourceLine> code = null;
		ArrayList<DataSourceLine> data = null;
		code = new ArrayList<CodeSourceLine>();
		data = new ArrayList<DataSourceLine>();
		boolean validSource = false;
		try {
			validSource = Translate.loadSource(code, data, new File(in));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found, please " +
					"check the file selected");
		}
		try {
			pw = new PrintWriter(out);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to create output " +
					"file: " + out +  "\nPlease " +
					"check the source file selected");
		}
		if (validSource) {
			if (code != null) {
				for(CodeSourceLine c : code) {
					System.out.println(c);
					pw.println(CodeUtilities.getInstrBinary(c.getInstName()) + 
							CodeUtilities.getArgBinary(c.getArg()));
				}
			}
			if (data != null) {
				for(DataSourceLine d : data) {
					System.out.println(d);
					pw.println(CodeUtilities.getArgBinary(d.getData()[0])
							+CodeUtilities.getArgBinary(d.getData()[1]));
				}		
			}
		} else {
			//TODO
			// Create the error file and write what is 
			// currently appearing in the console to the file
			// Then eliminate the console output
			File f = new File("errlog.err");
			try {
				pw = new PrintWriter(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(CodeSourceLine c : code){
				pw.println(c.toString());
			}
			code = null;
			for(DataSourceLine d : data){
				pw.println(d.toString());
			}
			data = null;

			JOptionPane.showMessageDialog(null, "Errors in " +
					"source file.\nPlease " +
					"check the error log: ");			
		}
		if (pw != null) {
			pw.close();
		}
	}
}

