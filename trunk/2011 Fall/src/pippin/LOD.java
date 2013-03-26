package pippin;
/**
 * Class LOD provides an implementation of the load
 * instruction, which loads an argument into the 
 * accumulator using direct addressing. 
 * @author CS 140
 */
public class LOD extends Instruction {

	/**
	 * Constructor for the LOD instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public LOD(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "LOD" for this instruction
	 */
	@Override
	public String getName() {
		return "LOD";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00000100 [(byte)4] for this instruction
	 */
	@Override
    public byte getOpCode() {
        return (byte)4;
    }

	/**
	 * The execute method for this instruction, which copies
	 * the contents of memory at index "arg" to the accumulator
	 * and also increments the instruction pointer.
	 * @arg the argument of the instruction, which is a
	 * location in the data memory. 
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(data.getData(arg));
		proc.incIP();
	}

}
