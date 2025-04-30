import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the org.dom4j.io.OutputFormat class.
 * Focuses on achieving 100% line coverage without using @Before or @After methods.
 */
public class OutputFormatTest {

    // --- Constructor Tests ---

    @Test
    public void constructorDefaultTest() {
        OutputFormat format = new OutputFormat();
        assertNull("Default indent should be null", format.getIndent());
        assertFalse("Default newlines should be false", format.isNewlines());
        assertEquals("Default encoding should be UTF-8", "UTF-8", format.getEncoding());
        assertFalse("Default suppressDeclaration should be false", format.isSuppressDeclaration());
        assertTrue("Default newLineAfterDeclaration should be true", format.isNewLineAfterDeclaration());
        assertFalse("Default omitEncoding should be false", format.isOmitEncoding());
        assertFalse("Default expandEmptyElements should be false", format.isExpandEmptyElements());
        assertEquals("Default lineSeparator should be \\n", "\n", format.getLineSeparator());
        assertFalse("Default trimText should be false", format.isTrimText());
        assertFalse("Default padText should be false", format.isPadText());
        assertFalse("Default doXHTML should be false", format.isXHTML());
        assertEquals("Default newLineAfterNTags should be 0", 0, format.getNewLineAfterNTags());
        assertEquals("Default attributeQuoteChar should be '\"'", '\"', format.getAttributeQuoteCharacter());
    }

    @Test
    public void constructorIndentTest() {
        String indent = "    ";
        OutputFormat format = new OutputFormat(indent);
        assertEquals("Indent should be set by constructor", indent, format.getIndent());
        // Verify defaults for others are still correct
        assertFalse("Default newlines should be false", format.isNewlines());
        assertEquals("Default encoding should be UTF-8", "UTF-8", format.getEncoding());
    }

    @Test
    public void constructorIndentNewlinesTest() {
        String indent = "\t";
        boolean newlines = true;
        OutputFormat format = new OutputFormat(indent, newlines);
        assertEquals("Indent should be set by constructor", indent, format.getIndent());
        assertTrue("Newlines should be set by constructor", format.isNewlines());
        // Verify default for encoding
        assertEquals("Default encoding should be UTF-8", "UTF-8", format.getEncoding());
    }

    @Test
    public void constructorIndentNewlinesEncodingTest() {
        String indent = " ";
        boolean newlines = false;
        String encoding = "ISO-8859-1";
        OutputFormat format = new OutputFormat(indent, newlines, encoding);
        assertEquals("Indent should be set by constructor", indent, format.getIndent());
        assertFalse("Newlines should be set by constructor", format.isNewlines());
        assertEquals("Encoding should be set by constructor", encoding, format.getEncoding());
    }

    // --- Getter/Setter Tests ---

    @Test
    public void getSetLineSeparatorTest() {
        OutputFormat format = new OutputFormat();
        String customSeparator = "\r\n";
        format.setLineSeparator(customSeparator);
        assertEquals("Line separator should be updated", customSeparator, format.getLineSeparator());
    }

    @Test
    public void getSetNewlinesTest() {
        OutputFormat format = new OutputFormat();
        assertFalse("Initial newlines should be false", format.isNewlines());
        format.setNewlines(true);
        assertTrue("Newlines should be updated to true", format.isNewlines());
        format.setNewlines(false);
        assertFalse("Newlines should be updated to false", format.isNewlines());
    }

    @Test
    public void getSetEncodingTest() {
        OutputFormat format = new OutputFormat();
        String customEncoding = "US-ASCII";
        format.setEncoding(customEncoding);
        assertEquals("Encoding should be updated", customEncoding, format.getEncoding());
    }

    @Test
    public void setEncodingNullTest() {
        OutputFormat format = new OutputFormat();
        String initialEncoding = format.getEncoding();
        format.setEncoding(null); // Should be ignored
        assertEquals("Encoding should not change when set to null", initialEncoding, format.getEncoding());
    }


    @Test
    public void getSetOmitEncodingTest() {
        OutputFormat format = new OutputFormat();
        assertFalse("Initial omitEncoding should be false", format.isOmitEncoding());
        format.setOmitEncoding(true);
        assertTrue("omitEncoding should be updated to true", format.isOmitEncoding());
        format.setOmitEncoding(false);
        assertFalse("omitEncoding should be updated to false", format.isOmitEncoding());
    }

