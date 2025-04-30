// OutputFormat_setTrimTextTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setTrimText(boolean trimText) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setTrimTextTest {
	private OutputFormat outputFormat;

	@Before
	public void setUp() {
		outputFormat = new OutputFormat();
	}

	@After
	public void tearDown() {
		outputFormat = null;
	}

	@Test
	public void testSetTrimTextTrue() {
		// Arrange
		boolean expected = true;

		// Act
		outputFormat.setTrimText(expected);

		// Assert
		assertEquals(expected, outputFormat.isTrimText());
	}

	@Test
	public void testSetTrimTextFalse() {
		// Arrange
		boolean expected = false;

		// Act
		outputFormat.setTrimText(expected);

		// Assert
		assertEquals(expected, outputFormat.isTrimText());
	}


	@Test
	public void testSetTrimTextSameValue() {
		// Arrange
		boolean currentValue = outputFormat.isTrimText();
		boolean newValue = currentValue;

		// Act
		outputFormat.setTrimText(newValue);

		// Assert
	 assertEquals(currentValue, outputFormat.isTrimText());
	}

	@Test
	public void testSetTrimTextConsecutiveCalls() {
		// Arrange
		boolean firstValue = true;
		boolean secondValue = false;

		// Act
		outputFormat.setTrimText(firstValue);
		outputFormat.setTrimText(secondValue);

		// Assert
	 assertEquals(secondValue, outputFormat.isTrimText());
	}

	@Test
	public void testSetTrimTextBooleanLiteral() {
		// Arrange
		boolean expected = true;

		// Act
		outputFormat.setTrimText(expected);

		// Assert
	 assertTrue(outputFormat.isTrimText());
	}

	@Test
	public void testSetTrimTextOppositeValues() {
		// Arrange
		boolean firstValue = true;
		boolean secondValue =!firstValue;

		// Act
		outputFormat.setTrimText(firstValue);
		outputFormat.setTrimText(secondValue);

		// Assert
	 assertFalse(outputFormat.isTrimText());
	}

	@Test
	public void testSetTrimTextDefaultConstructor() {
		// Arrange
		boolean expected = false; // default value

		// Act
		outputFormat = new OutputFormat();
		outputFormat.setTrimText(expected);

		// Assert
	 assertEquals(expected, outputFormat.isTrimText());
	}

	@Test
	public void testSetTrimTextMultipleTimes() {
		// Arrange
		boolean value1 = true;
		boolean value2 = false;
		boolean value3 = true;

		// Act
		outputFormat.setTrimText(value1);
		outputFormat.setTrimText(value2);
		outputFormat.setTrimText(value3);

		// Assert
	 assertEquals(value3, outputFormat.isTrimText());
	}
}