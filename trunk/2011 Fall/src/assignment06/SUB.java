package assignment06;
public class SUB extends Instruction 
{
	public SUB(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "SUB";
	}

	@Override
	public byte getOpCode() {
		return 0b00000001;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(proc.getAcc() - data.getData(arg));
		proc.incIP();
	}
}
