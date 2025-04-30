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
		format = null;
	}

	/**
	 * Test the OutputFormat#public isPadText() method with the following
	 * parameters:
	 * <ul>
	 * <li>padText = true</li>
	 * </ul>
	 * Expected result:
	 * <ul>
	 * <li>The method should return true.</li>
	 * </ul>
	 */
	@Test
	public void testIsPadTextTrue() {
		format.setPadText(true);
		assertTrue(format.isPadText());
	}

	/**
	 * Test the OutputFormat#public isPadText() method with the following
	 * parameters:
	 * <ul>
	 * <li>padText = false</li>
	 * </ul>
	 * Expected result:
	 * <ul>
	 * <li>The method should return false.</li>
	 * </ul>
	 */
	@Test
	public void testIsPadTextFalse() {
		format.setPadText(false);
		assertFalse(format.isPadText());
	}
}