    @Test
    public void getSetSuppressDeclarationTest() {
        OutputFormat format = new OutputFormat();
        assertFalse("Initial suppressDeclaration should be false", format.isSuppressDeclaration());
        format.setSuppressDeclaration(true);
        assertTrue("suppressDeclaration should be updated to true", format.isSuppressDeclaration());
        format.setSuppressDeclaration(false);
        assertFalse("suppressDeclaration should be updated to false", format.isSuppressDeclaration());
    }

    @Test
    public void getSetNewLineAfterDeclarationTest() {
        OutputFormat format = new OutputFormat();
        assertTrue("Initial newLineAfterDeclaration should be true", format.isNewLineAfterDeclaration());
        format.setNewLineAfterDeclaration(false);
        assertFalse("newLineAfterDeclaration should be updated to false", format.isNewLineAfterDeclaration());
        format.setNewLineAfterDeclaration(true);
        assertTrue("newLineAfterDeclaration should be updated to true", format.isNewLineAfterDeclaration());
    }

    @Test
    public void getSetExpandEmptyElementsTest() {
        OutputFormat format = new OutputFormat();
        assertFalse("Initial expandEmptyElements should be false", format.isExpandEmptyElements());
        format.setExpandEmptyElements(true);
        assertTrue("expandEmptyElements should be updated to true", format.isExpandEmptyElements());
        format.setExpandEmptyElements(false);
        assertFalse("expandEmptyElements should be updated to false", format.isExpandEmptyElements());
    }

    @Test
    public void getSetTrimTextTest() {
        OutputFormat format = new OutputFormat();
        assertFalse("Initial trimText should be false", format.isTrimText());
        format.setTrimText(true);
        assertTrue("trimText should be updated to true", format.isTrimText());
        format.setTrimText(false);
        assertFalse("trimText should be updated to false", format.isTrimText());
    }

    @Test
    public void getSetPadTextTest() {
        OutputFormat format = new OutputFormat();
        assertFalse("Initial padText should be false", format.isPadText());
        format.setPadText(true);
        assertTrue("padText should be updated to true", format.isPadText());
        format.setPadText(false);
        assertFalse("padText should be updated to false", format.isPadText());
    }

    @Test
    public void getSetIndentStringTest() {
        OutputFormat format = new OutputFormat();
        String customIndent = "   ";
        format.setIndent(customIndent);
        assertEquals("Indent string should be updated", customIndent, format.getIndent());
    }

    @Test
    public void setIndentStringNullTest() {
        OutputFormat format = new OutputFormat("  "); // Start with non-null indent
        format.setIndent((String) null);
        assertNull("Indent string should be updated to null", format.getIndent());
    }

     @Test
    public void setIndentStringEmptyTest() {
        OutputFormat format = new OutputFormat("  "); // Start with non-null indent
        format.setIndent(""); // Empty string should result in null indent
        assertNull("Empty indent string should result in null indent", format.getIndent());
    }

    @Test
    public void setIndentBooleanTrueTest() {
        OutputFormat format = new OutputFormat();
        format.setIndent(true);
        assertEquals("Indent boolean true should set standard indent", OutputFormat.STANDARD_INDENT, format.getIndent());
    }

    @Test
    public void setIndentBooleanFalseTest() {
        OutputFormat format = new OutputFormat("  "); // Start with non-null indent
        format.setIndent(false);
        assertNull("Indent boolean false should set indent to null", format.getIndent());
    }

    @Test
    public void setIndentSizePositiveTest() {
        OutputFormat format = new OutputFormat();
        format.setIndentSize(4);
        assertEquals("Indent size 4 should create four spaces", "    ", format.getIndent());
    }

     @Test
    public void setIndentSizeZeroTest() {
        OutputFormat format = new OutputFormat();
        format.setIndentSize(0);
        assertEquals("Indent size 0 should create empty string", "", format.getIndent());
        // Note: setIndent("") internally sets it to null, but setIndentSize(0) results in ""
        // Let's test the direct result of setIndentSize(0).
        // If strict nullification on empty is desired, setIndent(format.getIndent()) could be called after setIndentSize.
    }

