// OutputFormat_createPrettyPrintTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public static createPrettyPrint() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_createPrettyPrintTest {
	private OutputFormat format;

	@Before
	public void setUp() {
		format = OutputFormat.createPrettyPrint();
	}

	@After
	public void tearDown() {
		format = null;
	}

	/**
	 * Test the OutputFormat#public static createPrettyPrint() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testCreatePrettyPrint() {
		// Arrange:
		// Act:
		// Assert:
		assertEquals(format.getIndent(), "  ");
		assertEquals(format.isExpandEmptyElements(), false);
		assertEquals(format.isNewLineAfterDeclaration(), true);
		assertEquals(format.isOmitEncoding(), false);
		assertEquals(format.isPadText(), true);
		assertEquals(format.isSuppressDeclaration(), false);
		assertEquals(format.isTrimText(), true);
		assertEquals(format.isXHTML(), false);
	}
}