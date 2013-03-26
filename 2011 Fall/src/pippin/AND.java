package pippin;
/**
 * Class AND provides an implementation of the Instruction class that 
 * performs a logical and of the argument and the accumulator of the 
 * processor, using direct addressing and storing the result in the
 * accumulator.
 * @author CS 140
 */
public class AND extends Instruction {

	/**
	 * Constructor for the AND instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public AND(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "AND" for this instruction
	 */
	@Override
	public String getName() {
		return "AND";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00001000 [(byte)8] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)8;
	}

	/**
	 * The execute method for this instruction, which performs
	 * a logical and between the contents of memory at index 
	 * "arg" and the accumulator, storing the result in the
	 * accumulator. It also increments the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory. 
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		if (data.getData(arg) != 0 && proc.getAcc() != 0) {
			proc.setAcc(1);
		} else {
			proc.setAcc(0);
		}
		proc.incIP();
	}

}
