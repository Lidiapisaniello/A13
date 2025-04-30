import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Calendar;
import java.util.TimeZone;

public class FTPFileTest {

    @Test
    public void constructorNoArgsTest() {
        FTPFile file = new FTPFile();
        assertEquals("", file.getUser());
        assertEquals("", file.getGroup());
        assertNull(file.getTimestamp());
        assertNull(file.getName());
        assertEquals(FTPFile.UNKNOWN_TYPE, file.getType());
        assertEquals(-1, file.getSize());
        assertEquals(0, file.getHardLinkCount());
        assertTrue(file.isValid());
    }

    @Test
    public void constructorWithRawListingTest() {
        FTPFile file = new FTPFile("raw_listing");
        assertEquals("raw_listing", file.getRawListing());
        assertFalse(file.isValid());
    }

    @Test
    public void setTypeFileTypeTest() {
        FTPFile file = new FTPFile();
        file.setType(FTPFile.FILE_TYPE);
        assertTrue(file.isFile());
        assertFalse(file.isDirectory());
        assertFalse(file.isSymbolicLink());
        assertFalse(file.isUnknown());
    }

    @Test
    public void setTypeDirectoryTypeTest() {
        FTPFile file = new FTPFile();
        file.setType(FTPFile.DIRECTORY_TYPE);
        assertTrue(file.isDirectory());
        assertFalse(file.isFile());
        assertFalse(file.isSymbolicLink());
        assertFalse(file.isUnknown());
    }

    @Test
    public void setTypeSymbolicLinkTypeTest() {
        FTPFile file = new FTPFile();
        file.setType(FTPFile.SYMBOLIC_LINK_TYPE);
        assertTrue(file.isSymbolicLink());
        assertFalse(file.isFile());
        assertFalse(file.isDirectory());
        assertFalse(file.isUnknown());
    }

    @Test
    public void setTypeUnknownTest() {
        FTPFile file = new FTPFile();
        file.setType(FTPFile.UNKNOWN_TYPE);
        assertTrue(file.isUnknown());
        assertFalse(file.isFile());
        assertFalse(file.isDirectory());
        assertFalse(file.isSymbolicLink());
    }

    @Test
    public void setNameTest() {
        FTPFile file = new FTPFile();
        file.setName("example.txt");
        assertEquals("example.txt", file.getName());
    }

    @Test
    public void setSizeTest() {
        FTPFile file = new FTPFile();
        file.setSize(1024);
        assertEquals(1024, file.getSize());
    }

    @Test
    public void setHardLinkCountTest() {
        FTPFile file = new FTPFile();
        file.setHardLinkCount(3);
        assertEquals(3, file.getHardLinkCount());
    }

    @Test
    public void setGroupTest() {
        FTPFile file = new FTPFile();
        file.setGroup("group1");
        assertEquals("group1", file.getGroup());
    }

    @Test
    public void setUserTest() {
        FTPFile file = new FTPFile();
        file.setUser("user1");
        assertEquals("user1", file.getUser());
    }

    @Test
    public void setLinkTest() {
        FTPFile file = new FTPFile();
        file.setLink("link.txt");
        assertEquals("link.txt", file.getLink());
    }

    @Test
    public void setRawListingTest() {
        FTPFile file = new FTPFile();
        file.setRawListing("new raw listing");
        assertEquals("new raw listing", file.getRawListing());
    }

    @Test
    public void setTimestampTest() {
        FTPFile file = new FTPFile();
        Calendar calendar = Calendar.getInstance();
        file.setTimestamp(calendar);
        assertEquals(calendar, file.getTimestamp());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setPermissionOutOfBoundsTest() {
        FTPFile file = new FTPFile();
        file.setPermission(3, FTPFile.READ_PERMISSION, true);
    }

    @Test
    public void hasPermissionTest() {
        FTPFile file = new FTPFile();
        file.setPermission(FTPFile.USER_ACCESS, FTPFile.READ_PERMISSION, true);
        assertTrue(file.hasPermission(FTPFile.USER_ACCESS, FTPFile.READ_PERMISSION));
    }

    @Test
    public void hasPermissionInvalidTest() {
        FTPFile file = new FTPFile();
        assertFalse(file.hasPermission(FTPFile.USER_ACCESS, FTPFile.READ_PERMISSION));
    }

    @Test
    public void toStringTest() {
        FTPFile file = new FTPFile("raw listing for toString");
        assertEquals("raw listing for toString", file.toString());
    }

    @Test
    public void toFormattedStringInvalidTest() {
        FTPFile file = new FTPFile("raw listing for toFormattedString");
        assertEquals("[Invalid: could not parse file entry]", file.toFormattedString());
    }

}