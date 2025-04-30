// FTPFile_getTimestampTest.java
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
 * FTPFile#public getTimestamp() method.
 * Follow the Arrange-Act-Assert pattern and cover typical and edge cases. 
 * Contains only valid Java code.  
 */
public class FTPFile_getTimestampTest {

private FTPFile ftpFile;
    private Calendar expectedTimestamp;
    
    @Before
    public void setUp() {
        ftpFile = new FTPFile();
        expectedTimestamp = Calendar.getInstance();
    }

    @After
    public void tearDown() {
        ftpFile = null;
        expectedTimestamp = null;
    }

    @Test
    public void testGetTimestamp_DefaultValue() {
        assertNull("Initially, timestamp should be null", ftpFile.getTimestamp());
    }

    @Test
    public void testGetTimestamp_SetAndGetValue() {
        ftpFile.setTimestamp(expectedTimestamp);
        assertEquals("Timestamp retrieved should match the set value", expectedTimestamp, ftpFile.getTimestamp());
    }


    @Test
    public void testGetTimestamp_NullTimestamp() {
        ftpFile.setTimestamp(null);
        assertNull("Timestamp should be null when explicitly set to null", ftpFile.getTimestamp());
    }

    @Test
    public void testGetTimestamp_SetTimestampTwice() {
        Calendar newTimestamp = Calendar.getInstance();
        newTimestamp.add(Calendar.YEAR, -1);
        ftpFile.setTimestamp(expectedTimestamp);
        ftpFile.setTimestamp(newTimestamp);
        assertEquals("Timestamp should reflect the last set value", newTimestamp, ftpFile.getTimestamp());
    }

    @Test
    public void testGetTimestamp_LeapYearDay() {
        Calendar leapDay = Calendar.getInstance();
        leapDay.set(2020, Calendar.FEBRUARY, 29);
        ftpFile.setTimestamp(leapDay);
        assertEquals("Timestamp should correctly handle leap day", leapDay, ftpFile.getTimestamp());
    }

    @Test
    public void testGetTimestamp_EndOfYear() {
        Calendar endOfYear = Calendar.getInstance();
        endOfYear.set(2021, Calendar.DECEMBER, 31, 23, 59, 59);
        ftpFile.setTimestamp(endOfYear);
        assertEquals("Timestamp should correctly handle end of the year", endOfYear, ftpFile.getTimestamp());
    }

    @Test
    public void testGetTimestamp_EarlyUnixTime() {
        Calendar earlyUnixTime = Calendar.getInstance();
        earlyUnixTime.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
        ftpFile.setTimestamp(earlyUnixTime);
        assertEquals("Timestamp should correctly represent Unix epoch start", earlyUnixTime, ftpFile.getTimestamp());
    }

    @Test
    public void testGetTimestamp_CurrentTime() {
        Calendar currentTime = Calendar.getInstance();
        ftpFile.setTimestamp(currentTime);
        assertEquals("Timestamp should set and get current time correctly", currentTime, ftpFile.getTimestamp());
    }

    @Test
    public void testGetTimestamp_LargeYearValue() {
        Calendar largeYear = Calendar.getInstance();
        largeYear.set(9999, Calendar.DECEMBER, 31, 23, 59, 59);
        ftpFile.setTimestamp(largeYear);
        assertEquals("Timestamp should handle large year values correctly", largeYear, ftpFile.getTimestamp());
    }
}