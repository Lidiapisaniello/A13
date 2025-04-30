// FTPFile_getUserTest.java
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
 * FTPFile#public getUser() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_getUserTest {


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
    public void testGetUserWhenUserIsSet() {
        // Arrange
        String expectedUser = "testUser";
        ftpFile.setUser(expectedUser);
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGetUserWhenUserIsNotSet() {
        // Arrange
        String expectedUser = "";
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGetUserAfterClearingUser() {
        // Arrange
        String initialUser = "testUser";
        ftpFile.setUser(initialUser);
        ftpFile.setUser("");
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertEquals("", actualUser);
    }

    @Test
    public void testGetUserWithNullValue() {
        // Arrange
        ftpFile.setUser(null);
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertNull(actualUser);
    }

    @Test
    public void testGetUserWithWhiteSpace() {
        // Arrange
        String expectedUser = "  ";
        ftpFile.setUser(expectedUser);
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGetUserWithSpecialCharacters() {
        // Arrange
        String expectedUser = "@dmin123!";
        ftpFile.setUser(expectedUser);
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGetUserWithLongString() {
        // Arrange
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("user");
        }
        String expectedUser = sb.toString();
        ftpFile.setUser(expectedUser);
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGetUserPersistenceAcrossInstances() {
        // Arrange
        ftpFile.setUser("PersistentUser");
        FTPFile anotherFile = new FTPFile();
        
        // Act
        String actualUserInNewInstance = anotherFile.getUser();
        
        // Assert
        assertEquals("", actualUserInNewInstance);
    }

    @Test
    public void testGetUserSetMultipleTimes() {
        // Arrange
        ftpFile.setUser("FirstUser");
        ftpFile.setUser("SecondUser");
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertEquals("SecondUser", actualUser);
    }

    @Test
    public void testGetUserAfterSettingAndClearing() {
        // Arrange
        ftpFile.setUser("SampleUser");
        ftpFile.setUser(null);
        
        // Act
        String actualUser = ftpFile.getUser();
        
        // Assert
        assertNull(actualUser);
    }
}