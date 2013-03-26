package pippin;
public abstract class Instruction {
    protected Processor proc;
    protected DataMemory data;

    public Instruction(Processor proc, DataMemory data) {
		this.proc = proc;
		this.data = data;
	}

	/**
     * Method to return the name of this instruction, e.g. "NOP" or
     * "ADD"
     * @return the name of the instruction
     */
    public abstract String getName();
   
    /**
     * Method to return the numeric opcode of this instruction
     * e.g. for LOD it is 0b00000100
     * @return the opcode of this instruction
     */
    public abstract byte getOpCode();

    /**
     * Method to indicate if this is an immediate instruction,
     * e.g. "ADDI"
     * @return true if the instruction is immediate otherwise false
     */
    public boolean isImmediate() {
        return false; // ONLY override this
        // method for the classes that return true
    }
    /**
     * Method to indicate if this is instruction requires an argument,
     * only NOP, NOT, HLT do not
     * @return true if the instruction is requires an argument
     * otherwise false
     */
    public boolean requiresArgument() {
        return true; // ONLY override this
        // method for the classes that return false
    }

    /**
     * Method to execute this instruction for the given argument.
     * The details are explained in list of instructions for this
     * version of the Pippin computer.
     * NOTE: If the instruction does not use an argument, then the
     * argument is passed as 0
     *
     * @param arg the argument for this instruction
     * @throws DataAccessException if access to the data of the
     * program causes an exception
     */
    public abstract void execute(int arg) throws DataAccessException;
}