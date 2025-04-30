// OutputFormat_setAttributeQuoteCharacterTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setAttributeQuoteCharacter(char quoteChar) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setAttributeQuoteCharacterTest {
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
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setAttributeQuoteCharacter(char)}.
	 * @throws Exception
	 */
	@Test
	public void testSetAttributeQuoteCharacter_char() throws Exception {
		// Arrange
		char quoteChar = '\'';

		// Act
		format.setAttributeQuoteCharacter(quoteChar);

		// Assert
		assertEquals(quoteChar, format.getAttributeQuoteCharacter());
	}

	/**
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setAttributeQuoteCharacter(char)}.
	 * @throws Exception
	 */
	@Test
	public void testSetAttributeQuoteCharacter_char_Invalid() throws Exception {
		// Arrange
		char quoteChar = 'a';

		// Act
		try {
			format.setAttributeQuoteCharacter(quoteChar);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
			// Assert
			assertEquals("Invalid attribute quote character (a)", e.getMessage());
		}
	}
}