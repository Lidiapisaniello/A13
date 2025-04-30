// OutputFormat_setSuppressDeclarationTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setSuppressDeclaration(boolean suppressDeclaration) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setSuppressDeclarationTest {
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
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setSuppressDeclaration(boolean)}.
	 * @throws Exception
	 */
	@Test
	public void testSetSuppressDeclarationTrue() throws Exception {
		format.setSuppressDeclaration(true);
		assertTrue(format.isSuppressDeclaration());
	}

	/**
	 * Test method for {@link org.xml.sax.helpers.OutputFormat#setSuppressDeclaration(boolean)}.
	 * @throws Exception
	 */
	@Test
	public void testSetSuppressDeclarationFalse() throws Exception {
		format.setSuppressDeclaration(false);
		assertFalse(format.isSuppressDeclaration());
	}
}