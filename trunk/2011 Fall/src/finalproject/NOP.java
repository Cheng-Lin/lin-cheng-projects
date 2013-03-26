package finalproject;
/**
 * Class NOP provides an implementation of the Instruction class 
 * that only advances the instruction pointer.
 * @author CS 140
 */
public class NOP extends Instruction {

	/**
	 * Constructor for the NOP instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public NOP(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "NOP" for this instruction
	 */
	@Override
	public String getName() {
		return "NOP";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00001110 [(byte)14] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)14;
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
	 * The instruction increments the instruction pointer
	 * @param arg is not used
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.incIP();
	}

}
