package finalproject;
/**
 * Class JMPN implements a jump instruction using 
 * indirect addressing, which moves this instruction pointer 
 * to the location given by the value in memory given by the
 * argument.
 * @author CS 140
 */
public class JMPN extends Instruction {

	/**
	 * Constructor for the JMPN instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public JMPN(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "JMP &" for this instruction
	 */
	@Override
	public String getName() {
		return "JMP &";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00101100 [(byte)44] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)44;
	}

	/**
	 * The execute method for this instruction, move the 
	 * instruction pointer to the value determined by the
	 * argument: the target for the jump is the value in
	 * memory at the location given by the argument
	 * @param arg the target location of the next instruction
	 * @throws DataAccessException if the arg location is out
	 * of the bounds of data memory 
	 */
	@Override
	public void execute(int arg) throws DataAccessException {
		int target = data.getData(arg);
		proc.setIp(target);
	}
}
