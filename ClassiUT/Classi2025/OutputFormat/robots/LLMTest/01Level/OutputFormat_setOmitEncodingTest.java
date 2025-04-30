// OutputFormat_setOmitEncodingTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setOmitEncoding(boolean omitEncoding) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setOmitEncodingTest {
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
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setOmitEncoding(boolean)}.
	 * @throws Exception
	 */
	@Test
	public void testSetOmitEncodingTrue() throws Exception {
		format.setOmitEncoding(true);
		assertTrue(format.isOmitEncoding());
	}

	/**
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setOmitEncoding(boolean)}.
	 * @throws Exception
	 */
	@Test
	public void testSetOmitEncodingFalse() throws Exception {
		format.setOmitEncoding(false);
		assertFalse(format.isOmitEncoding());
	}
}