package pippin;

public class CodeMemory {
	public static int CODE_SIZE = 256;

	private long[] code = new long[CODE_SIZE];

	public CodeMemory() {
		for(int i = 0; i < CODE_SIZE; i++) {
			code[i] = -1; // 0 can be confused with ADD 0
		}
	}

	public byte getInstruction(int location) throws CodeAccessException {
		if(location < 0 || location >= CODE_SIZE) {
			throw new CodeAccessException("Illegal index " + location);
		}
		return (byte)((code[location] >> 32)%256);
	}
	
    public int getArgument(int location) throws CodeAccessException {
        if(location < 0 || location >= CODE_SIZE) {
            throw new CodeAccessException("Illegal index " + location);
        }
        return (int)(code[location]%(Integer.MAX_VALUE + 1L));
    }
    
    public void clear() {
        for (int i = 0; i < CODE_SIZE; i++) {
            code[i] = -1; // using 0 can be confused with ADD
        }
    }

	public void setInstruction(int location, long value) throws CodeAccessException {
		if(location < 0 || location >= CODE_SIZE) {
			throw new CodeAccessException("illegal index " + location);
		}
		code[location] = value;
	}
}
