// FTPFile_getLinkTest.java

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// FTPFile_getLinkTest.java
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
 * FTPFile#public getLink() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_getLinkTest {


    private FTPFile file;

    @Before
    public void setUp() {
        file = new FTPFile();
    }

    @Test
    public void testGetLinkWhenNotALink() {
        // Arrange
        file.setType(FTPFile.FILE_TYPE);

        // Act
        String link = file.getLink();

        // Assert
        assertNull("Expected null when file is not a symbolic link", link);
    }

    @Test
    public void testGetLinkWhenDirectory() {
        // Arrange
        file.setType(FTPFile.DIRECTORY_TYPE);

        // Act
        String link = file.getLink();

        // Assert
        assertNull("Expected null when file is a directory", link);
    }

    @Test
    public void testGetLinkWhenUnknownType() {
        // Arrange
        file.setType(FTPFile.UNKNOWN_TYPE);

        // Act
        String link = file.getLink();

        // Assert
        assertNull("Expected null when file type is unknown", link);
    }

    @Test
    public void testGetLinkWhenSymbolicLinkWithoutTarget() {
        // Arrange
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);

        // Act
        String link = file.getLink();

        // Assert
        assertNull("Expected null when symbolic link has no target set", link);
    }

    @Test
    public void testGetLinkWhenSymbolicLinkWithTarget() {
        // Arrange
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        String expectedLink = "targetFile.txt";
        file.setLink(expectedLink);

        // Act
        String link = file.getLink();

        // Assert
        assertEquals("Expected link to match the set target", expectedLink, link);
    }

    @Test
    public void testGetLinkWithEmptyLinkName() {
        // Arrange
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        file.setLink("");

        // Act
        String link = file.getLink();

        // Assert
        assertEquals("Expected empty string when symbolic link has an empty target", "", link);
    }

    @Test
    public void testGetLinkWithNullLinkTypeInitially() {
        // Arrange
        assertNull("Expected null when link type and link are not set", file.getLink());
    }

    @Test
    public void testGetLinkAfterChangingFromFileToLink() {
        // Arrange
        file.setType(FTPFile.FILE_TYPE);
        file.setLink(null);  // initially set to file
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        String expectedLink = "newTargetFile.txt";
        file.setLink(expectedLink);

        // Act
        String link = file.getLink();

        // Assert
        assertEquals("Expected link after type change to SYMBOLIC_LINK_TYPE", expectedLink, link);
    }

    @Test
    public void testGetLinkWhenLinkSetToNull() {
        // Arrange
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        file.setLink(null);

        // Act
        String link = file.getLink();

        // Assert
        assertNull("Expected null when symbolic link target is explicitly set to null", link);
    }

    @Test
    public void testGetLinkAcrossMultipleLinkResets() {
        // Arrange
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        file.setLink("initialTarget.txt");
        file.setLink("resetTarget.txt");

        // Act
        String link = file.getLink();

        // Assert
        assertEquals("Expected latest link after multiple resets", "resetTarget.txt", link);
    }
}