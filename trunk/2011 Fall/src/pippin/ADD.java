package pippin;
/**
 * Class ADD provides an implementation of the Instruction class that 
 * adds an argument to the accumulator of the processor, using 
 * direct addressing.
 * @author CS 140
 */
public class ADD extends Instruction {

	/**
	 * Constructor for the ADD instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public ADD(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "ADD" for this instruction
	 */
	@Override
	public String getName() {
		return "ADD";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00000000 [(byte)0] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)0;
	}

	/**
	 * The execute method for this instruction, which adds
	 * the contents of memory at index "arg" to the accumulator
	 * and also increments the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory. 
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(data.getData(arg) + proc.getAcc());
		proc.incIP();
	}
	
}
