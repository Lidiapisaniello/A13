// FTPFile_setLinkTest.java
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
 * FTPFile#public setLink(String link) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_setLinkTest {

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
    public void testSetLink_ValidLink() {
        // Arrange
        String linkName = "linkToFile";
        
        // Act
        ftpFile.setLink(linkName);
        
        // Assert
        assertEquals("Link should be set to 'linkToFile'", "linkToFile", ftpFile.getLink());
    }

    @Test
    public void testSetLink_EmptyString() {
        // Arrange
        String linkName = "";
        
        // Act
        ftpFile.setLink(linkName);
        
        // Assert
        assertEquals("Link should be set to an empty string", "", ftpFile.getLink());
    }

    @Test
    public void testSetLink_NullLink() {
        // Act
        ftpFile.setLink(null);
        
        // Assert
        assertNull("Link should be null", ftpFile.getLink());
    }
    
    @Test
    public void testSetLink_WhiteSpaceLink() {
        // Arrange
        String linkName = "     ";
        
        // Act
        ftpFile.setLink(linkName);
        
        // Assert
        assertEquals("Link should be set to whitespace", "     ", ftpFile.getLink());
    }

    @Test
    public void testSetLink_SpecialCharactersLink() {
        // Arrange
        String linkName = "!@#$%^&*()_+";
        
        // Act
        ftpFile.setLink(linkName);
        
        // Assert
        assertEquals("Link should be set to '!@#$%^&*()_+'", "!@#$%^&*()_+", ftpFile.getLink());
    }

    
    @Test
    public void testSetLink_LinkUpdated() {
        // Arrange
        String initialLink = "initialLink";
        String updatedLink = "updatedLink";
        
        // Act
        ftpFile.setLink(initialLink);
        ftpFile.setLink(updatedLink);
        
        // Assert
        assertEquals("Link should be updated to 'updatedLink'", "updatedLink", ftpFile.getLink());
    }

    @Test
    public void testSetLink_UnicodeCharacters() {
        // Arrange
        String linkName = "文件链接";
        
        // Act
        ftpFile.setLink(linkName);
        
        // Assert
        assertEquals("Link should be set to '文件链接'", "文件链接", ftpFile.getLink());
    }

    @Test
    public void testSetLink_AssignTwice() {
        // Arrange
        String firstLink = "firstLink";
        String secondLink = "secondLink";

        // Act
        ftpFile.setLink(firstLink);
        ftpFile.setLink(secondLink);

        // Assert
        assertEquals("Link should be set to 'secondLink'", "secondLink", ftpFile.getLink());
    }

    @Test
    public void testSetLink_FormatChangeInLinkName() {
        // Arrange
        String linkName = "MyLink 123";
        
        // Act
        ftpFile.setLink(linkName);
        
        // Assert
        assertEquals("Link should preserve spaces and alphanumeric characters", "MyLink 123", ftpFile.getLink());
    }
}