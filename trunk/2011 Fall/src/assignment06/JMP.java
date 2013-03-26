package assignment06;
public class JMP extends Instruction 
{
	public JMP(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "JMP";
	}

	@Override
	public byte getOpCode() {
		return 0b00001100;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		proc.setIp(arg);
	}
}
