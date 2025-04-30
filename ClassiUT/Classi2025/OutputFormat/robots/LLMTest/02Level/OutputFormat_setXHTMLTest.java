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
    public void testSetXHTMLWithTrue() {
        outputFormat.setXHTML(true);
        assertTrue(outputFormat.isXHTML());
    }

    @Test
    public void testSetXHTMLWithFalse() {
        outputFormat.setXHTML(false);
        assertFalse(outputFormat.isXHTML());
    }
}