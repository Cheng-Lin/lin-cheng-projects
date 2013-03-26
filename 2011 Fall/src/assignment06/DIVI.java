package assignment06;
public class DIVI extends Instruction 
{
	public DIVI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "DIVI";
	}

	@Override
	public byte getOpCode() {
		return 0b00010011;
	}

	@Override
	public boolean isImmediate() {
		return true;
	}
	
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(proc.getAcc() / arg);
		proc.incIP();
	}
}
