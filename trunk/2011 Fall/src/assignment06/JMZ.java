package assignment06;
public class JMZ extends Instruction 
{
	public JMZ(Processor proc, DataMemory data) {
		super(proc, data);
	}

	@Override
	public String getName() {
		return "JMZ";
	}

	@Override
	public byte getOpCode() {
		return 0b00001101;
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		if (proc.getAcc() == 0) {
			proc.setIp(arg);
		} else {
			proc.incIP();
		}
	}
}
