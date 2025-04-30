// FTPFile_isDirectoryTest.java
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
 * FTPFile#public isDirectory() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_isDirectoryTest {

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
    public void testIsDirectoryWhenTypeIsDirectory() {
        // Arrange
        ftpFile.setType(FTPFile.DIRECTORY_TYPE);

        // Act
        boolean result = ftpFile.isDirectory();

        // Assert
        assertTrue("File should be a directory", result);
    }

    @Test
    public void testIsDirectoryWhenTypeIsFile() {
        // Arrange
        ftpFile.setType(FTPFile.FILE_TYPE);

        // Act
        boolean result = ftpFile.isDirectory();

        // Assert
        assertFalse("File should not be a directory", result);
    }

    @Test
    public void testIsDirectoryWhenTypeIsSymbolicLink() {
        // Arrange
        ftpFile.setType(FTPFile.SYMBOLIC_LINK_TYPE);

        // Act
        boolean result = ftpFile.isDirectory();

        // Assert
        assertFalse("File should not be a directory", result);
    }

    @Test
    public void testIsDirectoryWhenTypeIsUnknown() {
        // Arrange
        ftpFile.setType(FTPFile.UNKNOWN_TYPE);

        // Act
        boolean result = ftpFile.isDirectory();

        // Assert
        assertFalse("File should not be a directory", result);
    }

    @Test
    public void testIsDirectoryWithDefaultType() {
        // Act
        boolean result = ftpFile.isDirectory();

        // Assert
        assertFalse("File should not be a directory with default type", result);
    }

    @Test
    public void testIsDirectoryWithInvalidType() {
        // This should theoretically not happen as types are controlled by constants,
        // but adding for coverage
        ftpFile.setType(999);

        // Act
        boolean result = ftpFile.isDirectory();

        // Assert
        assertFalse("File should not be a directory for an invalid type", result);
    }
}