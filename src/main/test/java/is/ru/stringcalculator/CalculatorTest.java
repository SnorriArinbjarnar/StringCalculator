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
	
	
}