package finalproject;
/**
 * Class LODI provides an implementation of the load
 * instruction, which loads an immediate argument into 
 * the accumulator. 
 * @author CS 140
 */
public class LODI extends Instruction {

	/**
	 * Constructor for the LODI instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public LODI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "LOD #" for this instruction
	 */
	@Override
	public String getName() {
		return "LOD #";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00010100 [(byte)20] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)20;
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
	 * The execute method for this instruction, which copies
	 * the argument "arg" to the accumulator and also 
	 * increments the instruction pointer.
	 * @arg the argument of the instruction, which is an
	 * immediate value. 
	 */
	@Override
	public void execute(int arg) {
		proc.setAcc(arg);
		proc.incIP();
	}
}
