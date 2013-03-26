package pippin;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;

public class CodeUtilities {
	private static String[] instrNames = {"ADD",
		"ADDI","ADDN","AND","ANDI","CPL",
		"CPZ","DIV","DIVI","DIVN","HLT",
		"JMP","JMZ","LOD","LODI","LODN",
		"MUL","MULI","MULN","NOP","NOT",
		"STO","STON","SUB","SUBI","SUBN"};
	private static Map<String,String> binaries =
		new TreeMap<String,String>();
	static {
		for(String name: instrNames)
		{
			try {
				Class<?> cls = Class.forName("pippin." + name);
				Class<? extends Instruction> instrCls = cls.asSubclass(Instruction.class);
				Constructor<? extends Instruction> constr = instrCls.getConstructor(Processor.class, DataMemory.class);
				Instruction instr = constr.newInstance(null, null);
				String opStr = Integer.toBinaryString(instr.getOpCode());
				if(name.endsWith("I")){
					name = name.substring(0, 3) + " #";
				} else if (name.endsWith("N")) {
					name = name.substring(0,3) + " &";			
				}
				opStr = "00000000" + opStr;
				opStr = opStr.substring(opStr.length() - 8);
				binaries.put(name, opStr);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	public static String getInstrBinary(Instruction instr) {		
		return binaries.get(instr.getName());
	}

	public static String getArgBinary(int arg) {
		String str = "00000000000000000000000000000000" + Integer.toBinaryString(arg);
		return str.substring(str.length() - 32);
	}

	public static void main(String[] args) {
		System.out.println(binaries);
		System.out.println("ADD:\t" + getInstrBinary(new ADD(null,null))); 
		System.out.println("ADDI:\t" + getInstrBinary(new ADDI(null,null))); 
		System.out.println("ADDN:\t" + getInstrBinary(new ADDN(null,null))); 
		System.out.println("AND:\t" + getInstrBinary(new AND(null,null))); 
		System.out.println("ANDI:\t" + getInstrBinary(new ANDI(null,null))); 
		System.out.println("CPL:\t" + getInstrBinary(new CPL(null,null))); 
		System.out.println("CPZ:\t" + getInstrBinary(new CPZ(null,null))); 
		System.out.println("DIV:\t" + getInstrBinary(new DIV(null,null))); 
		System.out.println("DIVI:\t" + getInstrBinary(new DIVI(null,null))); 
		System.out.println("DIVN:\t" + getInstrBinary(new DIVN(null,null))); 
		System.out.println("HLT:\t" + getInstrBinary(new HLT(null,null))); 
		System.out.println("JMP:\t" + getInstrBinary(new JMP(null,null))); 
		System.out.println("JMZ:\t" + getInstrBinary(new JMZ(null,null))); 
		System.out.println("LOD:\t" + getInstrBinary(new LOD(null,null))); 
		System.out.println("LODI:\t" + getInstrBinary(new LODI(null,null))); 
		System.out.println("LODN:\t" + getInstrBinary(new LODN(null,null))); 
		System.out.println("MUL:\t" + getInstrBinary(new MUL(null,null))); 
		System.out.println("MULI:\t" + getInstrBinary(new MULI(null,null))); 
		System.out.println("MULN:\t" + getInstrBinary(new MULN(null,null))); 
		System.out.println("NOP:\t" + getInstrBinary(new NOP(null,null))); 
		System.out.println("NOT:\t" + getInstrBinary(new NOT(null,null))); 
		System.out.println("STO:\t" + getInstrBinary(new STO(null,null))); 
		System.out.println("STON:\t" + getInstrBinary(new STON(null,null))); 
		System.out.println("SUB:\t" + getInstrBinary(new SUB(null,null))); 
		System.out.println("SUBI:\t" + getInstrBinary(new SUBI(null,null))); 
		System.out.println("SUBN:\t" + getInstrBinary(new SUBN(null,null))); 
	}
}
