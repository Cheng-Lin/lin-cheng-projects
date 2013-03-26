package assignment06;
public class LOD extends Instruction 
{
	public LOD(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "LOD";
	}

	@Override
	public byte getOpCode() {
		return 0b00000100;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setAcc(data.getData(arg));
		proc.incIP();
	}
}
