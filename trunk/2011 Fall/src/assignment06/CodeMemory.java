package assignment06;
public class CodeMemory 
{
	public static final int CODE_MAX = 256;
	private int instruction[] = new int[CODE_MAX];

	public int getInstruction(int location) throws CodeAccessException
	{
		return instruction[location];
	}

	public void setInstruction(int location, int instruction) throws CodeAccessException
	{
		this.instruction[location] = instruction;
	}
}
