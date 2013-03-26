package finalproject;
/**
 * Class DIV provides an implementation of the Instruction class that 
 * divides the accumulator of the processor by an argument, using 
 * direct addressing.
 * @author CS 140
 */
public class DIV extends Instruction {

	/**
	 * Constructor for the DIV instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public DIV(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "DIV" for this instruction
	 */
	@Override
	public String getName() {
		return "DIV";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00000011 [(byte)3] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)3;
	}

	/**
	 * The execute method for this instruction, which divides
	 * the accumulator by the contents of memory at index "arg"
	 * and also increments the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory.
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory
	 * @throws DivideByZeroError if the divisor is 0. This is an
	 * unchecked exception
	 */
	@Override
	public void execute(int arg) throws DataAccessException, DivideByZeroError {
		try {
			proc.setAcc(proc.getAcc() / data.getData(arg));
			proc.incIP();
		} catch(ArithmeticException e){
			throw new DivideByZeroError("Cannot divide by zero.");
		}
	}

}
