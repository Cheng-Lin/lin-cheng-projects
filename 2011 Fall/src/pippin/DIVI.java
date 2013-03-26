package pippin;
/**
 * Class DIVI provides an implementation of the Instruction class that 
 * divides the accumulator of the processor by an immediate argument.
 * @author CS 140
 */
public class DIVI extends Instruction {

	/**
	 * Constructor for the DIVI instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public DIVI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "DIV #" for this instruction
	 */
	@Override
	public String getName() {
		return "DIV #";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00010011 [(byte)19] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)19;
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
	 * The execute method for this instruction, which divides
	 * accumulator by the argument and also increments 
	 * the instruction pointer.
	 * @arg the argument of the instruction, which is the 
	 * immediate value. 
	 * @throws DivideByZeroError if arg is 0. This is an
	 * unchecked exception
	 */
	@Override
	public void execute(int arg) throws DataAccessException, DivideByZeroError {
		proc.setAcc(proc.getAcc() / arg);
		proc.incIP();
	}

}
