package abstractTests;

import library.Book;
import library.activies.reading.Progression;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public abstract class AbstractTest {

    protected abstract Progression readTest(Book book, int timeUnits);

    @Test
    public void testReadingCreatesProgress() {
        assertNotNull(readTest(BookFactory.getBook(), 1));
    }

    @Test
    public void testReadingTransfersKnowledge() {
        assertNotSame(readTest(BookFactory.getSoftwareDevelopmentBook(), 10).getKnowledge(), 0.0);
    }

    @Test
    public void testReadingIsFun() {
        assertNotSame(readTest(BookFactory.getBook(), 10).getFun(), 0.0);
    }

}
