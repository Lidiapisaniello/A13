// OutputFormat_isNewlinesTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public isNewlines() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_isNewlinesTest {
	private OutputFormat outputFormat;

	@Before
	public void setUp() {
		outputFormat = new OutputFormat();
	}

	@After
	public void tearDown() {
		outputFormat = null;
	}

	@Test
	public void testIsNewlines_default() {
		// Arrange
		boolean expected = false; // default value

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_setTrue() {
		// Arrange
		boolean expected = true;
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_setFalse() {
		// Arrange
		boolean expected = false;
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_afterSetIndent() {
		// Arrange
		boolean expected = false;
		outputFormat.setIndent("  ");
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_afterSetEncoding() {
		// Arrange
		boolean expected = false;
		outputFormat.setEncoding("UTF-8");
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_afterSetOmitEncoding() {
		// Arrange
		boolean expected = false;
		outputFormat.setOmitEncoding(true);
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_afterSetSuppressDeclaration() {
		// Arrange
		boolean expected = false;
		outputFormat.setSuppressDeclaration(true);
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_afterSetExpandEmptyElements() {
		// Arrange
		boolean expected = false;
		outputFormat.setExpandEmptyElements(true);
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_afterSetTrimText() {
		// Arrange
		boolean expected = false;
		outputFormat.setTrimText(true);
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNewlines_afterSetPadText() {
		// Arrange
		boolean expected = false;
		outputFormat.setPadText(true);
		outputFormat.setNewlines(expected);

		// Act
		boolean actual = outputFormat.isNewlines();

		// Assert
		assertEquals(expected, actual);
	}
}