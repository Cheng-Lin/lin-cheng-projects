package finalproject;
/**
 * Class SUB provides an implementation of the Instruction class that 
 * subtracts an argument from the accumulator of the processor, using 
 * direct addressing.
 * @author CS 140
 *
 */
public class SUB extends Instruction {

	/**
	 * Constructor for the SUB instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public SUB(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "SUB" for this instruction
	 */
	@Override
	public String getName() {
		return "SUB";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00000001 [(byte)1] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)1;
	}

	/**
	 * The execute method for this instruction, which subtracts
	 * the contents of memory at index "arg" from the accumulator
	 * and also increments the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory. 
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(proc.getAcc() - data.getData(arg));
		proc.incIP();
	}

}
