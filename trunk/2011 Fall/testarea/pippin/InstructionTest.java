package pippin;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InstructionTest {
	private int[] dataCopy = new int[DataMemory.DATA_SIZE];
	private DataMemory data = new DataMemory();
	private int beginningIP;
	private int beginningAcc;
	private int programCounter = 12;
	private Processor processor = new Processor();

	@Before
	public void setUp() throws Exception {
		for(int i = 0; i < DataMemory.DATA_SIZE; i++) {
			data.setData(i, -1000 + 10*i);
			dataCopy[i] = -1000 + 10*i; 
		}
		beginningIP = programCounter;
		processor.setIp(programCounter);
		beginningAcc = 14;
		processor.setAcc(14);		
	}	
	
	@Test
	public void testNOP(){
		NOP instr = new NOP(processor, data);
		assertFalse("Argument Required", instr.requiresArgument());
		assertEquals("Name is NOP", "NOP", instr.getName());
		assertEquals("Opcode is 00001110", (byte)14, instr.getOpCode());
		//Test that "execute" impacts the machine appropriately
		try {
			instr.execute(0);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is consistent", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incemented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator unchanged", beginningAcc, 
				processor.getAcc());
	}

	@Test
	public void testLOD(){
		LOD instr = new LOD(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is LOD", "LOD", instr.getName());
		assertEquals("Opcode is 00000100", (byte)4, instr.getOpCode());
		int argument = 12;
		try {
			instr.execute(argument);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incemented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect load", dataCopy[12], 
				processor.getAcc());
	}

	@Test
	public void testLODnegArg(){
		LOD instr = new LOD(processor, data);
		int argument = -1;
		try {
			instr.execute(argument);
			fail("DataAccessException not thrown");
		} catch (DataAccessException ex) {
			assertNotNull("An exception message is expected", 
					ex.getMessage());			
		} catch (Exception e) {
			fail("Should not throw any other exceptions: " + 
					e.getClass().getSimpleName());
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
	}

	@Test
	public void testLODargTooLarge(){
		LOD instr = new LOD(processor, data);
		int argument = DataMemory.DATA_SIZE;
		try {
			instr.execute(argument);
			fail("DataAccessException not thrown");
		} catch (DataAccessException ex) {
			assertNotNull("An exception message is expected", 
					ex.getMessage());			
		} catch (Exception e) {
			fail("Should not throw any other exceptions: " + 
					e.getClass().getSimpleName());
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
	}

	@Test
	public void testLODI(){
		LODI instr = new LODI(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is LOD #", "LOD #", instr.getName());
		assertEquals("Opcode is 00010100", (byte)20, instr.getOpCode());
		int argument = 12;
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incemented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect load", 12, 
				processor.getAcc());
	}
	
	@Test
	public void testLODN(){
		LODN instr = new LODN(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is LOD &", "LOD &", instr.getName());
		assertEquals("Opcode is 00100100", (byte)36, instr.getOpCode());
		int argument = 120;
		try {
			instr.execute(argument);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incemented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect load", dataCopy[dataCopy[120]], 
				processor.getAcc());
	}
}
