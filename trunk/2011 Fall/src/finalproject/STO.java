package finalproject;
/**
 * Class STO provides an implementation of the store
 * instruction, which stores the accumulator 
 * into the memory location given by an argument,
 * using direct addressing. 
 * @author CS 140
 */
public class STO extends Instruction {

	/**
	 * Constructor for the STO instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public STO(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "STO" for this instruction
	 */
	@Override
	public String getName() {
		return "STO";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00000101 [(byte)5] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)5;
	}

	/**
	 * The execute method for this instruction, which copies
	 * the contents of the accumulator to memory at index "arg" 
	 * and also increments the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory. 
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		data.setData(arg, proc.getAcc());
		proc.incIP();
	}

}
