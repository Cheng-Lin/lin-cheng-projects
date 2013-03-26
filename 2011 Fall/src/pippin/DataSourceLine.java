package pippin;

import java.util.Arrays;

public class DataSourceLine {
	private String sourceLine;
	private int[] data = new int[2];
	private int sourceLnNum;
	
	public DataSourceLine(int location, int value, int sourceLnNum, String sourceLine) {
		data[0] = location;
		data[1] = value;
		this.sourceLnNum = sourceLnNum;
		this.sourceLine = sourceLine;
	}
	
	public int[] getData() {
		return data;
	}
	
	public int getSourceLnNum() {
		return sourceLnNum;
	}

	public String getSourceLine() {
		return sourceLine;
	}

	@Override
	public String toString() {
		return "DataSourceLine [sourceLine=" + sourceLine + ", data="
				+ Arrays.toString(data) + ", sourceLnNum=" + sourceLnNum + "]";
	}

}
