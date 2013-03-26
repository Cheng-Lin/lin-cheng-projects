package pippin;

public class DataMemory {
	public static int DATA_SIZE = 256;

	private int[] data = new int[DATA_SIZE];

	public int getData(int location) throws DataAccessException {
		if(location < 0 || location >= DATA_SIZE) {
			throw new DataAccessException("Illegal index " + location);
		}
		return data[location];
	}
	
	public void setData(int location, int value) throws DataAccessException {
		if(location < 0 || location >= DATA_SIZE) {
			throw new DataAccessException("illegal index " + location);
		}
		data[location] = value;
	}
	
	public int[] getMemory() {
		return data;
	}
	
    public void clear() {
        for (int i = 0; i < DATA_SIZE; i++) {
            data[i] = -1; // using 0 can be confused with ADD
        }
    }
}
