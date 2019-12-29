package com.paytm.sdechallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CircularBufferTest {

	private CircularBuffer objectToTest;
	
	@Before
	public void init() {
		objectToTest = new CircularBuffer(5);
	}
	
	@Test
	public void testAverage() {
		
		objectToTest.addElement(1);
		objectToTest.addElement(2);
		objectToTest.addElement(3);
		objectToTest.addElement(4);
		objectToTest.addElement(5);
		
		assertEquals(Double.valueOf(3), objectToTest.getMovingAverage());
	}
	
	@Test
	public void testMovingAverage() {
		objectToTest.addElement(1);
		assertEquals(Double.valueOf(1), objectToTest.getMovingAverage());

		objectToTest.addElement(2);
		assertEquals(Double.valueOf(1.5), objectToTest.getMovingAverage());

		objectToTest.addElement(3);
		assertEquals(Double.valueOf(2), objectToTest.getMovingAverage());
		
	}
	
	@Test
	public void testOverWrite() {
		
		objectToTest.addElement(1);
		objectToTest.addElement(2);
		objectToTest.addElement(3);
		objectToTest.addElement(4);
		objectToTest.addElement(5);
		objectToTest.addElement(6);
		
		assertEquals(Double.valueOf(4), objectToTest.getMovingAverage());
	}
	
	
}
