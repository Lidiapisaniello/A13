// FTPFile_getNameTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

/**
 * Test class of FTPFile.
 * It contains 10 unit test cases for the
 * FTPFile#public getName() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_getNameTest {

private FTPFile ftpFile;

    @Before
    public void setUp() {
        ftpFile = new FTPFile();
    }

    @After
    public void tearDown() {
        ftpFile = null;
    }

    @Test
    public void testGetName_DefaultConstructor() {
        assertNull("The default name should be null", ftpFile.getName());
    }

    @Test
    public void testGetName_AfterSetName() {
        String expectedName = "testFile.txt";
        ftpFile.setName(expectedName);
        assertEquals("The name should match the set name", expectedName, ftpFile.getName());
    }

    @Test
    public void testGetName_EmptyString() {
        ftpFile.setName("");
        assertEquals("The name should be an empty string", "", ftpFile.getName());
    }

    @Test
    public void testGetName_SpecialCharacters() {
        String specialName = "!@#$%^&*()_+-=~`";
        ftpFile.setName(specialName);
        assertEquals("The name should handle special characters", specialName, ftpFile.getName());
    }

    @Test
    public void testGetName_NumericName() {
        String numericName = "1234567890";
        ftpFile.setName(numericName);
        assertEquals("The name should handle numeric strings", numericName, ftpFile.getName());
    }


    @Test
    public void testGetName_AfterNullSet() {
        ftpFile.setName("initialName");
        ftpFile.setName(null);
        assertNull("Setting name to null should make getName return null", ftpFile.getName());
    }

    @Test
    public void testGetName_WhiteSpaceName() {
        String whiteSpaceName = "   ";
        ftpFile.setName(whiteSpaceName);
        assertEquals("The name should handle white space strings", whiteSpaceName, ftpFile.getName());
    }

    @Test
    public void testGetName_UnicodeName() {
        String unicodeName = "文件.txt";
        ftpFile.setName(unicodeName);
        assertEquals("The name should handle Unicode characters", unicodeName, ftpFile.getName());
    }

    @Test
    public void testGetName_SameInstanceCalls() {
        ftpFile.setName("firstName");
        assertEquals("The name should be 'firstName'", "firstName", ftpFile.getName());
        ftpFile.setName("secondName");
        assertEquals("The name should be updated to 'secondName'", "secondName", ftpFile.getName());
    }
}