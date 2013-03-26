package finalproject;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class InstructionTest {
	private int[] dataCopy = new int[DataMemory.DATA_SIZE];
	private DataMemory data = new DataMemory();
	private int beginningIP;
	private int beginningAcc;
	private int programCounter = 12;
	private Processor processor = new Processor();
	private Machine machine = new Machine("Dummy Version");
	
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
	public void testADD(){
		ADD instr = new ADD(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is ADD", "ADD", instr.getName());
		assertEquals("Opcode is 00000000", (byte)0, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect add", 100+dataCopy[12], 
				processor.getAcc());
	}

	@Test
	public void testADDnegArg(){
		ADD instr = new ADD(processor, data);
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
	public void testADDargTooLarge(){
		ADD instr = new ADD(processor, data);
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
	public void testADDI(){
		ADDI instr = new ADDI(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is ADD #", "ADD #", instr.getName());
		assertEquals("Opcode is 00010000", (byte)16, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect add", 112, 
				processor.getAcc());
	}

	@Test
	public void testADDN(){
		ADDN instr = new ADDN(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is ADD &", "ADD &", instr.getName());
		assertEquals("Opcode is 00100000", (byte)32, instr.getOpCode());
		int argument = 112;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect add", 100+dataCopy[dataCopy[112]], 
				processor.getAcc());
	}

	@Test
	public void testADDNnegArg(){
		ADDN instr = new ADDN(processor, data);
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
	public void testADDNnegArg2(){
		ADDN instr = new ADDN(processor, data);
		int argument = 0;
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
	public void testADDNargTooLarge(){
		ADDN instr = new ADDN(processor, data);
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
	public void testADDNargTooLarge2(){
		ADDN instr = new ADDN(processor, data);
		int argument = 126;
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
	public void testANDBothPos(){
		AND instr = new AND(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is AND", "AND", instr.getName());
		assertEquals("Opcode is 00001000", (byte)8, instr.getOpCode());
		int argument = 200;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 1, 
				processor.getAcc());
	}

	@Test
	public void testANDAccPosMemNeg(){
		AND instr = new AND(processor, data);
		int argument = 0;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 1, 
				processor.getAcc());
	}

	@Test
	public void testANDAccNegMemPos(){
		AND instr = new AND(processor, data);
		int argument = 200;
		processor.setAcc(-100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 1, 
				processor.getAcc());
	}

	@Test
	public void testANDBothNeg(){
		AND instr = new AND(processor, data);
		int argument = 0;
		processor.setAcc(-100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 1, 
				processor.getAcc());
	}

	@Test
	public void testANDAccPosMemZero(){
		AND instr = new AND(processor, data);
		int argument = 100;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDAccNegMemZero(){
		AND instr = new AND(processor, data);
		int argument = 100;
		processor.setAcc(-100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDAccZeroMemPos(){
		AND instr = new AND(processor, data);
		int argument = 200;
		processor.setAcc(0);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDAccZeroMemNeg(){
		AND instr = new AND(processor, data);
		int argument = 0;
		processor.setAcc(0);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDBothZero(){
		AND instr = new AND(processor, data);
		int argument = 100;
		processor.setAcc(0);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDnegArg(){
		AND instr = new AND(processor, data);
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
	public void testANDargTooLarge(){
		AND instr = new AND(processor, data);
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
	public void testANDIBothPos(){
		ANDI instr = new ANDI(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is AND #", "AND #", instr.getName());
		assertEquals("Opcode is 00011000", (byte)24, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 1, 
				processor.getAcc());
	}

	@Test
	public void testANDIAccNegArgPos(){
		ANDI instr = new ANDI(processor, data);
		int argument = 12;
		processor.setAcc(-100);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 1, 
				processor.getAcc());
	}

	@Test
	public void testANDIAccPosArgNeg(){
		ANDI instr = new ANDI(processor, data);
		int argument = -12;
		processor.setAcc(100);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 1, 
				processor.getAcc());
	}

	@Test
	public void testANDIBothNeg(){
		ANDI instr = new ANDI(processor, data);
		int argument = -12;
		processor.setAcc(-100);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 1, 
				processor.getAcc());
	}

	@Test
	public void testANDIAccZeroArgPos(){
		ANDI instr = new ANDI(processor, data);
		int argument = 12;
		processor.setAcc(0);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDIAccZeroArgNeg(){
		ANDI instr = new ANDI(processor, data);
		int argument = -12;
		processor.setAcc(0);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDIAccPosArgZero(){
		ANDI instr = new ANDI(processor, data);
		int argument = 0;
		processor.setAcc(10);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDIAccNegArgZero(){
		ANDI instr = new ANDI(processor, data);
		int argument = 0;
		processor.setAcc(-10);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testANDIBothZero(){
		ANDI instr = new ANDI(processor, data);
		int argument = 0;
		processor.setAcc(0);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect and", 0, 
				processor.getAcc());
	}

	@Test
	public void testCPLMemNegative(){
		CPL instr = new CPL(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is CPL", "CPL", instr.getName());
		assertEquals("Opcode is 00001011", (byte)11, instr.getOpCode());
		int argument = 90;
		processor.setAcc(10);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should 1 since memory negative", 1, 
				processor.getAcc());
	}

	@Test
	public void testCPLMemZero(){
		CPL instr = new CPL(processor, data);
		int argument = 100;
		processor.setAcc(10);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should 0 since memory zero", 0, 
				processor.getAcc());
	}

	@Test
	public void testCPLMemPositive(){
		CPL instr = new CPL(processor, data);
		int argument = 120;
		processor.setAcc(10);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should 0 since memory zero", 0, 
				processor.getAcc());
	}

	@Test
	public void testCPLnegArg(){
		CPL instr = new CPL(processor, data);
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
	public void testCPLargTooLarge(){
		CPL instr = new CPL(processor, data);
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
	public void testCPZMemZero(){
		CPZ instr = new CPZ(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is CPZ", "CPZ", instr.getName());
		assertEquals("Opcode is 00001010", (byte)10, instr.getOpCode());
		int argument = 100;
		processor.setAcc(10);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should 1 since memory is zero", 1, 
				processor.getAcc());
	}

	@Test
	public void testCPZMemNegative(){
		CPZ instr = new CPZ(processor, data);
		int argument = 90;
		processor.setAcc(10);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should 0 since memory not zero", 0, 
				processor.getAcc());
	}

	@Test
	public void testCPZMemPositive(){
		CPZ instr = new CPZ(processor, data);
		int argument = 120;
		processor.setAcc(10);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should 0 since memory not zero", 0, 
				processor.getAcc());
	}

	@Test
	public void testCPZnegArg(){
		CPZ instr = new CPZ(processor, data);
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
	public void testCPZargTooLarge(){
		CPZ instr = new CPZ(processor, data);
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
	public void testDIV(){
		DIV instr = new DIV(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is DIV", "DIV", instr.getName());
		assertEquals("Opcode is 00000011", (byte)3, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect division", 100/dataCopy[12], 
				processor.getAcc());
	}

	@Test
	public void testDIVbyZero(){
		DIV instr = new DIV(processor, data);
		int argument = 100;
		processor.setAcc(100);
		try {
			instr.execute(argument);
			fail("Should throw DivideByZeroError");			
		} catch(DivideByZeroError ex){
			assertNotNull("An exception message is expected", 
					ex.getMessage());						
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
	}

	@Test
	public void testDIVnegArg(){
		DIV instr = new DIV(processor, data);
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
	public void testDIVargTooLarge(){
		DIV instr = new DIV(processor, data);
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
	public void testDIVI(){
		DIVI instr = new DIVI(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is DIV #", "DIV #", instr.getName());
		assertEquals("Opcode is 00010011", (byte)19, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect division", 8, 
				processor.getAcc());
	}

	@Test
	public void testDIVIbyZero(){
		DIVI instr = new DIVI(processor, data);
		int argument = 0;
		processor.setAcc(100);
		try {
			instr.execute(argument);
			fail("Should throw DivideByZeroError");			
		} catch(DivideByZeroError ex){
			assertNotNull("An exception message is expected", 
					ex.getMessage());						
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
	}

	@Test
	public void testDIVN(){
		DIVN instr = new DIVN(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is DIV &", "DIV &", instr.getName());
		assertEquals("Opcode is 00100011", (byte)35, instr.getOpCode());
		int argument = 112;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect division", 100/dataCopy[dataCopy[112]], 
				processor.getAcc());
	}

	@Test
	public void testDIVNbyZero(){
		DIVN instr = new DIVN(processor, data);
		int argument = 110;
		processor.setAcc(100);
		try {
			instr.execute(argument);
			fail("Should throw DivideByZeroError");			
		} catch(DivideByZeroError ex){
			assertNotNull("An exception message is expected", 
					ex.getMessage());						
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
	}

	@Test
	public void testDIVNnegArg(){
		DIVN instr = new DIVN(processor, data);
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
	public void testDIVNnegArg2(){
		DIVN instr = new DIVN(processor, data);
		int argument = 0;
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
	public void testDIVNargTooLarge(){
		DIVN instr = new DIVN(processor, data);
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
	public void testDIVNargTooLarge2(){
		DIVN instr = new DIVN(processor, data);
		int argument = 126;
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
	public void testHLT(){
		HLT instr = new HLT(processor, data, machine);
		assertFalse("Argument Not Required", instr.requiresArgument());
		assertEquals("Name is HLT", "HLT", instr.getName());
		assertEquals("Opcode is 00001111", (byte)15, instr.getOpCode());		
		machine.setRunning(true);
		processor.setAcc(1);
		try {
			instr.execute(0);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter not incremented", beginningIP, 
				processor.getIp());
		assertEquals("Accumulator should not change", 1, 
				processor.getAcc());
		assertFalse("Machine has stopped running", machine.isRunning());
	}

	@Test
	public void testJMP(){
		JMP instr = new JMP(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is JMP", "JMP", instr.getName());
		assertEquals("Opcode is 00001100", (byte)12, instr.getOpCode());
		int arg = 33;
		processor.setAcc(7);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter changed by jmp", 33, 
				processor.getIp());
		assertEquals("Accumulator should be unchanged", 7, 
				processor.getAcc());
	}

	@Test
	public void testJMPillegalNegTarget(){
		JMP instr = new JMP(processor, data);
		int arg = -33;
		processor.setAcc(0);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter changed by jmp", -33, 
				processor.getIp());
		assertEquals("Accumulator should be unchanged", 0, 
				processor.getAcc());
	}

	@Test
	public void testJMZaccumZero(){
		JMZ instr = new JMZ(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is JMZ", "JMZ", instr.getName());
		assertEquals("Opcode is 00001101", (byte)13, instr.getOpCode());
		int arg = 33;
		processor.setAcc(0);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter changed by jmp", 33, 
				processor.getIp());
		assertEquals("Accumulator should be unchanged", 0, 
				processor.getAcc());
	}

	@Test
	public void testJMZaccumZeroIllegalNegTarget(){
		JMZ instr = new JMZ(processor, data);
		int arg = -33;
		processor.setAcc(0);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter changed by jmp", -33, 
				processor.getIp());
		assertEquals("Accumulator should be unchanged", 0, 
				processor.getAcc());
	}

	@Test
	public void testJMZaccumPos(){
		JMZ instr = new JMZ(processor, data);
		int arg = 1000000;
		processor.setAcc(1);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should be unchanged", 1, 
				processor.getAcc());
	}

	@Test
	public void testJMZaccumNeg(){
		JMZ instr = new JMZ(processor, data);
		int arg = 1000000;
		processor.setAcc(-10);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should be unchanged", -10, 
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
		assertEquals("Program counter incremented", beginningIP+1, 
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
		assertEquals("Program counter incremented", beginningIP+1, 
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
		int argument = 112;
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect load", dataCopy[dataCopy[112]], 
				processor.getAcc());
	}

	@Test
	public void testLODNnegArg(){
		LODN instr = new LODN(processor, data);
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
	public void testLODNnegArg2(){
		LODN instr = new LODN(processor, data);
		int argument = 0;
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
	public void testLODNargTooLarge(){
		LODN instr = new LODN(processor, data);
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
	public void testLODNargTooLarge2(){
		LODN instr = new LODN(processor, data);
		int argument = 126;
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
	public void testMUL(){
		MUL instr = new MUL(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is MUL", "MUL", instr.getName());
		assertEquals("Opcode is 00000010", (byte)2, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect MUL", 100*dataCopy[12], 
				processor.getAcc());
	}

	@Test
	public void testMULnegArg(){
		MUL instr = new MUL(processor, data);
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
	public void testMULargTooLarge(){
		MUL instr = new MUL(processor, data);
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
	public void testMULI(){
		MULI instr = new MULI(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is MUL #", "MUL #", instr.getName());
		assertEquals("Opcode is 00010010", (byte)18, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect multiply", 1200, 
				processor.getAcc());
	}

	@Test
	public void testMULN(){
		MULN instr = new MULN(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is MUL &", "MUL &", instr.getName());
		assertEquals("Opcode is 00100010", (byte)34, instr.getOpCode());
		int argument = 112;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect multiply", 100*dataCopy[dataCopy[112]], 
				processor.getAcc());
	}

	@Test
	public void testMULNnegArg(){
		MULN instr = new MULN(processor, data);
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
	public void testMULNnegArg2(){
		MULN instr = new MULN(processor, data);
		int argument = 0;
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
	public void testMULNargTooLarge(){
		MULN instr = new MULN(processor, data);
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
	public void testMULNargTooLarge2(){
		MULN instr = new MULN(processor, data);
		int argument = 126;
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
	public void testNOP(){
		NOP instr = new NOP(processor, data);
		assertFalse("Argument not required", instr.requiresArgument());
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator unchanged", beginningAcc, 
				processor.getAcc());
	}

	@Test
	public void testNOTzero(){
		NOT instr = new NOT(processor, data);
		assertFalse("Argument not required", instr.requiresArgument());
		assertEquals("Name is NOT", "NOT", instr.getName());
		assertEquals("Opcode is 00001001", (byte)9, instr.getOpCode());
		//Test that "execute" impacts the machine appropriately
		processor.setAcc(0);
		try {
			instr.execute(0);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is consistent", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator now positive", 1, 
				processor.getAcc());
	}

	@Test
	public void testNOTpositive(){
		NOT instr = new NOT(processor, data);
		//Test that "execute" impacts the machine appropriately
		processor.setAcc(10);
		try {
			instr.execute(0);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is consistent", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator now zero", 0, 
				processor.getAcc());
	}

	@Test
	public void testNOTnegative(){
		NOT instr = new NOT(processor, data);
		//Test that "execute" impacts the machine appropriately
		processor.setAcc(-10);
		try {
			instr.execute(0);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is consistent", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator now zero", 0, 
				processor.getAcc());
	}

	@Test
	public void testSTO(){
		STO instr = new STO(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is STO", "STO", instr.getName());
		assertEquals("Opcode is 00000101", (byte)5, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
		try {
			instr.execute(argument);
			assertEquals("Memory should reflect store", 100, 
					data.getData(12));
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		// restore memory for check
		try {
			data.setData(12, dataCopy[12]);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");
		}
		// verify no other memory location was affected
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator not affected", 100, 
				processor.getAcc());
	}

	@Test
	public void testSTOnegArg(){
		STO instr = new STO(processor, data);
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
	public void testSTOargTooLarge(){
		STO instr = new STO(processor, data);
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
	public void testSTON(){
		STON instr = new STON(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is STO &", "STO &", instr.getName());
		assertEquals("Opcode is 00100101", 37, instr.getOpCode());
		int argument = 112;
		processor.setAcc(100);
		try {
			instr.execute(argument);
			assertEquals("Memory should reflect store", 100, 
					data.getData(data.getData(112)));
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		// restore memory for check
		try {
			data.setData(dataCopy[112],dataCopy[dataCopy[112]]);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");
		}
		// verify no other memory location was affected
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator not affected", 100, 
				processor.getAcc());
	}

	@Test
	public void testSTONnegArg(){
		STON instr = new STON(processor, data);
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
	public void testSTONnegArg2(){
		STON instr = new STON(processor, data);
		int argument = 10;
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
	public void testSTONargTooLarge(){
		STON instr = new STON(processor, data);
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
	public void testSTONargTooLarge2(){
		STON instr = new STON(processor, data);
		int argument = 130;
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
	public void testSUB(){
		SUB instr = new SUB(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is SUB", "SUB", instr.getName());
		assertEquals("Opcode is 00000001", (byte)1, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect subtraction", 
				100-dataCopy[12], processor.getAcc());
	}

	@Test
	public void testSUBnegArg(){
		SUB instr = new SUB(processor, data);
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
	public void testSUBargTooLarge(){
		SUB instr = new SUB(processor, data);
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
	public void testSUBI(){
		SUBI instr = new SUBI(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is SUB #", "SUB #", instr.getName());
		assertEquals("Opcode is 00010001", (byte)17, instr.getOpCode());
		int argument = 12;
		processor.setAcc(100);
		try {
			instr.execute(argument);
		} catch (Exception e) {
			fail("Should not throw any exceptions");
		}
		assertArrayEquals("Memory is unchanged", dataCopy, 
				data.getMemory());
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect subtraction", 88, 
				processor.getAcc());
	}

	@Test
	public void testSUBN(){
		SUBN instr = new SUBN(processor, data);
		assertTrue("Argument Required", instr.requiresArgument());
		assertEquals("Name is SUB &", "SUB &", instr.getName());
		assertEquals("Opcode is 00100001", (byte)33, instr.getOpCode());
		int argument = 112;
		processor.setAcc(100);
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
		assertEquals("Program counter incremented", beginningIP+1, 
				processor.getIp());
		assertEquals("Accumulator should reflect subtraction", 100-dataCopy[dataCopy[112]], 
				processor.getAcc());
	}

	@Test
	public void testSUBNnegArg(){
		SUBN instr = new SUBN(processor, data);
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
	public void testSUBNnegArg2(){
		SUBN instr = new SUBN(processor, data);
		int argument = 0;
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
	public void testSUBNargTooLarge(){
		SUBN instr = new SUBN(processor, data);
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
	public void testSUBNargTooLarge2(){
		SUBN instr = new SUBN(processor, data);
		int argument = 126;
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

}
