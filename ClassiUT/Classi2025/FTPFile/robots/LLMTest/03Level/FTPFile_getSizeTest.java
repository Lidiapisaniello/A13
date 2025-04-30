// FTPFile_getSizeTest.java
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
 * FTPFile#public getSize() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_getSizeTest {

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
    public void testGetSizeInitiallyNegOne() {
        long size = ftpFile.getSize();
        assertEquals(-1L, size);
    }
    @Test
    public void testSetSizeAndGetSize() {
        long expectedSize = 1024L;
        ftpFile.setSize(expectedSize);
        long actualSize = ftpFile.getSize();
        assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testSetZeroSize() {
        long expectedSize = 0L;
        ftpFile.setSize(expectedSize);
        long actualSize = ftpFile.getSize();
        assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testSetNegativeSize() {
        long expectedSize = -500L;
        ftpFile.setSize(expectedSize);
        long actualSize = ftpFile.getSize();
        assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testSetLargeSize() {
        long expectedSize = Long.MAX_VALUE;
        ftpFile.setSize(expectedSize);
        long actualSize = ftpFile.getSize();
        assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testSetVeryLargeSize() {
        long expectedSize = Long.parseLong("98765432101234567");
        ftpFile.setSize(expectedSize);
        long actualSize = ftpFile.getSize();
        assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testSetSizeMultipleTimes() {
        long firstSize = 100L;
        long secondSize = 500L;
        ftpFile.setSize(firstSize);
        ftpFile.setSize(secondSize);
        long actualSize = ftpFile.getSize();
        assertEquals(secondSize, actualSize);
    }
    @Test
    public void testSetSizeAfterInitialization() {
        ftpFile = new FTPFile("dummy listing");
        long expectedSize = 4096L;
        ftpFile.setSize(expectedSize);
        long actualSize = ftpFile.getSize();
        assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testGetSizeAfterSetName() {
        String fileName = "example.txt";
        long expectedSize = 2048L;
        ftpFile.setName(fileName);
        ftpFile.setSize(expectedSize);
        long actualSize = ftpFile.getSize();
        assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testGetSizeAfterSetTimestamp() {
        Calendar timestamp = Calendar.getInstance();
        long expectedSize = 65536L;
        ftpFile.setTimestamp(timestamp);
        ftpFile.setSize(expectedSize);
        long actualSize = ftpFile.getSize();
        assertEquals(expectedSize, actualSize);
    }
}