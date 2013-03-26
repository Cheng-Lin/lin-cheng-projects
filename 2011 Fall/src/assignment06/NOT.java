package assignment06;
public class NOT extends Instruction 
{
	public NOT(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "NOT";
	}

	@Override
	public byte getOpCode() {
		return 0b00001001;
	}
	
	@Override
	public boolean requiresArgument() {
		return false;
	}

	@Override
	public void execute(int arg) throws DataAccessException 
	{
		if (proc.getAcc() == 0) {
			proc.setAcc(1);
		} else {
			proc.setAcc(0);
		}
		
		proc.incIP();
	}
}
