import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {
	
	// ---------------------------------------------------------------------------------------
	//
	//		BLACK BOX TESTING
	//
	// ---------------------------------------------------------------------------------------
	/*
	 *  sin( square, increment, negate )
	 * 		false, false, false
	 * 		true, false, false
	 * 		false, true, false
	 * 		false, false, true
	 * 		true, true, false
	 * 		true, false, true
	 * 		false, true, true
	 * 		true, true, true
	 * 
	 * 		Arbitrarily large x
	 * 		Arbitrarily small x
	 * 		negative x
	 * 		positive x
	 * 		0 value x
	 */
	
	@Test
	public void testNegativeValSqr() {
		assertEquals("Error: should be 25", 25, sin(5, true, false, false));
	}
	
	@Test
	public void testNegativeValSqrInc() {
		assertEquals("Error: should be 26", 26, sin(5, true, true, false));
	}
	
	@Test
	public void testNegativeValSqrIncNeg() {
		assertEquals("Error: should be -26", 26, sin(5, true, true, true));
	}
	 
	@Test
	public void testMaxIntSquare() {
		assertEquals("Error: should be 1", 1, sin(Integer.MAX_VALUE, true, false, false));
	}
	
	@Test
	public void testMaxIntSquareInc() {
		assertEquals("Error: should be 2", 2, sin(Integer.MAX_VALUE, true, true, false));
	}
	
	@Test
	public void testMaxIntSquareIncNeg() {
		assertEquals("Error: should be -2", -2, sin(Integer.MAX_VALUE, true, true, true));
	}
	
	@Test
	public void testMinIntSquare() {
		assertEquals("Error: should be 1", 1, sin(Integer.MIN_VALUE, true, false, false));
	}
	
	@Test
	public void testMinIntSquareInc() {
		assertEquals("Error: should be 2", 2, sin(Integer.MIN_VALUE, true, true, false));
	}
	
	@Test
	public void testMinIntSquareIncNeg() {
		assertEquals("Error: should be -2", -2, sin(Integer.MIN_VALUE, true, true, true));
	}

	@Test
	public void testAllFalse() {
		assertEquals("Error: should be 10!", 10, sin(10, false, false, false));
	}
	
	@Test
	public void testSquareTrue() {
		assertEquals("Error: should be 100!", 10, sin(10, true, false, false));
	}
	
	@Test
	public void testIncrementTrue() {
		assertEquals("Error: should be 11!", 11, sin(10, false, true, false));
	}
	
	@Test
	public void testNegateTrue() {
		assertEquals("Error: should be -11!", -11, sin(11, false, false, true));
	}

	@Test
	public void testNegateFalse() {
		assertEquals("Error: should be 101!", 101, sin(10, true, true, false));
	}
	
	@Test
	public void testIncrementFalse() {
		assertEquals("Error: should be -100!", -100, sin(10, true, false, true));
	}
	
	@Test
	public void testSquareFalse() {
		assertEquals("Error: should be -11!", -11, sin(10, false, true, true));
	}
	
	@Test
	public void testAllTrue() {
		assertEquals("Error: should be -101!", -101, sin(11, true, true, true));
	}
	
	// ---------------------------------------------------------------------------------------
	//
	//		WHITE BOX TESTING
	//
	// ---------------------------------------------------------------------------------------

	@Test
	public void testWhiteSquareTrue() {
		assertEquals("Error: should be 100!", 10, sin(10, true, false, false));
	}
	
	@Test
	public void testWhiteIncrementTrue() {
		assertEquals("Error: should be 11!", 11, sin(10, false, true, false));
	}
	
	@Test
	public void testWhiteNegateTrue() {
		assertEquals("Error: should be -11!", -11, sin(11, false, false, true));
	}
	
	public int sin(int x, boolean square, boolean increment, boolean negate) {
		if (square || increment || negate) {
			x *= x;
			if (increment) {
				x += 1;
				if (negate) 
					x = -x;
			}
		}
		return x;
	}
}