package assignment06;
public class DIV extends Instruction 
{
	public DIV(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "DIV";
	}

	@Override
	public byte getOpCode() {
		return 0b00000011;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(proc.getAcc() / data.getData(arg));
		proc.incIP();
	}
}
