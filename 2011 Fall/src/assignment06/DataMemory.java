package assignment06;
public class DataMemory 
{
	public static final int DATA_SIZE = 256;
	private int data[] = new int[DATA_SIZE];
	
	public int getData(int location) throws DataAccessException
	{
		return data[location];
	}
	
	public void setData(int location, int data) throws DataAccessException
	{
		this.data[location] = data;
	}
}
