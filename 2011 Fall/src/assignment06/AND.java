package assignment06;
public class AND extends Instruction 
{
	public AND(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "AND";
	}

	@Override
	public byte getOpCode() {
		return 0b00001000;
	}

	@Override
	public void execute(int arg) throws DataAccessException 
	{
		if (data.getData(arg) != 0 && proc.getAcc() != 0) {
			proc.setAcc(1);
		} else {
			proc.setAcc(0);
		}
		proc.incIP();
	}
}
