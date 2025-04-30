// OutputFormat_isNewLineAfterDeclarationTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public isNewLineAfterDeclaration() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_isNewLineAfterDeclarationTest {
    
    private OutputFormat outputFormatUnderTest;

    @Before
    public void setUp() {
        outputFormatUnderTest = new OutputFormat();
    }

    @After
    public void tearDown() {
        outputFormatUnderTest = null;
    }

    @Test
    public void testIsNewLineAfterDeclaration_WhenDefaultConstructorCalled_ReturnsTrue() {
        // Arrange
        boolean expected = true;
        
        // Act
        boolean actual = outputFormatUnderTest.isNewLineAfterDeclaration();
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testIsNewLineAfterDeclaration_WhenSetToFalseCalled_ReturnsFalse() {
        // Arrange
        outputFormatUnderTest.setNewLineAfterDeclaration(false);
        boolean expected = false;
        
        // Act
        boolean actual = outputFormatUnderTest.isNewLineAfterDeclaration();
        
        // Assert
        assertEquals(expected, actual);
    }
    
    @Test
    public void testIsNewLineAfterDeclaration_WhenSetToTrueCalled_ReturnsTrue() {
        // Arrange
        outputFormatUnderTest.setNewLineAfterDeclaration(true);
        boolean expected = true;
        
        // Act
        boolean actual = outputFormatUnderTest.isNewLineAfterDeclaration();
        
        // Assert
        assertEquals(expected, actual);
    }
    
    
    
    
    
    
}