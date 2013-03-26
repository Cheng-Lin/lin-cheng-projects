package finalproject;
/**
 * Class ANDI provides an implementation of the Instruction class that 
 * performs a logical and of the argument and the accumulator of the 
 * processor, using immediate addressing and storing the result in the
 * accumulator.
 * @author CS 140
 */
public class ANDI extends Instruction {

	/**
	 * Constructor for the ANDI instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public ANDI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "AND #" for this instruction
	 */
	@Override
	public String getName() {
		return "AND #";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00011000 [(byte)24] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)24;
	}

	/**
	 * Predicate that indicates that this instruction
	 * is immediate
	 * @return true, this instruction is immediate 
	 */
	@Override
	public boolean isImmediate() {
        return true;
    }

	/**
	 * The execute method for this instruction, which performs
	 * a logical and between argument "arg" and the accumulator, 
	 * storing the result in the accumulator. It also increments 
	 * the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory. 
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		if (arg != 0 && proc.getAcc() != 0) {
			proc.setAcc(1);
		} else {
			proc.setAcc(0);
		}
		proc.incIP();
	}

}
