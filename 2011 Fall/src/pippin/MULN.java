package pippin;
/**
 * Class MULN provides an implementation of the Instruction class that 
 * multiplies the accumulator of the processor by an argument, using 
 * indirect addressing.
 * @author CS 140
 */
public class MULN extends Instruction {

	/**
	 * Constructor for the MULN instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public MULN(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "MUL &" for this instruction
	 */
	@Override
	public String getName() {
		return "MUL &";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00100010 [(byte)34] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)34;
	}

	/**
	 * The execute method for this instruction, which multiples
	 * the accumulator by the contents of memory and also
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
		int arg1 = data.getData(arg);
		proc.setAcc(data.getData(arg1) * proc.getAcc());
		proc.incIP();
	}

}
