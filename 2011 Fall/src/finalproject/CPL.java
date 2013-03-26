package finalproject;
/**
 * Class CPL provides an implementation of the Instruction class that 
 * sets the accumulator to true (1) or false (0) according as
 * the the argument is, or is not, negative, using 
 * direct addressing.
 * @author CS 140
 */
public class CPL extends Instruction {

	/**
	 * Constructor for the CPL instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public CPL(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "CPL" for this instruction
	 */
	@Override
	public String getName() {
		return "CPL";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00001011 [(byte)11] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)11;
	}

	/**
	 * The execute method for this instruction, which sets
	 * the accumulator to true (1) or false (0) according as
	 * the contents of memory at index "arg" is or is not 
	 * negative. It also increments the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory. 
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		if (data.getData(arg) < 0) {
			proc.setAcc(1);
		} else {
			proc.setAcc(0);
		}
		
		proc.incIP();
	}

}
