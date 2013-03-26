package finalproject;
/**
 * Class MULI provides an implementation of the Instruction class that 
 * multiplies the accumulator of the processor by an immediate argument.
 * @author CS 140
 *
 */
public class MULI extends Instruction {

	/**
	 * Constructor for the MULI instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public MULI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "MUL #" for this instruction
	 */
	@Override
	public String getName() {
		return "MUL #";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00010010 [(byte)18] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)18;
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
	 * The execute method for this instruction, which multiplies
	 * accumulator by the argument and also increments 
	 * the instruction pointer.
	 * @arg the argument of the instruction, which is the 
	 * immediate value. 
	 */
	@Override
	public void execute(int arg) {
		proc.setAcc(arg * proc.getAcc());
		proc.incIP();
	}

}
