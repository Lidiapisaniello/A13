// FTPFile_getRawListingTest.java
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
 * FTPFile#public getRawListing() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_getRawListingTest {


    private FTPFile file;

    @Before
    public void setUp() throws Exception {
        file = new FTPFile();
    }

    @After
    public void tearDown() throws Exception {
        file = null;
    }

    @Test
    public void testGetRawListing_Default() {
        // Arrange
        String expected = null;

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetRawListing_SetRawListing() {
        // Arrange
        String expected = "drwxr-xr-x  2 user group 4096 Jan 01 00:00 testFolder";
        file.setRawListing(expected);

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetRawListing_EmptyRawListing() {
        // Arrange
        String expected = "";
        file.setRawListing(expected);

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetRawListing_NullRawListing() {
        // Arrange
        String expected = null;
        file.setRawListing(expected);

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetRawListing_LongRawListing() {
        // Arrange
        String expected = "rw-r--r-- 1 user group 1024 Jul 23 15:31 veryLongFileNameThatCouldPossiblyExistInSomeCase.txt";
        file.setRawListing(expected);

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetRawListing_SpecialCharacters() {
        // Arrange
        String expected = "-rw-r--r-- 1 user group 1234 Apr 12 12:12 special!@#$%^&*()_+[];'./=<>?:\"{}|`~ chars.txt";
        file.setRawListing(expected);

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetRawListing_WhiteSpaceOnly() {
        // Arrange
        String expected = "   ";
        file.setRawListing(expected);

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetRawListing_ComplexListing() {
        // Arrange
        String expected = "lrwxrwxrwx 1 user group 11 Dec 12 12:00 link -> /some/path";
        file.setRawListing(expected);

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetRawListing_MultipleSetRawListing() {
        // Arrange
        String firstListing = "-rw-r--r-- 1 user group 1234 Apr 12 12:12 first.txt";
        String secondListing = "-rw-r--r-- 1 user group 5678 May 20 08:00 second.txt";
        file.setRawListing(firstListing);
        file.setRawListing(secondListing);

        // Act
        String result = file.getRawListing();

        // Assert
        assertEquals(secondListing, result);
    }

    @Test
    public void testGetRawListing_CheckNonSet() {
        // Act
        String result = file.getRawListing();

        // Assert
        assertNull("Expected null as the default raw listing should not be set.", result);
    }
}