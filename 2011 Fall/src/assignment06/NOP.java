package assignment06;
public class NOP extends Instruction 
{
	public NOP(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "NOP";
	}

	@Override
	public byte getOpCode() {
		return 0b00001110;
	}
	
	@Override
	public boolean requiresArgument() {
		return false;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		proc.incIP();
	}
}
