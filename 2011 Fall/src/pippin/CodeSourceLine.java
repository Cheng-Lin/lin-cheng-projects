package pippin;

import java.util.HashMap;
import java.util.Map;

public class CodeSourceLine {
	public static Map<String, Integer> INSTR_NUM_ARGS = new HashMap<String, Integer>();
	static {
		INSTR_NUM_ARGS.put("ADD", 1);
		INSTR_NUM_ARGS.put("AND", 1);
		INSTR_NUM_ARGS.put("CPL", 1);
		INSTR_NUM_ARGS.put("CPZ", 1);
		INSTR_NUM_ARGS.put("DIV", 1);
		INSTR_NUM_ARGS.put("HLT", 0);
		INSTR_NUM_ARGS.put("JMP", 1);
		INSTR_NUM_ARGS.put("JMZ", 1);
		INSTR_NUM_ARGS.put("LOD", 1);
		INSTR_NUM_ARGS.put("MUL", 1);
		INSTR_NUM_ARGS.put("NOP", 0);
		INSTR_NUM_ARGS.put("NOT", 0);
		INSTR_NUM_ARGS.put("STO", 1);
		INSTR_NUM_ARGS.put("SUB", 1);
	}
	private String instName;
	private int arg;
	private int sourceLnNum;
	private String sourceLine;
		
	public CodeSourceLine(String instName, int arg,
			int sourceLnNum, String sourceLine) {
		this.instName = instName;
		this.arg = arg;
		this.sourceLnNum = sourceLnNum;
		this.sourceLine = sourceLine;
	}

	public String getSourceLine() {
		return sourceLine;
	}

	public String getInstName() {
		return instName;
	}

	public int getArg() {
		return arg;
	}

	public int getSourceLnNum() {
		return sourceLnNum;
	}

	@Override
	public String toString() {
		return "CodeSourceLine [instName=" + instName + ", arg=" + arg
				+ ", sourceLnNum=" + sourceLnNum + ", sourceLine=" + sourceLine
				+ "]";
	}


}
