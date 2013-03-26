package assignment06;
public class ADDI extends Instruction 
{
	public ADDI(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "ADDI";
	}

	@Override
	public byte getOpCode() {
		return 0b00010000;
	}

	@Override
	public boolean isImmediate() {
		return true;
	}
	
	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(arg + proc.getAcc());
		proc.incIP();
	}
}
