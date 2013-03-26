package assignment06;
public class ANDI extends Instruction 
{
	public ANDI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "ANDI";
	}

	@Override
	public byte getOpCode() {
		return 0b00011000;
	}

	@Override
	public boolean isImmediate() {
		return true;
	}
	
	@Override
	public void execute(int arg) throws DataAccessException 
	{
		if (arg != 0 && proc.getAcc() != 0) {
			proc.setAcc(1);
		} else {
			proc.setAcc(0);
		}
		proc.incIP();
	}
}
