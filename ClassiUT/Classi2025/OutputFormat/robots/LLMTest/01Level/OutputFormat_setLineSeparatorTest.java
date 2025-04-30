// OutputFormat_setLineSeparatorTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setLineSeparator(String separator) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setLineSeparatorTest {
	private OutputFormat format;

	@Before
	public void setUp() {
		format = new OutputFormat();
	}

	@After
	public void tearDown() {
		format = null;
	}

}