package assignment06;
public class ADD extends Instruction 
{
	public ADD(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "ADD";
	}

	@Override
	public byte getOpCode() {
		return 0b00000000;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(data.getData(arg) + proc.getAcc());
		proc.incIP();
	}
}
