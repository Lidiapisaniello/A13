// FTPFile_setNameTest.java
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
 * FTPFile#public setName(String name) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_setNameTest {

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
    public void testSetName_NormalStringName() {
        // Arrange
        String testName = "example.txt";

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should be set correctly", testName, ftpFile.getName());
    }

    @Test
    public void testSetName_EmptyStringName() {
        // Arrange
        String testName = "";

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should be set to an empty string", testName, ftpFile.getName());
    }

    @Test
    public void testSetName_SpecialCharacters() {
        // Arrange
        String testName = "!@#$%^&*()_+[];'./,<>?:{}|";

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should include special characters", testName, ftpFile.getName());
    }

    @Test
    public void testSetName_NullName() {
        // Arrange
        String testName = null;

        // Act
        ftpFile.setName(testName);

        // Assert
        assertNull("The file name should be null", ftpFile.getName());
    }

    @Test
    public void testSetName_LongStringName() {
        // Arrange
        String testName = new String(new char[1024]).replace('\0', 'a');

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should accommodate a long string", testName, ftpFile.getName());
    }

    @Test
    public void testSetName_WhitespaceName() {
        // Arrange
        String testName = "  ";

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should include whitespace", testName, ftpFile.getName());
    }

    @Test
    public void testSetName_UnicodeName() {
        // Arrange
        String testName = "文件.txt";

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should support unicode characters", testName, ftpFile.getName());
    }

    @Test
    public void testSetName_SlashCharacter() {
        // Arrange
        String testName = "folder/file.txt";

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should handle slash characters", testName, ftpFile.getName());
    }

    @Test
    public void testSetName_DotName() {
        // Arrange
        String testName = ".hiddenfile";

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should handle names starting with a dot", testName, ftpFile.getName());
    }

    @Test
    public void testSetName_TrailingWhitespace() {
        // Arrange
        String testName = "example with spaces.txt  ";

        // Act
        ftpFile.setName(testName);

        // Assert
        assertEquals("The file name should include trailing whitespace", testName, ftpFile.getName());
    }
}