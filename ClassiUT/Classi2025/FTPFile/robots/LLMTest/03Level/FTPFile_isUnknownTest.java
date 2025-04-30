// FTPFile_isUnknownTest.java
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
 * FTPFile#public isUnknown() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_isUnknownTest {


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
    public void testIsUnknownInitially() {
        // Initially, the file type should be UNKNOWN_TYPE
        assertTrue("File type should initially be unknown", file.isUnknown());
    }

    @Test
    public void testIsUnknownAfterSetTypeToFile() {
        // Set the file type to FILE_TYPE
        file.setType(FTPFile.FILE_TYPE);
        assertFalse("File type should not be unknown", file.isUnknown());
    }

    @Test
    public void testIsUnknownAfterSetTypeToDirectory() {
        // Set the file type to DIRECTORY_TYPE
        file.setType(FTPFile.DIRECTORY_TYPE);
        assertFalse("File type should not be unknown", file.isUnknown());
    }

    @Test
    public void testIsUnknownAfterSetTypeToSymbolicLink() {
        // Set the file type to SYMBOLIC_LINK_TYPE
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        assertFalse("File type should not be unknown", file.isUnknown());
    }

    @Test
    public void testIsUnknownAfterSetTypeToUnknown() {
        // Set the file type to UNKNOWN_TYPE
        file.setType(FTPFile.UNKNOWN_TYPE);
        assertTrue("File type should be unknown", file.isUnknown());
    }

    @Test
    public void testMultipleTypeChanges() {
        // Change file type multiple times
        file.setType(FTPFile.FILE_TYPE);
        assertFalse("File type should not be unknown", file.isUnknown());
        file.setType(FTPFile.DIRECTORY_TYPE);
        assertFalse("File type should not be unknown", file.isUnknown());
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        assertFalse("File type should not be unknown", file.isUnknown());
        file.setType(FTPFile.UNKNOWN_TYPE);
        assertTrue("File type should be unknown", file.isUnknown());
    }


    @Test
    public void testTypeConsistencyAfterModification() {
        // Set a valid type and then change it back to unknown
        file.setType(FTPFile.FILE_TYPE);
        assertFalse("File type should not be unknown", file.isUnknown());
        file.setType(FTPFile.UNKNOWN_TYPE);
        assertTrue("File type should be unknown", file.isUnknown());
    }
}