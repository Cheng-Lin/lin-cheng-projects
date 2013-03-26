package assignment06;
public class SUBI extends Instruction 
{
	public SUBI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "SUBI";
	}

	@Override
	public byte getOpCode() {
		return 0b00010001;
	}

	@Override
	public boolean isImmediate() {
		return true;
	}
	
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(proc.getAcc() - arg);
		proc.incIP();
	}
}
