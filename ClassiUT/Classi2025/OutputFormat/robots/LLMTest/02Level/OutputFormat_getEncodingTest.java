// OutputFormat_getEncodingTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public getEncoding() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_getEncodingTest {
    private OutputFormat outputFormat;

    @Before
    public void setUp() {
        outputFormat = new OutputFormat();
    }

    @After
    public void tearDown() {
        outputFormat = null;
    }

    @Test
    public void testGetEncoding_DefaultEncoding() {
        // Arrange
        String expectedEncoding = "UTF-8";
        
        // Act
        String actualEncoding = outputFormat.getEncoding();
        
        // Assert
        assertEquals(expectedEncoding, actualEncoding);
    }
    
    @Test
    public void testGetEncoding_SetCustomEncoding() {
        // Arrange
        String customEncoding = "ISO-8859-1";
        outputFormat.setEncoding(customEncoding);
        String expectedEncoding = customEncoding;
        
        // Act
        String actualEncoding = outputFormat.getEncoding();
        
        // Assert
        assertEquals(expectedEncoding, actualEncoding);
    }
    
    @Test
    public void testGetEncoding_EmptyEncoding() {
        // Arrange
        outputFormat.setEncoding("");
        String expectedEncoding = "";
        
        // Act
        String actualEncoding = outputFormat.getEncoding();
        
        // Assert
        assertEquals(expectedEncoding, actualEncoding);
    }
    
    
    
    
    @Test
    public void testGetEncoding_SpecialCharactersEncoding() {
        // Arrange
        String specialCharsEncoding = "!@#$%^&*()_+=-{}|\\:;'\"<>?";
        outputFormat.setEncoding(specialCharsEncoding);
        String expectedEncoding = specialCharsEncoding;
        
        // Act
        String actualEncoding = outputFormat.getEncoding();
        
        // Assert
        assertEquals(expectedEncoding, actualEncoding);
    }
    
    @Test
    public void testGetEncoding_MaxLengthEncoding() {
        // Arrange
        String maxLengthEncoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        outputFormat.setEncoding(maxLengthEncoding);
        String expectedEncoding = maxLengthEncoding;
        
        // Act
        String actualEncoding = outputFormat.getEncoding();
        
        // Assert
        assertEquals(expectedEncoding, actualEncoding);
    }
    
    @Test
    public void testGetEncoding_MinLengthEncoding() {
        // Arrange
        String minLengthEncoding = "a";
        outputFormat.setEncoding(minLengthEncoding);
        String expectedEncoding = minLengthEncoding;
        
        // Act
        String actualEncoding = outputFormat.getEncoding();
        
        // Assert
        assertEquals(expectedEncoding, actualEncoding);
    }
    
}