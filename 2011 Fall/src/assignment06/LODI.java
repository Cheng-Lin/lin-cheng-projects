package assignment06;
public class LODI extends Instruction 
{
	public LODI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "LODI";
	}

	@Override
	public byte getOpCode() {
		return 0b00010100;
	}

	@Override
	public boolean isImmediate() {
		return true;
	}
	
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(arg);
		proc.incIP();
	}
}
