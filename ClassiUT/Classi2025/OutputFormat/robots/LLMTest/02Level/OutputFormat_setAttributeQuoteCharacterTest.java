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
    
    private OutputFormat outputFormat;

    @Before
    public void setUp() throws Exception {
        outputFormat = new OutputFormat();
    }

    @After
    public void tearDown() throws Exception {
        outputFormat = null;
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetAttributeQuoteCharacter_InvalidCharacter() {
        outputFormat.setAttributeQuoteCharacter('#');
    }

    @Test
    public void testSetAttributeQuoteCharacter_QuotationMark() {
        outputFormat.setAttributeQuoteCharacter('"');
        assertEquals(outputFormat.getAttributeQuoteCharacter(), '"');
    }

    @Test
    public void testSetAttributeQuoteCharacter_Apostrophe() {
        outputFormat.setAttributeQuoteCharacter('\'');
        assertEquals(outputFormat.getAttributeQuoteCharacter(), '\'');
    }
}