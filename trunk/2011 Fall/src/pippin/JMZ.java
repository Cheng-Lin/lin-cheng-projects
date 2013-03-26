package pippin;
/**
 * Class JMZ implements a conditions jump instruction, 
 * which moves this instruction pointer to the location 
 * given by the argument provided the accumulator is zero.
 * @author CS 140
 */
public class JMZ extends Instruction {

	/**
	 * Constructor for the JMZ instruction
	 * @param proc reference to the processor
	 * @param data reference to the data memory
	 */
	public JMZ(Processor proc, DataMemory data) {
		super(proc, data);
	}

	/**
	 * Method that gives the name of this instruction
	 * @return the mnemonic "JMZ" for this instruction
	 */
	@Override
	public String getName() {
		return "JMZ";
	}

	/**
	 * Method that gives the opcode of this instruction
	 * @return the byte 00001101 [(byte)13] for this instruction
	 */
	@Override
	public byte getOpCode() {
		return (byte)13;
	}

	/**
	 * The execute method for this instruction, move the 
	 * instruction pointer to the value determined by the
	 * argument if the accumulator is 0.
	 * @param arg the target location of the next instruction
	 */
	@Override
	public void execute(int arg) {
		if (proc.getAcc() == 0) {
			proc.setIp(arg);
		} else {
			proc.incIP();
		}
	}

}
