import org.junit.Test;
import static org.junit.Assert.*;

public class FTPFileTest {


    @Test
    public void testConstructorFailedParse() {
        FTPFile ftpFile = new FTPFile("invalid line");
        assertFalse(ftpFile.isValid());
        assertEquals("invalid line", ftpFile.getRawListing());
        assertNull(ftpFile.getName());
        assertEquals(-1, ftpFile.getSize());
        assertEquals(0, ftpFile.getHardLinkCount());
        assertEquals("", ftpFile.getUser());
        assertEquals("", ftpFile.getGroup());
        assertNull(ftpFile.getTimestamp());
    }
}