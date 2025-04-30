// FTPFile_setSizeTest.java
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
 * FTPFile#public setSize(long size) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_setSizeTest {

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
    public void testSetSizePositive() {
        // Arrange
        long expectedSize = 1024L;

        // Act
        ftpFile.setSize(expectedSize);

        // Assert
        assertEquals(expectedSize, ftpFile.getSize());
    }

    @Test
    public void testSetSizeZero() {
        // Arrange
        long expectedSize = 0L;

        // Act
        ftpFile.setSize(expectedSize);

        // Assert
        assertEquals(expectedSize, ftpFile.getSize());
    }

    @Test
    public void testSetSizeNegative() {
        // Arrange
        long expectedSize = -1L;

        // Act
        ftpFile.setSize(expectedSize);

        // Assert
        assertEquals(expectedSize, ftpFile.getSize());
    }

    @Test
    public void testSetSizeMaxLong() {
        // Arrange
        long expectedSize = Long.MAX_VALUE;

        // Act
        ftpFile.setSize(expectedSize);

        // Assert
        assertEquals(expectedSize, ftpFile.getSize());
    }

    @Test
    public void testSetSizeMinLong() {
        // Arrange
        long expectedSize = Long.MIN_VALUE;

        // Act
        ftpFile.setSize(expectedSize);

        // Assert
        assertEquals(expectedSize, ftpFile.getSize());
    }

    @Test
    public void testSetSizeAfterModification() {
        // Arrange
        long initialSize = 500L;
        long newSize = 1000L;

        // Act
        ftpFile.setSize(initialSize);
        ftpFile.setSize(newSize);

        // Assert
        assertEquals(newSize, ftpFile.getSize());
    }

    @Test
    public void testSetSizeEqualsInitial() {
        // Arrange
        long setSize = 2048L;

        // Act
        ftpFile.setSize(setSize);
        long resultSize = ftpFile.getSize();

        // Assert
        assertEquals(setSize, resultSize);
    }

    @Test
    public void testSetSizeWithoutExplicitSetting() {
        // Arrange
        long expectedSize = -1L; // Default initial size

        // Act & Assert
        assertEquals(expectedSize, ftpFile.getSize());
    }

    @Test
    public void testSetSizeMultipleTimes() {
        // Arrange
        long firstSize = 100L;
        long secondSize = 200L;
        long thirdSize = 300L;

        // Act
        ftpFile.setSize(firstSize);
        ftpFile.setSize(secondSize);
        ftpFile.setSize(thirdSize);

        // Assert
        assertEquals(thirdSize, ftpFile.getSize());
    }

    @Test
    public void testSetSizeWithSameValueMultipleTimes() {
        // Arrange
        long size = 640L;

        // Act
        ftpFile.setSize(size);
        ftpFile.setSize(size);
        ftpFile.setSize(size);

        // Assert
        assertEquals(size, ftpFile.getSize());
    }
}