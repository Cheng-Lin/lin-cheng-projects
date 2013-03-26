package pippin;
/**
 * Class JMP implements a jump instruction, which moves
 * this instruction pointer to the location given
 * by the argument.
 * @author CS 140
 */
public class JMP extends Instruction {

	/**
	 * Constructor for the JMP instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public JMP(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "JMP" for this instruction
	 */
	@Override
	public String getName() {
		return "JMP";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00001100 [(byte)12] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)12;
	}

	/**
	 * The execute method for this instruction, move the 
	 * instruction pointer to the value determined by the
	 * argument
	 * @param arg the target location of the next instruction
	 */
	@Override
	public void execute(int arg) {
		proc.setIp(arg);
	}
}
