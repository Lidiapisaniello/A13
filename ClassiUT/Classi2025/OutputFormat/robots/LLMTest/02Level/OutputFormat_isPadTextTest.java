// OutputFormat_isPadTextTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public isPadText() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_isPadTextTest {
	private OutputFormat format;

	@Before
	public void setUp() {
		format = new OutputFormat();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testIsPadText_WhenPadTextIsFalse() {
		format.setPadText(false);
		boolean result = format.isPadText();
		assertEquals(false, result);
	}

	@Test
	public void testIsPadText_WhenPadTextIsTrue() {
		format.setPadText(true);
		boolean result = format.isPadText();
		assertEquals(true, result);
	}

	@Test
	public void testIsPadText_DefaultValue() {
		boolean result = format.isPadText();
		assertEquals(false, result);
	}







}