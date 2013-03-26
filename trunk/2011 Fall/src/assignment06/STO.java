package assignment06;
public class STO extends Instruction 
{
	public STO(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "STO";
	}

	@Override
	public byte getOpCode() {
		return 0b00000101;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		data.setData(arg, proc.getAcc());
		proc.incIP();
	}
}