    @Test
    public void getSetXHTMLTest() {
        OutputFormat format = new OutputFormat();
        assertFalse("Initial XHTML should be false", format.isXHTML());
        format.setXHTML(true);
        assertTrue("XHTML should be updated to true", format.isXHTML());
        format.setXHTML(false);
        assertFalse("XHTML should be updated to false", format.isXHTML());
    }

    @Test
    public void getSetNewLineAfterNTagsTest() {
        OutputFormat format = new OutputFormat();
        assertEquals("Initial newLineAfterNTags should be 0", 0, format.getNewLineAfterNTags());
        format.setNewLineAfterNTags(10);
        assertEquals("newLineAfterNTags should be updated", 10, format.getNewLineAfterNTags());
        format.setNewLineAfterNTags(0);
        assertEquals("newLineAfterNTags should be updated back to 0", 0, format.getNewLineAfterNTags());
    }

    @Test
    public void getSetAttributeQuoteCharacterDoubleQuoteTest() {
        OutputFormat format = new OutputFormat();
        format.setAttributeQuoteCharacter('"');
        assertEquals("Attribute quote character should be '\"'", '\"', format.getAttributeQuoteCharacter());
    }

    @Test
    public void getSetAttributeQuoteCharacterSingleQuoteTest() {
        OutputFormat format = new OutputFormat();
        format.setAttributeQuoteCharacter('\'');
        assertEquals("Attribute quote character should be '''", '\'', format.getAttributeQuoteCharacter());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setAttributeQuoteCharacterInvalidTest() {
        OutputFormat format = new OutputFormat();
        format.setAttributeQuoteCharacter('a'); // Invalid character
    }

    // --- parseOptions Tests ---

    @Test
    public void parseOptionsSuppressDeclarationTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-suppressDeclaration"};
        int result = format.parseOptions(args, 0);
        assertTrue("SuppressDeclaration should be true after parsing", format.isSuppressDeclaration());
        assertEquals("Should consume one argument", 1, result);
    }

