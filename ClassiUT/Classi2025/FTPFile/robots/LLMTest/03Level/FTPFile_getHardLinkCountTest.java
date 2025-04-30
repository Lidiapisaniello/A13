// FTPFile_getHardLinkCountTest.java
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
 * FTPFile#public getHardLinkCount() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_getHardLinkCountTest {

private FTPFile ftpFile;

    @Before
    public void setUp() {
        ftpFile = new FTPFile();
    }

    @After
    public void tearDown() {
        ftpFile = null;
    }

    // Test case 1: Verify default hard link count is 0
    @Test
    public void testDefaultHardLinkCount() {
        assertEquals("Default hard link count should be 0", 0, ftpFile.getHardLinkCount());
    }

    // Test case 2: Set hard link count to 1 and verify
    @Test
    public void testSetHardLinkCountToOne() {
        ftpFile.setHardLinkCount(1);
        assertEquals("Hard link count should be 1", 1, ftpFile.getHardLinkCount());
    }

    // Test case 3: Set a typical hard link count
    @Test
    public void testSetTypicalHardLinkCount() {
        ftpFile.setHardLinkCount(5);
        assertEquals("Hard link count should be 5", 5, ftpFile.getHardLinkCount());
    }

    // Test case 4: Set a large hard link count
    @Test
    public void testSetLargeHardLinkCount() {
        ftpFile.setHardLinkCount(1000);
        assertEquals("Hard link count should be 1000", 1000, ftpFile.getHardLinkCount());
    }

    // Test case 5: Set hard link count to a negative value, expecting it to store as is
    @Test
    public void testSetNegativeHardLinkCount() {
        ftpFile.setHardLinkCount(-1);
        assertEquals("Hard link count should be -1", -1, ftpFile.getHardLinkCount());
    }

    // Test case 6: Changing hard link count multiple times
    @Test
    public void testChangeHardLinkCountMultipleTimes() {
        ftpFile.setHardLinkCount(2);
        assertEquals("Hard link count should be 2", 2, ftpFile.getHardLinkCount());
        
        ftpFile.setHardLinkCount(3);
        assertEquals("Hard link count should be 3", 3, ftpFile.getHardLinkCount());

        ftpFile.setHardLinkCount(4);
        assertEquals("Hard link count should be 4", 4, ftpFile.getHardLinkCount());
    }

    // Test case 7: Checking hard link count with max integer value
    @Test
    public void testMaxIntegerHardLinkCount() {
        ftpFile.setHardLinkCount(Integer.MAX_VALUE);
        assertEquals("Hard link count should be Integer.MAX_VALUE", Integer.MAX_VALUE, ftpFile.getHardLinkCount());
    }

    // Test case 8: Verify hard link count after setting size, should remain unchanged
    @Test
    public void testHardLinkCountAfterSettingSize() {
        ftpFile.setSize(100);
        assertEquals("Hard link count should remain 0 after setting size", 0, ftpFile.getHardLinkCount());
    }

    // Test case 9: Verify hard link count after setting permissions, should remain unchanged
    @Test
    public void testHardLinkCountAfterSettingPermissions() {
        ftpFile.setPermission(FTPFile.USER_ACCESS, FTPFile.READ_PERMISSION, true);
        assertEquals("Hard link count should remain 0 after setting permissions", 0, ftpFile.getHardLinkCount());
    }

    // Test case 10: Verify hard link count after setting type, should remain unchanged
    @Test
    public void testHardLinkCountAfterSettingType() {
        ftpFile.setType(FTPFile.DIRECTORY_TYPE);
        assertEquals("Hard link count should remain 0 after setting type", 0, ftpFile.getHardLinkCount());
    }
}