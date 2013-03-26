package pippin;
/**
 * Class SUBN provides an implementation of the Instruction class that 
 * subtracts an argument from the accumulator of the processor, using 
 * indirect addressing.
 * @author CS 140
 *
 */
public class SUBN extends Instruction {

	/**
	 * Constructor for the SUBN instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public SUBN(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "SUB &" for this instruction
	 */
	@Override
	public String getName() {
		return "SUB &";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00100001 [(byte)33] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)33;
	}

	/**
	 * The execute method for this instruction, which subtracts
	 * the contents of memory from the accumulator and also 
	 * increments the instruction pointer. The specific memory
	 * element uses "arg" as the indirect argument (the value
	 * at this memory location is the address of the actual 
	 * value to be subtracted)
	 * @arg the argument of the instruction, which is a
	 * location in the data memory containing the location of the
	 * value to be subtracted.
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory or if the value at the location "arg" is
	 * an illegal location in data memory.
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		int arg1 = data.getData(arg);
		proc.setAcc(proc.getAcc() - data.getData(arg1));
		proc.incIP();
	}

}
