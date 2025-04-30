// OutputFormat_setXHTMLTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setXHTML(boolean xhtml) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setXHTMLTest {
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
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_01() {
		format.setXHTML(true);
		assertTrue(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_02() {
		format.setXHTML(false);
		assertFalse(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_03() {
		format.setXHTML(true);
		assertTrue(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_04() {
		format.setXHTML(false);
		assertFalse(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_05() {
		format.setXHTML(true);
		assertTrue(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_06() {
		format.setXHTML(false);
		assertFalse(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_07() {
		format.setXHTML(true);
		assertTrue(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_08() {
		format.setXHTML(false);
		assertFalse(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_09() {
		format.setXHTML(true);
		assertTrue(format.isXHTML());
	}

	/**
	 * Test the OutputFormat#public setXHTML(boolean xhtml) method.
	 * Arrange:
	 * Act:
	 * Assert:
	 */
	@Test
	public void testSetXHTML_10() {
		format.setXHTML(false);
		assertFalse(format.isXHTML());
	}
}