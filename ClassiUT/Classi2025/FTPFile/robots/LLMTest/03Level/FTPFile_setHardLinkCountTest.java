// FTPFile_setHardLinkCountTest.java
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
 * FTPFile#public setHardLinkCount(int links) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_setHardLinkCountTest {

private FTPFile file;

    @Before
    public void setUp() {
        file = new FTPFile();
    }

    @After
    public void tearDown() {
        file = null;
    }

    @Test
    public void testSetHardLinkCountPositive() {
        // Arrange
        int links = 5;

        // Act
        file.setHardLinkCount(links);

        // Assert
        assertEquals("Hard Link Count should be set to 5", 5, file.getHardLinkCount());
    }

    @Test
    public void testSetHardLinkCountZero() {
        // Arrange
        int links = 0;

        // Act
        file.setHardLinkCount(links);

        // Assert
        assertEquals("Hard Link Count should be set to 0", 0, file.getHardLinkCount());
    }

    @Test
    public void testSetHardLinkCountNegative() {
        // Arrange
        int links = -1;

        // Act
        file.setHardLinkCount(links);

        // Assert
        assertEquals("Hard Link Count should be set to -1", -1, file.getHardLinkCount());
    }

    @Test
    public void testSetHardLinkCountMultipleTimes() {
        // Arrange
        int firstLinks = 2;
        int secondLinks = 7;

        // Act
        file.setHardLinkCount(firstLinks);
        file.setHardLinkCount(secondLinks);

        // Assert
        assertEquals("Hard Link Count should be updated to 7", 7, file.getHardLinkCount());
    }

    @Test
    public void testSetHardLinkCountThenCheckDefault() {
        // Arrange
        int links = 3;

        // Act
        file.setHardLinkCount(links);

        // Assert
        assertNotEquals("Hard Link Count default should not be -1 after being set", -1, file.getHardLinkCount());
    }

    @Test
    public void testHardLinkCountInitialValue() {
        // Assert
        assertEquals("Initial hard link count should be 0", 0, file.getHardLinkCount());
    }

    @Test
    public void testSetHardLinkCountMaxInteger() {
        // Arrange
        int links = Integer.MAX_VALUE;

        // Act
        file.setHardLinkCount(links);

        // Assert
        assertEquals("Hard Link Count should be set to Integer.MAX_VALUE", Integer.MAX_VALUE, file.getHardLinkCount());
    }

    @Test
    public void testSetHardLinkCountMinInteger() {
        // Arrange
        int links = Integer.MIN_VALUE;

        // Act
        file.setHardLinkCount(links);

        // Assert
        assertEquals("Hard Link Count should be set to Integer.MIN_VALUE", Integer.MIN_VALUE, file.getHardLinkCount());
    }

    @Test
    public void testSetHardLinkCountAfterOtherProperties() {
        // Arrange
        file.setName("example.txt");
        file.setSize(1024);
        int links = 4;

        // Act
        file.setHardLinkCount(links);

        // Assert
        assertEquals("Hard Link Count should be set to 4 despite other properties being set", 4, file.getHardLinkCount());
    }

    @Test
    public void testSetHardLinkCountType() {
        // Arrange
        int links = 1;

        // Act
        file.setHardLinkCount(links);

        // Assert
        assertTrue("Hard Link Count should be set as integer", Integer.class.isInstance(file.getHardLinkCount()));
    }
}