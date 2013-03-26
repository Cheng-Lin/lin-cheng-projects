package assignment06;
public class HLT extends Instruction 
{
	public HLT(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "HLT";
	}

	@Override
	public byte getOpCode() {
		return 0b00001111;
	}
	
	@Override
	public boolean requiresArgument() {
		return false;
	}

	@Override
	public void execute(int arg) throws DataAccessException {}
}
