// FTPFile_toStringTest.java
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
 * FTPFile#public toString() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_toStringTest {

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
    public void testToStringEmptyFile() {
        // Arrange
        ftpFile.setRawListing("");
        
        // Act
        String result = ftpFile.toString();
        
        // Assert
        assertEquals("", result);
    }

    @Test
    public void testToStringValidRawListing() {
        // Arrange
        String rawListing = "-rw-r--r-- 1 user group 1234 Jan 1 12:00 file.txt";
        ftpFile.setRawListing(rawListing);
        
        // Act
        String result = ftpFile.toString();
        
        // Assert
        assertEquals(rawListing, result);
    }

    @Test
    public void testToStringInvalidEntry() {
        // Arrange
        ftpFile = new FTPFile("invalid entry");
        
        // Act
        String result = ftpFile.toString();
        
        // Assert
        assertEquals("invalid entry", result);
    }

    @Test
    public void testToStringDirectoryType() {
        // Arrange
        ftpFile.setType(FTPFile.DIRECTORY_TYPE);
        ftpFile.setRawListing("drwxr-xr-x 7 user group 4096 Jan 1 12:00 directory");
        
        // Act
        String result = ftpFile.toString();
        
        // Assert
        assertEquals("drwxr-xr-x 7 user group 4096 Jan 1 12:00 directory", result);
    }

    @Test
    public void testToStringFileType() {
        // Arrange
        ftpFile.setType(FTPFile.FILE_TYPE);
        ftpFile.setRawListing("-rw-r--r-- 1 user group 1234 Jan 1 12:00 file.txt");
        
        // Act
        String result = ftpFile.toString();
        
        // Assert
        assertEquals("-rw-r--r-- 1 user group 1234 Jan 1 12:00 file.txt", result);
    }

    @Test
    public void testToStringSymbolicLinkType() {
        // Arrange
        ftpFile.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        ftpFile.setRawListing("lrwxrwxrwx 1 user group 9 Jan 1 12:00 link -> target");
        
        // Act
        String result = ftpFile.toString();
        
        // Assert
        assertEquals("lrwxrwxrwx 1 user group 9 Jan 1 12:00 link -> target", result);
    }

    @Test
    public void testToStringUnknownType() {
        // Arrange
        ftpFile.setType(FTPFile.UNKNOWN_TYPE);
        ftpFile.setRawListing("?rw-r--r-- 1 user group 1234 Jan 1 12:00 unknown");
        
        // Act
        String result = ftpFile.toString();
        
        // Assert
        assertEquals("?rw-r--r-- 1 user group 1234 Jan 1 12:00 unknown", result);
    }

    @Test
    public void testToStringWithPermissions() {
        // Arrange
        ftpFile.setType(FTPFile.FILE_TYPE);
        ftpFile.setRawListing("-rw-r--r-- 1 user group 1234 Jan 1 12:00 file.txt");
        ftpFile.setPermission(FTPFile.USER_ACCESS, FTPFile.READ_PERMISSION, true);
        ftpFile.setPermission(FTPFile.USER_ACCESS, FTPFile.WRITE_PERMISSION, true);
        ftpFile.setPermission(FTPFile.USER_ACCESS, FTPFile.EXECUTE_PERMISSION, false);
        
        // Act
        String result = ftpFile.toString();
        
        // Assert
        assertEquals("-rw-r--r-- 1 user group 1234 Jan 1 12:00 file.txt", result);
    }

    @Test
    public void testToStringWithInvalidPermissions() {
        // Arrange
        ftpFile.setRawListing(null);

        // Act
        String result = ftpFile.toString();

        // Assert
        assertEquals(null, result);
    }

    @Test
    public void testToStringWithEmptyTimestamp() {
        // Arrange
        ftpFile.setRawListing("empty_timestamp");

        // Act
        String result = ftpFile.toString();

        // Assert
        assertEquals("empty_timestamp", result);
    }
}