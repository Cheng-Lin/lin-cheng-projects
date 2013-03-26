package assignment06;
public class MUL extends Instruction 
{
	public MUL(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "MUL";
	}

	@Override
	public byte getOpCode() {
		return 0b00000010;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(data.getData(arg) * proc.getAcc());
		proc.incIP();
	}
}
