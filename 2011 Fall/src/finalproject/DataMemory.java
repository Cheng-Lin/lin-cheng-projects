package finalproject;

public class DataMemory {
	public static int DATA_SIZE = 256;

	private class DataForm {
		int val;
		String binary;
	}
	
	private DataForm[] data = new DataForm[DATA_SIZE];

	public int getData(int location) throws DataAccessException {
		if(location < 0 || location >= DATA_SIZE) {
			throw new DataAccessException("Illegal index " + location);
		}
		int retVal = 0;
		if(data[location] != null) {
			retVal = data[location].val;
		}
		return retVal;
	}
	
	public String getDataBinary(int location) throws DataAccessException {
		if(location < 0 || location >= DATA_SIZE) {
			throw new DataAccessException("Illegal index " + location);
		}
		String retVal = "";
		if(data[location] != null) {
			retVal = data[location].binary;;
		}
		return retVal;
	}
	
	public void setData(int location, int value) throws DataAccessException {
		if(location < 0 || location >= DATA_SIZE) {
			throw new DataAccessException("illegal index " + location);
		}
		data[location] = new DataForm();
		data[location].val = value;
		String str = "00000000000000000000000000000000" +
		Integer.toBinaryString(value);
		data[location].binary = str.substring(str.length()-32);
	}
	
	public void clearData() {
		for (int i = 0; i < DATA_SIZE; i++) {
			data[i] = null;
		}
	}

	int[] getMemory() {
		int[] ints = new int[DATA_SIZE];
		for(int i = 0; i < DATA_SIZE; i++) {
			if(data[i] != null) {
				ints[i] = data[i].val;
			}
		}
		return ints;
	}
}
