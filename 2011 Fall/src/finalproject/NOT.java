package finalproject;
/**
 * Class NOT provides an implementation of the Instruction class 
 * performs a logical not operation on the accumulator.
 * @author CS 140
 */
public class NOT extends Instruction {

	/**
	 * Constructor for the NOT instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public NOT(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "NOT" for this instruction
	 */
	@Override
	public String getName() {
		return "NOT";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00001001 [(byte)9] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)9;
	}

	/**
	 * Predicate indicating that this instruction does not take
	 * an argument
	 * @return false, the instruction does not take an argument
	 */
    public boolean requiresArgument() {
        return false;
    }

	/**
	 * The execute method of this instruction, sets the 
	 * accumulator to true (1) if it was false (0) and
	 * sets it to false (0) if it was true (non-zero). 
	 * It also increments the instruction pointer
	 * @param arg is not used
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		if (proc.getAcc() == 0) {
			proc.setAcc(1);
		} else {
			proc.setAcc(0);
		}
		
		proc.incIP();
	}

}
