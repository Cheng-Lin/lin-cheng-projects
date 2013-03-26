
package assignment06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PippinTests {
    private Instruction instr;
    private DataMemory dataMem;
    private Processor processor;

    @Before
    public void setUp() throws Exception {
        dataMem = new DataMemory();
        for(int i = 0; i < DataMemory.DATA_SIZE; i++) {
            dataMem.setData(i, 10*i-100);
        }
        processor = new Processor();
    }

    @Test
    public void testLOD() throws DataAccessException {
    	instr = new LOD(processor, dataMem);
    	assertEquals("Test that the name is correct", "LOD", instr.getName());
        assertEquals("Test that the opcode is correct", 0b00000100, instr.getOpCode());
        processor.setAcc(55);
        instr.execute(20); // should add 10*20-100 to acc
        assertEquals("Test 100 was added to accumulator", 100, processor.getAcc());
    }
    
    @Test
    public void testSTO() throws DataAccessException {
    	instr = new STO(processor, dataMem);
    	assertEquals("Test that the name is correct", "STO", instr.getName());
        assertEquals("Test that the opcode is correct", 0b00000101, instr.getOpCode());
        processor.setAcc(55);
        instr.execute(20); // should add 10*20-100 to acc
        assertEquals("Test 100 was added to accumulator", 55, dataMem.getData(20));
    }
    
    @Test
    public void testADD() throws DataAccessException {
        instr = new ADD(processor, dataMem);
        assertEquals("Test that the name is correct", "ADD", instr.getName());
        assertEquals("Test that the opcode is correct", (byte)0, instr.getOpCode());
        processor.setAcc(55);
        instr.execute(20); // should add 10*20-100 to acc
        assertEquals("Test 100 was added to accumulator", 155, processor.getAcc());
    }
    
    @Test
    public void testADDI() throws DataAccessException {
        instr = new ADDI(processor, dataMem);
        assertEquals("Test that the name is correct", "ADDI", instr.getName());
        assertEquals("Test that the opcode is correct", (byte)16, instr.getOpCode());
        assertEquals("Test that the isImmediate returns true", true, instr.isImmediate());
        processor.setAcc(55);
        instr.execute(20); // should add 10*20-100 to acc
        assertEquals("Test 100 was added to accumulator", 75, processor.getAcc());
    }
    
    @Test
    public void testJMP() throws DataAccessException {
        instr = new JMP(processor, dataMem);
        assertEquals("Test that the name is correct", "JMP", instr.getName());
        assertEquals("Test that the opcode is correct", (byte)12, instr.getOpCode());
        instr.execute(20); // should add 10*20-100 to acc
        assertEquals("Test 100 was added to accumulator", 20, processor.getIp());
    }
    
    @Test
    public void testCPZ() throws DataAccessException {
        instr = new CPZ(processor, dataMem);
        assertEquals("Test that the name is correct", "CPZ", instr.getName());
        assertEquals("Test that the opcode is correct", (byte)10, instr.getOpCode());
        processor.setAcc(55);
        instr.execute(20); // should add 10*20-100 to acc
        assertEquals("Test 100 was added to accumulator", 0, processor.getAcc());
    }
}