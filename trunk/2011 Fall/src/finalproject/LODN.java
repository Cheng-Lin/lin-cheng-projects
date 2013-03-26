package finalproject;
/**
 * Class LODN provides an implementation of the load
 * instruction, which loads an argument into the 
 * accumulator using indirect addressing. 
 * @author CS 140
 */
public class LODN extends Instruction {

	/**
	 * Constructor for the LODN instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public LODN(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "LOD &" for this instruction
	 */
	@Override
	public String getName() {
		return "LOD &";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00100100 [(byte)36] for this instruction
	 */
	@Override
    public byte getOpCode() {
        return (byte)36;
    }

	/**
	 * The execute method for this instruction, which copies
	 * the contents of memory to the accumulator and also
	 * increments the instruction pointer. The specific memory
	 * element uses "arg" as the indirect argument (the value
	 * at this memory location is the address of the actual 
	 * value to be loaded)
	 * @arg the argument of the instruction, which is a
	 * location in the data memory containing the location of the
	 * value to be loaded.
	 * @throws DataAccessException if arg is an illegal location
	 * in data memory or if the value at the location "arg" is
	 * an illegal location in data memory.
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		int arg1 = data.getData(arg);
		proc.setAcc(data.getData(arg1));
		proc.incIP();
	}

}
