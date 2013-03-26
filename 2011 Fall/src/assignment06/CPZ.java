package assignment06;
public class CPZ extends Instruction 
{
	public CPZ(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "CPZ";
	}

	@Override
	public byte getOpCode() {
		return 0b00001010;
	}

	@Override
	public void execute(int arg) throws DataAccessException 
	{
		if (data.getData(arg) == 0) {
			proc.setAcc(1);
		} else {
			proc.setAcc(0);
		}
		
		proc.setIp(arg);
	}
}
