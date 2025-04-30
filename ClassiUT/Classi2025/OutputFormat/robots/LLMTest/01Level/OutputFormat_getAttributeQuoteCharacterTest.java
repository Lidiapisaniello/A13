// OutputFormat_getAttributeQuoteCharacterTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public getAttributeQuoteCharacter() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_getAttributeQuoteCharacterTest {
	private OutputFormat outputFormat;

	@Before
	public void setUp() {
		outputFormat = new OutputFormat();
	}

	@After
	public void tearDown() {
		outputFormat = null;
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_001() {
		// Arrange:
		char expected = '"';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_002() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_003() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_004() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_005() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_006() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_007() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_008() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_009() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}

	/**
	 * Test the OutputFormat#public getAttributeQuoteCharacter() method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void test_getAttributeQuoteCharacter_010() {
		// Arrange:
		outputFormat.setAttributeQuoteCharacter('\'');
		char expected = '\'';

		// Act:
		char actual = outputFormat.getAttributeQuoteCharacter();

		// Assert:
		assertEquals(expected, actual);
	}
}