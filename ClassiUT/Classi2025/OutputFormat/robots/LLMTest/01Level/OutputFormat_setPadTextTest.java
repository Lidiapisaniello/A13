// OutputFormat_setPadTextTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setPadText(boolean padText) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setPadTextTest {
	private OutputFormat format;

	@Before
	public void setUp() {
		format = new OutputFormat();
	}

	@After
	public void tearDown() {
		format = null;
	}

	/**
	 * Test the OutputFormat#public setPadText(boolean padText) method.
	 * The test case is: padText = true.
	 * The expected result is: the text immediately preceded by or followed by an element will be "padded" with a single space.
	 */
	@Test
	public void testSetPadTextTrue() {
		format.setPadText(true);
		assertEquals(true, format.isPadText());
	}

	/**
	 * Test the OutputFormat#public setPadText(boolean padText) method.
	 * The test case is: padText = false.
	 * The expected result is: the text immediately preceded by or followed by an element will not be "padded" with a single space.
	 */
	@Test
	public void testSetPadTextFalse() {
		format.setPadText(false);
		assertEquals(false, format.isPadText());
	}
}