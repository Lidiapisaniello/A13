// FTPFile_setUserTest.java
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
 * FTPFile#public setUser(String user) method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_setUserTest {

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
    public void testSetUserWithValidUser() {
        // Arrange
        String expectedUser = "john";

        // Act
        ftpFile.setUser(expectedUser);

        // Assert
        assertEquals(expectedUser, ftpFile.getUser());
    }

    @Test
    public void testSetUserWithEmptyString() {
        // Arrange
        String expectedUser = "";

        // Act
        ftpFile.setUser(expectedUser);

        // Assert
        assertEquals(expectedUser, ftpFile.getUser());
    }

    @Test
    public void testSetUserWithNull() {
        // Arrange
        String expectedUser = null;

        // Act
        ftpFile.setUser(expectedUser);

        // Assert
        assertEquals(expectedUser, ftpFile.getUser());
    }

    @Test
    public void testSetUserTwiceUpdatesUser() {
        // Arrange
        String firstUser = "john";
        String secondUser = "doe";

        // Act
        ftpFile.setUser(firstUser);
        ftpFile.setUser(secondUser);

        // Assert
        assertEquals(secondUser, ftpFile.getUser());
    }

    @Test
    public void testSetUserWithSpecialCharacters() {
        // Arrange
        String expectedUser = "john_doe@123";

        // Act
        ftpFile.setUser(expectedUser);

        // Assert
        assertEquals(expectedUser, ftpFile.getUser());
    }

    @Test
    public void testSetUserWithSpaces() {
        // Arrange
        String expectedUser = "john doe";

        // Act
        ftpFile.setUser(expectedUser);

        // Assert
        assertEquals(expectedUser, ftpFile.getUser());
    }

    @Test
    public void testSetUserWithLongString() {
        // Arrange
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("user");
        }
        String expectedUser = sb.toString();

        // Act
        ftpFile.setUser(expectedUser);

        // Assert
        assertEquals(expectedUser, ftpFile.getUser());
    }


    @Test
    public void testSetUserAfterInvalidCreation() {
        // Arrange
        FTPFile invalidFile = new FTPFile("Invalid raw listing");
        String expectedUser = "john";

        // Act
        invalidFile.setUser(expectedUser);

        // Assert
        assertEquals(expectedUser, invalidFile.getUser());
    }

    @Test
    public void testSetUserDoesNotAffectOtherAttributes() {
        // Arrange
        String expectedUser = "john";
        ftpFile.setName("file.txt");

        // Act
        ftpFile.setUser(expectedUser);

        // Assert
        assertEquals(expectedUser, ftpFile.getUser());
        assertEquals("file.txt", ftpFile.getName());
    }
}