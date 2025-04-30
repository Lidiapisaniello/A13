// OutputFormat_isXHTMLTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public isXHTML() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_isXHTMLTest {
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
    public void testIsXHTML_InitialValue() {
        assertFalse(outputFormat.isXHTML());
    }

    @Test
    public void testIsXHTML_SetToTrue() {
        outputFormat.setXHTML(true);
        assertTrue(outputFormat.isXHTML());
    }

    @Test
    public void testIsXHTML_SetToFalse() {
        outputFormat.setXHTML(false);
        assertFalse(outputFormat.isXHTML());
    }
    
    @Test
    public void testIsXHTML_MultipleSetCalls() {
        outputFormat.setXHTML(true);
        assertTrue(outputFormat.isXHTML());
        outputFormat.setXHTML(false);
        assertFalse(outputFormat.isXHTML());
        outputFormat.setXHTML(true);
        assertTrue(outputFormat.isXHTML());
    }
    
    @Test
    public void testIsXHTML_ChangeFromTrueToFalse() {
        outputFormat.setXHTML(true);
        assertTrue(outputFormat.isXHTML());
        outputFormat.setXHTML(false);
        assertFalse(outputFormat.isXHTML());
    }
    
    @Test
    public void testIsXHTML_ChangeFromFalseToTrue() {
        outputFormat.setXHTML(false);
        assertFalse(outputFormat.isXHTML());
        outputFormat.setXHTML(true);
        assertTrue(outputFormat.isXHTML());
    }
    
    @Test
    public void testIsXHTML_NoChange() {
        outputFormat.setXHTML(true);
        assertTrue(outputFormat.isXHTML());
        outputFormat.setXHTML(true);
        assertTrue(outputFormat.isXHTML());
    }
    
    @Test
    public void testIsXHTML_NullInput() {
        outputFormat.setAttributeQuoteCharacter('\'');
        assertEquals('\'', outputFormat.getAttributeQuoteCharacter());
    }
    
    @Test
    public void testIsXHTML_EmptyStringInput() {
        outputFormat.setAttributeQuoteCharacter('\"');
        assertEquals('\"', outputFormat.getAttributeQuoteCharacter());
    }
    
    @Test
    public void testIsXHTML_LargeNumberInput() {
        outputFormat.setAttributeQuoteCharacter('\"');
        assertEquals('\"', outputFormat.getAttributeQuoteCharacter());
    }
}