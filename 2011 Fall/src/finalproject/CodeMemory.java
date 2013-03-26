package finalproject;

public class CodeMemory {
	public static int CODE_SIZE = 256;

	private class CodeForm {
		Instruction instr;
		int arg;
		String binaryStringForm;
		String sourceForm;
	}
	
	private CodeForm[] code = new CodeForm[CODE_SIZE];

	/**
	 * Returns the operation part of an instruction at a specific location.
	 * @param location index of the instruction in the array
	 * @return the operation part of the instruction at this index or 
	 * null if nothing is stored there
	 * @throws CodeAccessException if the index is out of range
	 */
	public Instruction getInstruction(int location) throws CodeAccessException {
		if(location < 0 || location >= CODE_SIZE) {
			throw new CodeAccessException("Illegal index " + location);
		}
		Instruction instr = null;
		if (code[location] != null) {
			instr = code[location].instr; 
		}		
		return instr;
	}

	/**
	 * Returns the full source String form of the instruction:
	 * operation with its argument 
	 * @param location index of the instruction in the array
	 * @return the source String of the instruction such as LOD &5 or
	 * the empty String if nothing is stored there
	 * @throws CodeAccessException if the index is out of range
	 */
	public String getInstructionSource(int location) throws CodeAccessException {
		if(location < 0 || location >= CODE_SIZE) {
			throw new CodeAccessException("Illegal index " + location);
		}
		String str = "";
		if (code[location] != null) {
			str = code[location].sourceForm;
		}
		return str;
	}
	
	/**
	 * Returns the String representation of the 40-bit binary form of 
	 * the instruction: operation with its argument 
	 * @param location index of the instruction in the array
	 * @return the source String of the instruction such as 
	 * 0000110100000000000000000000000000001100 or 
	 * the empty String if nothing is stored there
	 * @throws CodeAccessException if the index is out of range
	 */
	public String getInstructionBinaryForm(int location) throws CodeAccessException {
		if(location < 0 || location >= CODE_SIZE) {
			throw new CodeAccessException("Illegal index " + location);
		}
		String str = "";
		if (code[location] != null) {
			str = code[location].binaryStringForm;
		}
		return str;
	}

	/**
	 * Returns the argument of an instruction at a specific location.
	 * @param location index of the instruction in the array
	 * @return the argument of the instruction at this index or 
	 * 0 if nothing is stored there
	 * @throws CodeAccessException if the index is out of range
	 */	
	public int getArgument(int location) throws CodeAccessException {
		if(location < 0 || location >= CODE_SIZE) {
			throw new CodeAccessException("Illegal index " + location);
		}
		int arg = 0;
		if (code[location] != null) {
			arg = code[location].arg;
		}
		return arg;
	}

	/**
	 * Clear all the code memory by setting all elements
	 * of the array to null
	 */
	public void clearCode() {
		for (int i = 0; i < CODE_SIZE; i++) {
			code[i] = null;
		}
	}

	/**
	 * Set all the information about an instruction at the
	 * specified location in the code memory array.
	 * @param location the index where the instruction is stored
	 * @param instr the operation object that is the operation part of the 
	 * instruction, e.g. the LODN object from the instructionSet map from 
	 * the Machine object
	 * @param arg the argument of this instruction
	 * @param binaryForm the String representation of the 40 bit binary 
	 * format of an instruction (operation/argument)
	 * @param sourceForm the String source form of an instruction 
	 * (operation/argument)
	 * @throws CodeAccessException if the index is out of range
	 */
	public void setInstruction(int location, Instruction instr, int arg, 
			String binaryForm, String sourceForm) 
					throws CodeAccessException {
		if(location < 0 || location >= CODE_SIZE) {
			throw new CodeAccessException("illegal index " + location);
		}
		code[location] = new CodeForm();
		code[location].instr = instr;
		code[location].arg = arg;
		code[location].binaryStringForm = binaryForm;
		code[location].sourceForm = sourceForm;
	}
}
