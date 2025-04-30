// OutputFormat_setNewlinesTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setNewlines(boolean newlines) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setNewlinesTest {
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
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setNewlines(boolean)}.
	 * <p>
	 * Test case: newlines is true.
	 * <p>
	 * Expected result: newlines is true.
	 */
	@Test
	public void testSetNewlinesTrue() {
		format.setNewlines(true);
		assertTrue(format.isNewlines());
	}

	/**
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setNewlines(boolean)}.
	 * <p>
	 * Test case: newlines is false.
	 * <p>
	 * Expected result: newlines is false.
	 */
	@Test
	public void testSetNewlinesFalse() {
		format.setNewlines(false);
		assertFalse(format.isNewlines());
	}
}