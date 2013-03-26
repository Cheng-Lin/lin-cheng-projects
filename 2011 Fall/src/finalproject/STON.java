package finalproject;
/**
 * Class STO provides an implementation of the store
 * instruction, which stores the accumulator 
 * into the memory location given by an argument,
 * using indirect addressing. 
 * @author CS 140
 */
public class STON extends Instruction {

	/**
	 * Constructor for the STO instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public STON(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "STO &" for this instruction
	 */
	@Override
	public String getName() {
		return "STO &";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00100101 [(byte)37] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)37;
	}

	/**
	 * The execute method for this instruction, which copies
	 * the contents of the accumulator to memory and also 
	 * increments the instruction pointer. The specific memory
	 * element uses "arg" as the indirect argument (the value
	 * at this memory location is the address of the actual 
	 * value to be used)
	 * @arg the argument of the instruction, which is a
	 * location in the data memory containing the location of the
	 * value to be used.
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory or if the value at the location "arg" is
	 * an illegal location in data memory.
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		data.setData(data.getData(arg), proc.getAcc());
		proc.incIP();
	}

}
