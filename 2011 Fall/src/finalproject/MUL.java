package finalproject;
/**
 * Class MUL provides an implementation of the Instruction class that 
 * multiplies the accumulator of the processor by an argument, using 
 * direct addressing.
 * @author CS 140
 */
public class MUL extends Instruction {

	/**
	 * Constructor for the MUL instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public MUL(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "MUL" for this instruction
	 */
	@Override
	public String getName() {
		return "MUL";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00000010 [(byte)2] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)2;
	}

	/**
	 * The execute method for this instruction, which multiples
	 * the accumulator by the contents of memory at index "arg"
	 * and also increments the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory. 
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(data.getData(arg) * proc.getAcc());
		proc.incIP();
	}

}
