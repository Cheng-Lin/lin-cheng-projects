package assignment08;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class TestBubbleSort3 
{
	private Measurable[] array;
	private Measurable[] expectedArray;
	
	@Before
	public void setUp() throws Exception 
	{
        ArrayList<Measured> list = new ArrayList<Measured>();
        for(int i = 0; i < 100000; i++) {
            list.add(new Measured(10000*Math.random() - 500));
        }
        array = new Measured[]{};
        array = list.toArray(array);
        Collections.sort(list, new Comp());
        expectedArray = new Measured[]{};
        expectedArray = list.toArray(expectedArray);
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
	
	private class Comp implements Comparator<Measured>
	{
		@Override
		public int compare(Measured arg0, Measured arg1) 
		{
			return Double.compare(arg0.getMeasure(), arg1.getMeasure());
		}
		
	}
}
