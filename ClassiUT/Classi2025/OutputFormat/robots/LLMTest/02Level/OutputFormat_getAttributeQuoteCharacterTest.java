// OutputFormat_getAttributeQuoteCharacterTest.java
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Test class of OutputFormat.
 * It contains 10 unit test cases for the
 * OutputFormat#public getAttributeQuoteCharacter() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class OutputFormat_getAttributeQuoteCharacterTest {
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
    public void testGetAttributeQuoteCharacter_InitialValue() {
        // Arrange
        // No need to arrange anything here because the initial value is what we expect

        // Act
        char actual = outputFormat.getAttributeQuoteCharacter();

        // Assert
        assertEquals('\"', actual); // Expect the default value to be \" (double quotes)
    }

    @Test
    public void testGetAttributeQuoteCharacter_SetToSingleQuotes() {
        // Arrange
        outputFormat.setAttributeQuoteCharacter('\'');

        // Act
        char actual = outputFormat.getAttributeQuoteCharacter();

        // Assert
        assertEquals('\'', actual); // Expect the value to be'(single quotes)
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAttributeQuoteCharacter_SetToInvalidCharacter() {
        // Arrange
        char invalidChar = '$'; // Invalid XML attribute quote character

        // Act & Assert
        outputFormat.setAttributeQuoteCharacter(invalidChar); // Should throw IllegalArgumentException
    }
}