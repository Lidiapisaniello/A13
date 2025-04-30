// OutputFormat_isTrimTextTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public isTrimText() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_isTrimTextTest {
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
     * Test case to check if the method returns true when trimText is set to true
     */
    @Test
    public void testIsTrimTextTrue() {
        outputFormat.setTrimText(true);
        assertTrue(outputFormat.isTrimText());
    }

    /**
     * Test case to check if the method returns false when trimText is set to false
     */
    @Test
    public void testIsTrimTextFalse() {
        outputFormat.setTrimText(false);
        assertFalse(outputFormat.isTrimText());
    }

    /**
     * Test case to check if the method returns false when trimText is not set
     */
    @Test
    public void testIsTrimTextNotSet() {
        assertFalse(outputFormat.isTrimText());
    }
}