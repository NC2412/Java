import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	//Switch which line is commented out in order to test the correct vs broken code
	//TestingFunctions functions = new BlackBoxCorrect();
	TestingFunctions functions = new BlackBoxIncorrect();
	
	/**
	 * This is a simple validity check for the method greatestCommonDivisor. Checks that the method
	 * returns the correct result for a known GCD problem gcd(2,4) = 2
	 */
	@Test
	public void test0InputGCD() {
		// 0 value inputs
		assertEquals("Error: should return 0", 100, functions.greatestCommonDivisor(0, 100));	
	}
	
	@Test
	public void testNegativeGCD() {
		// Negative value inputs
		assertEquals("Error: should return -1", -1, functions.greatestCommonDivisor(-11, -33));
	}
	
	@Test
	public void test1ValueGCD() {
		// Inputs with a GCD of 1
		assertEquals("Error: should return 1", 1, functions.greatestCommonDivisor(17, 997));
	}
	
	public void testSameValueGCD() {
		// Inputs with a GCD equal to one of the values
		assertEquals("Error: should return 2", 2, functions.greatestCommonDivisor(2, 4));
	}
	
	public void testGeneralInput() {
		// General inputs
		assertEquals("Error: should return 10", 10, functions.greatestCommonDivisor(20, 30));
	}
	
	/**
	 * This is a simple check of the reverseWindow method. Checks if the method will reverse the entire contents
	 * of the passed array correctly.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testReverseWindowOutOfBounds() {
		int[] arr = { 5, 3, 1 };
		int[] expected = { 1, 3, 5 };
		functions.reverseWindow(arr, -1, 7);
		
		// Input indices out of bound of the array size
		assertArrayEquals(arr, expected);
	}
	
	@Test
	public void testReverseWindowFullArray() {
		int[] arr = { 5, 3, 2, 1, 0 };
		int [] expected = { 0, 1, 2, 3, 5 };
		
		functions.reverseWindow(arr, 0, arr.length);

		// Input indices at the bounds of the array size
		assertArrayEquals(arr, expected);
	}
	
	@Test
	public void testReverseWindowReverseIndices() {
		int[] arr = { 5, 3, 2, 1, 0 };
		int [] expected = { 3, 5, 2, 1, 0 };
		
		functions.reverseWindow(arr, 2, 0);
		
		// Reversed input indices
		assertArrayEquals(arr, expected);
	}
	
	@Test
	public void testReverseWindowEmptyArr() {
		int[] arr = { };
		int [] expected = { };
		
		functions.reverseWindow(arr, 0, arr.length);
		
		// Input with an empty array
		assertArrayEquals(arr, expected);
	}
	
	@Test
	public void testReverseWindowEqualIndices() {
		int[] arr = { 5, 3, 2, 1, 0 };
		int [] expected = { 5, 3, 2, 1, 0 };
		
		functions.reverseWindow(arr, 3, 3);

		//Input with equal indices
		assertArrayEquals(arr, expected);
	}
	
	@Test
	public void testREverseWindowSubSection() {
		int[] arr =       { 5, 3, 2, 1, 0, 4 };
		int [] expected = { 5, 3, 0, 1, 2, 4 };
		
		functions.reverseWindow(arr, 2, 5);

		//Input with sub section
		assertArrayEquals(arr, expected);
	}

	//For completion, write additional tests as described in the lab documentation.
}
