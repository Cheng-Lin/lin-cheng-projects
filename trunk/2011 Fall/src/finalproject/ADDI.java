package finalproject;
/**
 * Class ADDI provides an implementation of the Instruction class that 
 * adds an immediate argument to the accumulator of the processor.
 * @author CS 140
 *
 */
public class ADDI extends Instruction {

	/**
	 * Constructor for the ADDI instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public ADDI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "ADD #" for this instruction
	 */
	@Override
	public String getName() {
		return "ADD #";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00010000 [(byte)16] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)16;
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
	 * The execute method for this instruction, which adds
	 * the argument to the accumulator and also increments 
	 * the instruction pointer.
	 * @arg the argument of the instruction, which is the 
	 * immediate value. 
	 */
	@Override
	public void execute(int arg) {
		proc.setAcc(arg + proc.getAcc());
		proc.incIP();
	}

}
