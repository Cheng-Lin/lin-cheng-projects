package finalproject;

import java.util.Map;
import java.util.Scanner;

public class Loader {
	/**
	 * The method loads a program into the memory of the Pippin machine.
	 * The code and data memories are passed as a parameter.
	 * @param code the code array to store the instructions
	 * @param data the data array to store any initial data
	 * @param mapping map from bytes to instruction objects
	 * @param input the Scanner linked to the binary input file
	 * @throws IllegalBinaryFormat if there is an error in the input
	 */
	public static void load(CodeMemory code, DataMemory data, 
			Map<Byte, Instruction> mapping, Scanner input) 
					throws IllegalBinaryFormat {
		int i = 0;
		int lineCounter = 0;
		while(input.hasNextLine()) {
			String line = input.nextLine();
			lineCounter++;
			if(line.length() == 40) {
				try {
					byte b = Byte.parseByte(line.substring(0,8),2);
					int arg = 0;
					if(line.charAt(8) == '0') {
						arg = Integer.parseInt(line.substring(8),2);
					} else {
						arg = Integer.parseInt(line.substring(9),2) + Integer.MIN_VALUE;
					}
					Instruction instr = mapping.get(b);
					String instrSource = instr.getName();
					String sourceForm = instrSource + " ";
					if(arg >=0){
						sourceForm += Integer.toHexString(arg).toUpperCase();
					} else {
						sourceForm += ("-" + Integer.toHexString(-arg).toUpperCase());
					}
					sourceForm = sourceForm.replace("# ","#");
					sourceForm = sourceForm.replace("& ","&");
					code.setInstruction(i,instr,arg,line,sourceForm);
					i++;
				} catch (NumberFormatException e) {
					throw new IllegalBinaryFormat("File does not contain a " +
							"legal program.\nInstruction format error on " +
							"line " + lineCounter);
				} catch (CodeAccessException e) {
					throw new IllegalBinaryFormat("File does not contain a " +
							"legal program.\nCode memory address out of " +
							"bounds on line " + lineCounter);					
				} 
			} else if(line.length() == 64) {
				try {
					int location = Integer.parseInt(line.substring(0, 32),2);
					int value = Integer.parseInt(line.substring(32),2);
					data.setData(location, value);
				} catch (NumberFormatException e) {
					throw new IllegalBinaryFormat("File does not contain a " +
							"legal program.\nInteger format error on " +
							"line " + lineCounter);
				} catch (DataAccessException e) {
					throw new IllegalBinaryFormat("File does not contain a " +
							"legal program.\nData memory address out of " +
							"bounds on line " + lineCounter);					
				}
			} else {
				throw new IllegalBinaryFormat("File does not contain a " +
						"legal program. Error on line " + lineCounter);
			}
		}
	}
}
