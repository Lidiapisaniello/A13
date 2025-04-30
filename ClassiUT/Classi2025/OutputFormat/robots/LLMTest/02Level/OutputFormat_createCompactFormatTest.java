// OutputFormat_createCompactFormatTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public static createCompactFormat() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_createCompactFormatTest {
    private OutputFormat outputFormat;

    @Before
    public void setUp() {
        outputFormat = OutputFormat.createCompactFormat();
    }

    @After
    public void tearDown() {
        outputFormat = null;
    }

    @Test
    public void testCreateCompactFormat_indent() {
        assertEquals(null, outputFormat.getIndent());
    }

    @Test
    public void testCreateCompactFormat_newlines() {
        assertFalse(outputFormat.isNewlines());
    }

    @Test
    public void testCreateCompactFormat_trimText() {
        assertTrue(outputFormat.isTrimText());
    }

    @Test
    public void testCreateCompactFormat_padText() {
        assertFalse(outputFormat.isPadText());
    }

    @Test
    public void testCreateCompactFormat_xhtml() {
        assertFalse(outputFormat.isXHTML());
    }

    @Test
    public void testCreateCompactFormat_suppressDeclaration() {
        assertFalse(outputFormat.isSuppressDeclaration());
    }

    @Test
    public void testCreateCompactFormat_omitEncoding() {
        assertFalse(outputFormat.isOmitEncoding());
    }

    @Test
    public void testCreateCompactFormat_expandEmptyElements() {
        assertFalse(outputFormat.isExpandEmptyElements());
    }

    @Test
    public void testCreateCompactFormat_encoding() {
        assertEquals("UTF-8", outputFormat.getEncoding());
    }
}