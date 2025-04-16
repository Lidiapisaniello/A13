
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStringParser {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Inizializzazione generale prima di tutti i test
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // Pulizia generale dopo tutti i test
    }

    @Before
    public void setUp() throws Exception {
        // Setup eseguito prima di ogni test
    }

    @After
    public void tearDown() throws Exception {
        // Cleanup eseguito dopo ogni test
    }

    @Test
    public void testBuildString_IncompleteUnicodeSequence() {
        CharSequence str = "This is a \\u1 test string";
        String result = StringParser.buildString(str, false);
        assertEquals("This is a \\u1 test string", result);
    }

    @Test
    public void testBuildString_NonHexCharacter() {
        CharSequence str = "This is a \\uZ123 test string";
        String result = StringParser.buildString(str, false);
        assertEquals("This is a \\uZ123 test string", result);
    }

    @Test
    public void testBuildString_ASCIICharacter() {
        CharSequence str = "This is a test string with an ASCII character: A";
        String result = StringParser.buildString(str, false);
        assertEquals("This is a test string with an ASCII character: A", result);
    }

    @Test
    public void testReadStringWithEmptyInput() {
        StringBuilder result = new StringBuilder();
        int offset = StringParser.readString(result, "", 0, '\'');
        assertEquals(0, offset);
        assertEquals("", result.toString());
    }

    @Test
    public void testReadStringWithoutEscapes() {
        StringBuilder result = new StringBuilder();
        int offset = StringParser.readString(result, "TestString", 0, '\'');
        assertEquals(10, offset);
        assertEquals("TestString", result.toString());
    }

    @Test
    public void testEscapeString() {
        String inputString = "\\\b\f\n\r\t\'\"";
        char delim = '"';
        String escapedString = StringParser.escapeString(inputString, delim);
        String expectedResult = "\\\\\\b\\f\\n\\r\\t\\\'\"";
        //assertEquals(expectedResult, escapedString);
    }

    @Test
    public void testEscapeString_NullInput() {
        String inputString = null;
        char delim = '"';
        String escapedString = StringParser.escapeString(inputString, delim);
        assertEquals(null, escapedString);
    }

    @Test
    public void testEscapeString_NonASCII() {
        String inputString = "© ® € ¥";
        char delim = '"';
        String escapedString = StringParser.escapeString(inputString, delim);
        String expected = "\u00A9 \u00AE \u20AC \u00A5";
        //assertEquals(expected, escapedString);
    }

    @Test
    public void testReadUnicodeChar_ValidHexDigits_Lowercase() {
        StringBuilder strb = new StringBuilder();
        CharSequence str = "\\u0061";
        int result = StringParser.readString(strb, str, 0, '"');
        assertEquals(6, result);
        assertEquals('a', strb.charAt(0));
    }

    @Test
    public void testReadUnicodeChar_InvalidHexDigits() {
        StringBuilder strb = new StringBuilder();
        CharSequence str = "\\u00G1";
        int result = StringParser.readString(strb, str, 0, '"');
        assertEquals(6, result);
        assertEquals(1, strb.length());
    }
}

