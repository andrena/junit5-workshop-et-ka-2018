package abstractTests;

import common.BookFactory;
import library.Book;
import library.activies.reading.Progression;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public abstract class ReadingMethodTest {

    protected abstract Progression readTest(Book book, int timeUnits);

    @Test
    public void testReadingCreatesProgress() {
        assertNotNull(readTest(BookFactory.getBook(), 1));
    }

    @Test
    public void testReadingTransfersKnowledge() {
        assertNotNull(readTest(BookFactory.getSoftwareDevelopmentBook(), 10).getKnowledge());
    }

    @Test
    public void testReadingIsFun() {
        assertNotNull(readTest(BookFactory.getBook(), 10).getFun());
    }

}
