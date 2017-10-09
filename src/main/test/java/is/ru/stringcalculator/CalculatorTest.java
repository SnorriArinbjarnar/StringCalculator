package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		//sendi tóman streng í calculator
		//hann ætti að skila 0
		//assertEquals ef þetta er eins, þá
		//er þetta í lagi
		assertEquals(0, Calculator.add(""));
	}
	
	@Test 
	public void testOneNumber()
	{
			assertEquals(2, Calculator.add("1"));
	}
	
	@Test
	public void testTwoNumbers()
	{
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testMultipleNumbers()
	{
		assertEquals(6, Calculator.add("2,2,2"));
	}
	
	@Test 
	public void testWithNewLine()
	{
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
	@Test 
	public void testWithBiggerThan1000()
	{
		assertEquals(2, Calculator.add("1001,2"));
	}
	
	
}