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
	@Before
	public void setUp() {
		// setup code before running each test case
	}

	@After
	public void tearDown() {
		// teardown code after running each test case
	}


	@Test
	public void testCreatePrettyPrint_indentSizeSet() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndentSize(4);

		assertEquals("    ", format.getIndent());
	}

	@Test
	public void testCreatePrettyPrint_newLinesSet() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setNewlines(true);

		assertTrue(format.isNewlines());
	}

	@Test
	public void testCreatePrettyPrint_padTextSet() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setPadText(true);

		assertTrue(format.isPadText());
	}

	@Test
	public void testCreatePrettyPrint_trimTextSet() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setTrimText(true);

		assertTrue(format.isTrimText());
	}

	@Test
	public void testCreatePrettyPrint_xhtmlSet() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setXHTML(true);

		assertTrue(format.isXHTML());
	}

	@Test
	public void testCreatePrettyPrint_encodingSet() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("ISO-8859-1");

		assertEquals("ISO-8859-1", format.getEncoding());
	}

	@Test
	public void testCreatePrettyPrint_attributeQuoteCharSet() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setAttributeQuoteCharacter('\'');

	 assertEquals('\'', format.getAttributeQuoteCharacter());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCreatePrettyPrint_invalidAttributeQuoteChar() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setAttributeQuoteCharacter('*');
	}

	@Test
	public void testCreatePrettyPrint_nullIndent() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndent(null);

	 assertNull(format.getIndent());
	}
}