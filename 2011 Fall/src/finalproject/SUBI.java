package finalproject;
/**
 * Class SUBI provides an implementation of the Instruction class that 
 * subtracts an immediate argument from the accumulator of the processor.
 * @author CS 140
 */
public class SUBI extends Instruction {

	/**
	 * Constructor for the SUBI instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public SUBI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "SUB #" for this instruction
	 */
	@Override
	public String getName() {
		return "SUB #";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00010001 [(byte)17] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)17;
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
	 * The execute method for this instruction, which subtracts
	 * the argument from the accumulator and also increments 
	 * the instruction pointer.
	 * @arg the argument of the instruction, which is the 
	 * immediate value. 
	 */
	@Override
	public void execute(int arg) {
		proc.setAcc(proc.getAcc() - arg);
		proc.incIP();
	}

}
