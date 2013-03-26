package assignment08;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Before;
import org.junit.Test;

public class TestBubbleSort2 
{
	private Measurable[] array;
	private Measurable[] expectedArray;
	
	@Before
	public void setUp() throws Exception 
	{
		array = new Measured[10];
		expectedArray = new Measured[10];
		
		array[0] = new Measured(80);
		array[1] = new Measured(50);
		array[2] = new Measured(70);
		array[3] = new Measured(30);
		array[4] = new Measured(60);
		array[5] = new Measured(100);
		array[6] = new Measured(90);
		array[7] = new Measured(10);
		array[8] = new Measured(40);
		array[9] = new Measured(20);
		
		expectedArray[0] = new Measured(10);
		expectedArray[1] = new Measured(20);
		expectedArray[2] = new Measured(30);
		expectedArray[3] = new Measured(40);
		expectedArray[4] = new Measured(50);
		expectedArray[5] = new Measured(60);
		expectedArray[6] = new Measured(70);
		expectedArray[7] = new Measured(80);
		expectedArray[8] = new Measured(90);
		expectedArray[9] = new Measured(100);
	}
	
	@Test
	public void testSort() 
	{
		BubbleSort.sort(array);
		assertArrayEquals("Test sorting", expectedArray, array);
	}

	@Test
	public void testSortNull() 
	{
		array = null;
		BubbleSort.sort(array);
		assertNull("When array is null", null);
	}
	
	@Test
	public void testSortEmpty() 
	{
		array = new Measured[] {};
		BubbleSort.sort(array);
		assertArrayEquals("When array is Empty", new Measured[] {}, array);
	}
}