    @Test
    public void parseOptionsOmitEncodingTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-omitEncoding"};
        int result = format.parseOptions(args, 0);
        assertTrue("OmitEncoding should be true after parsing", format.isOmitEncoding());
        assertEquals("Should consume one argument", 1, result);
    }

    @Test
    public void parseOptionsIndentTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-indent", "    "};
        int result = format.parseOptions(args, 0);
        assertEquals("Indent should be set after parsing", "    ", format.getIndent());
        assertEquals("Should consume two arguments", 2, result);
    }
    
    @Test
    public void parseOptionsIndentEmptyTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-indent", ""};
        int result = format.parseOptions(args, 0);
        assertNull("Indent should be null after parsing empty string", format.getIndent());
        assertEquals("Should consume two arguments", 2, result);
    }

    @Test
    public void parseOptionsIndentSizeTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-indentSize", "3"};
        int result = format.parseOptions(args, 0);
        assertEquals("Indent should be three spaces after parsing", "   ", format.getIndent());
        assertEquals("Should consume two arguments", 2, result);
    }

    @Test
    public void parseOptionsExpandEmptyElementsTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-expandEmpty"}; // Test prefix matching
        int result = format.parseOptions(args, 0);
        assertTrue("ExpandEmptyElements should be true after parsing", format.isExpandEmptyElements());
        assertEquals("Should consume one argument", 1, result);
    }
    
    @Test
    public void parseOptionsExpandEmptyElementsFullTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-expandEmptyElements"}; // Test prefix matching
        int result = format.parseOptions(args, 0);
        assertTrue("ExpandEmptyElements should be true after parsing", format.isExpandEmptyElements());
        assertEquals("Should consume one argument", 1, result);
    }

    @Test
    public void parseOptionsEncodingTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-encoding", "ASCII"};
        int result = format.parseOptions(args, 0);
        assertEquals("Encoding should be set after parsing", "ASCII", format.getEncoding());
        assertEquals("Should consume two arguments", 2, result);
    }

    @Test
    public void parseOptionsNewlinesTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-newlines"};
        int result = format.parseOptions(args, 0);
        assertTrue("Newlines should be true after parsing", format.isNewlines());
        assertEquals("Should consume one argument", 1, result);
    }

    @Test
    public void parseOptionsLineSeparatorTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-lineSeparator", "\r\n"};
        int result = format.parseOptions(args, 0);
        assertEquals("LineSeparator should be set after parsing", "\r\n", format.getLineSeparator());
        assertEquals("Should consume two arguments", 2, result);
    }

    @Test
    public void parseOptionsTrimTextTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-trimText"};
        int result = format.parseOptions(args, 0);
        assertTrue("TrimText should be true after parsing", format.isTrimText());
        assertEquals("Should consume one argument", 1, result);
    }

    @Test
    public void parseOptionsPadTextTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-padText"};
        int result = format.parseOptions(args, 0);
        assertTrue("PadText should be true after parsing", format.isPadText());
        assertEquals("Should consume one argument", 1, result);
    }

    @Test
    public void parseOptionsXHTMLTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-xhtml"}; // Test prefix matching
        int result = format.parseOptions(args, 0);
        assertTrue("XHTML should be true after parsing", format.isXHTML());
        assertEquals("Should consume one argument", 1, result);
    }
    
     @Test
    public void parseOptionsXHTMLFullTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-xhtmlFoo"}; // Test prefix matching
        int result = format.parseOptions(args, 0);
        assertTrue("XHTML should be true after parsing", format.isXHTML());
        assertEquals("Should consume one argument", 1, result);
    }

    @Test
    public void parseOptionsMultipleArgsTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-newlines", "-indentSize", "1", "-trimText"};
        int result = format.parseOptions(args, 0);
        assertTrue("Newlines should be true", format.isNewlines());
        assertEquals("Indent should be one space", " ", format.getIndent());
        assertTrue("TrimText should be true", format.isTrimText());
        assertEquals("Should consume all four arguments", 4, result);
    }

    @Test
    public void parseOptionsStartIndexTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"ignored", "-newlines", "ignoredToo"};
        int result = format.parseOptions(args, 1); // Start parsing from index 1
        assertTrue("Newlines should be true", format.isNewlines());
        assertEquals("Should consume one argument from index 1", 2, result); // Returns index *after* last consumed arg
    }

    @Test
    public void parseOptionsUnknownArgTest() {
        OutputFormat format = new OutputFormat();
        String[] args = {"-newlines", "-unknown", "-trimText"};
        int result = format.parseOptions(args, 0);
        assertTrue("Newlines should be true", format.isNewlines());
        assertFalse("TrimText should remain false", format.isTrimText()); // Parsing stops
        assertEquals("Should return index of unknown argument", 1, result);
    }
    
    // Note: Testing exceptions like ArrayIndexOutOfBounds or NumberFormatException
    // for missing/invalid arguments in parseOptions is testing the JVM's behavior
    // rather than the method's logic itself, as it doesn't catch them.
    // The coverage for the lines causing these exceptions will be achieved
    // by the successful parsing tests (e.g., parseOptionsIndentTest covers args[++i]).

    // --- Static Factory Method Tests ---

    @Test
    public void createPrettyPrintTest() {
        OutputFormat format = OutputFormat.createPrettyPrint();
        assertEquals("PrettyPrint indent should be two spaces", "  ", format.getIndent());
        assertTrue("PrettyPrint newlines should be true", format.isNewlines());
        assertTrue("PrettyPrint trimText should be true", format.isTrimText());
        assertTrue("PrettyPrint padText should be true", format.isPadText());
        // Verify other defaults remain
        assertEquals("Default encoding should be UTF-8", "UTF-8", format.getEncoding());
        assertFalse("Default XHTML should be false", format.isXHTML());
    }

    @Test
    public void createCompactFormatTest() {
        OutputFormat format = OutputFormat.createCompactFormat();
        assertNull("CompactFormat indent should be null", format.getIndent());
        assertFalse("CompactFormat newlines should be false", format.isNewlines());
        assertTrue("CompactFormat trimText should be true", format.isTrimText());
         // Verify other defaults remain
        assertEquals("Default encoding should be UTF-8", "UTF-8", format.getEncoding());
        assertFalse("Default padText should be false", format.isPadText());
    }
}