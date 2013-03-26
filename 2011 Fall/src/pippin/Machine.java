package pippin;

import java.io.*;
import java.util.*;

public class Machine extends Observable {

	private Processor proc = new Processor();
	private CodeMemory code = new CodeMemory();
	private DataMemory data = new DataMemory();
	private boolean running = false;
	private Map<Byte,Instruction> instructionSet = 
			new HashMap<Byte,Instruction>();

	public Machine() {
		Instruction instr = new ADD(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new ADDI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new ADDN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new AND(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new ANDI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new CPL(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new CPZ(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new DIV(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new DIVI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new DIVN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new HLT(proc, data, this);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new JMP(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new JMZ(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new LOD(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new LODI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new LODN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new MUL(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new MULI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new MULN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new NOP(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new NOT(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new STO(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new STON(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new SUB(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new SUBI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new SUBN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
	}

	public void startExecution(File f) throws NumberFormatException, 
	FileNotFoundException, CodeAccessException, 
	DataAccessException, IllegalBinaryFormatException {
		code.clear();
		data.clear();
		Loader.load(code, data, f);
		proc.setAcc(0);
		proc.setIp(0);
		running = true;
	}

	public void setRunning(boolean b) {
		running = b;
	}

	public void step() throws CodeAccessException, DataAccessException {
		// GET THE BYTE CODE AT LOCATION processor IP value in CodeMemory
		byte byteCode = code.getInstruction(proc.getIp());
		// GET THE ARGUMENT FOR THE SAME INSTRUCTION
		int arg = code.getArgument(proc.getIp());
		// USE THE instructionSet Map TO GET THE INSTRUCTION FROM THE BYTE CODE
		Instruction instr = instructionSet.get(byteCode);
		// USE System.out.print TO PRINT THE NAME OF THIS INSTRUCTIONS AND THE ARGUMENT
		System.out.print(instr.getName() + " " + arg);
		// CALL instr.execute(arg);
		instr.execute(arg);
	}

	/**
	 * @param args
	 * @throws IllegalBinaryFormat 
	 * @throws DataAccessException 
	 * @throws CodeAccessException 
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, FileNotFoundException, CodeAccessException, DataAccessException, IllegalBinaryFormatException {
		System.out.println("Start");
		Machine machine = new Machine();
		// THE FILE pippin.pxe IS THE ONE IN QUESTION 3 OF ASSIGNMENT 9
		machine.startExecution(new File("pippin.pxe"));
		while(machine.running) {
			machine.step();
			System.out.println(Arrays.toString(machine.data.getMemory()));
			System.out.println(machine.proc.getIp() + " " + machine.proc.getAcc());
		}
	}
}
