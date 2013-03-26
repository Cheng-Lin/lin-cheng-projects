package assignment06;
public class MULI extends Instruction 
{
	public MULI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "MULI";
	}

	@Override
	public byte getOpCode() {
		return 0b00010010;
	}

	@Override
	public boolean isImmediate() {
		return true;
	}
	
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(arg * proc.getAcc());
		proc.incIP();
	}
}
