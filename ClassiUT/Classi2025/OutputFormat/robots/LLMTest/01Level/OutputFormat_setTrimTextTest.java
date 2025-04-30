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
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setTrimText(boolean)}.
	 * <p>
	 * Test case: trimText is true.
	 * <p>
	 * Expected result: trimText is true.
	 */
	@Test
	public void testSetTrimTextTrue() {
		format.setTrimText(true);
		assertTrue(format.isTrimText());
	}

	/**
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setTrimText(boolean)}.
	 * <p>
	 * Test case: trimText is false.
	 * <p>
	 * Expected result: trimText is false.
	 */
	@Test
	public void testSetTrimTextFalse() {
		format.setTrimText(false);
		assertFalse(format.isTrimText());
	}
}