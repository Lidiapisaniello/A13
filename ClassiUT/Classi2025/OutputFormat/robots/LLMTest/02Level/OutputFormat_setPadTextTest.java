// OutputFormat_setPadTextTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public setPadText(boolean padText) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_setPadTextTest {
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
     * Test case to check if setPadText sets padText correctly to true.
     */
    @Test
    public void testSetPadTextTrue() {
        outputFormat.setPadText(true);
        assertTrue(outputFormat.isPadText());
    }

    /**
     * Test case to check if setPadText sets padText correctly to false.
     */
    @Test
    public void testSetPadTextFalse() {
        outputFormat.setPadText(false);
        assertFalse(outputFormat.isPadText());
    }
    
    /**
     * Test case to check if setPadText doesn't throw exception when called with null.
     */
    
    /**
     * Test case to check if setPadText doesn't modify existing state when called with same value.
     */
    @Test
    public void testSetPadTextSameValue() {
        boolean oldValue = outputFormat.isPadText();
        outputFormat.setPadText(oldValue);
        assertEquals(oldValue, outputFormat.isPadText());
    }
    
    /**
     * Test case to check if setPadText doesn't change other properties when called.
     */
    @Test
    public void testSetPadTextOtherProperties() {
        outputFormat.setIndent("  ");
        outputFormat.setNewlines(true);
        outputFormat.setTrimText(true);
        outputFormat.setPadText(true);
        
        assertTrue(outputFormat.getIndent().equals("  "));
        assertTrue(outputFormat.isNewlines());
        assertTrue(outputFormat.isTrimText());
    }
    
    /**
     * Test case to check if setPadText handles unexpected inputs gracefully.
     */
    
    /**
     * Test case to check if setPadText updates padText correctly when called multiple times.
     */
    @Test
    public void testSetPadTextMultipleCalls() {
        outputFormat.setPadText(true);
        assertTrue(outputFormat.isPadText());
        
        outputFormat.setPadText(false);
        assertFalse(outputFormat.isPadText());
        
        outputFormat.setPadText(true);
        assertTrue(outputFormat.isPadText());
    }
    
    /**
     * Test case to check if setPadText updates padText correctly when called with opposite values.
     */
    @Test
    public void testSetPadTextOppositeValues() {
        outputFormat.setPadText(true);
        assertTrue(outputFormat.isPadText());
        
        outputFormat.setPadText(false);
        assertFalse(outputFormat.isPadText());
    }
    
    /**
     * Test case to check if setPadText updates padText correctly when called with extreme values.
     */
    @Test
    public void testSetPadTextExtremeValues() {
        outputFormat.setPadText(true);
        assertTrue(outputFormat.isPadText());
        
        outputFormat.setPadText(false);
        assertFalse(outputFormat.isPadText());
    }
}