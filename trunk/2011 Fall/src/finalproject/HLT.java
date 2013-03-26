package finalproject;
/**
 * Class HLT provides an implementation of the Instruction class that 
 * that halts execution of a program.
 * @author CS 140
 */
public class HLT extends Instruction {
	private Machine machine;
	/**
	 * Constructor for the HLT instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public HLT(Processor proc, DataMemory data) {
		super(proc, data);
	}
	 /**
     * Constructor for the HLT instruction
     * @param proc reference to the processor
     * @param data reference to the data memory
     * @param machine reference to the machine executing this instruction
     */
    public HLT(Processor proc, DataMemory data, Machine machine) {
        super(proc, data);
        this.machine = machine;
    }
	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "HLT" for this instruction
	 */
	@Override
	public String getName() {
		return "HLT";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00001111 [(byte)15] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)15;
	}

	/**
	 * Predicate indicating that this instruction does not take
	 * an argument
	 * @return false, the instruction does not take an argument
	 */
	@Override
    public boolean requiresArgument() {
        return false;
    }

	/**
	 * The instruction halts the execution of the program simulation
	 * @param arg is not used
	 */
	@Override
    public void execute(int arg) {
        machine.setRunning(false);
    }
}
