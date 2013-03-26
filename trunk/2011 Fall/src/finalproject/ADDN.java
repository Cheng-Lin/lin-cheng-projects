package finalproject;
/**
 * Class ADDN provides an implementation of the Instruction class that 
 * adds an argument to the accumulator of the processor, using 
 * indirect addressing.
 * @author CS 140
 */
public class ADDN extends Instruction {

	/**
	 * Constructor for the ADDN instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public ADDN(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "ADD &" for this instruction
	 */
	@Override
	public String getName() {
		return "ADD &";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00100000 [(byte)32] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)32;
	}

	/**
	 * The execute method for this instruction, which adds
	 * the contents of memory to the accumulator and also 
	 * increments the instruction pointer. The specific memory
	 * element uses "arg" as the indirect argument (the value
	 * at this memory location is the address of the actual 
	 * value to be added)
	 * @arg the argument of the instruction, which is a
	 * location in the data memory containing the location of the
	 * value to be added.
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory or if the value at the location "arg" is
	 * an illegal location in data memory.
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		int arg1 = data.getData(arg);
		proc.setAcc(proc.getAcc()+data.getData(arg1));
		proc.incIP();	
	}

}
