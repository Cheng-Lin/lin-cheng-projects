package finalproject;
/**
 * Class DIVN provides an implementation of the Instruction class that 
 * divides the accumulator of the processor by an argument, using 
 * indirect addressing.
 * @author CS 140
 */
public class DIVN extends Instruction {

	/**
	 * Constructor for the DIVN instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public DIVN(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "DIV &" for this instruction
	 */
	@Override
	public String getName() {
		return "DIV &";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00100011 [(byte)35] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)35;
	}

	/**
	 * The execute method for this instruction, which divides
	 * the accumulator by the contents of memory and also
	 * increments the instruction pointer. The specific memory
	 * element uses "arg" as the indirect argument (the value
	 * at this memory location is the address of the actual 
	 * value to be divided)
	 * @arg the argument of the instruction, which is a
	 * location in the data memory containing the location of the
	 * value to be used.
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory or if the value at the location "arg" is
	 * an illegal location in data memory.
	 * @throws DivideByZeroError if the divisor is 0. This is an
	 * unchecked exception
	 */
	@Override
	public void execute(int arg) throws DataAccessException, DivideByZeroError {
		try{
			int arg1 = data.getData(arg);
			proc.setAcc(proc.getAcc() / data.getData(arg1));
			proc.incIP();
		} catch(ArithmeticException e){
			throw new DivideByZeroError("Cannot divide by zero.");
		}
	}

}
