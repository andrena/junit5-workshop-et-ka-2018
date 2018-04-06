package library.activies.reading;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import common.BookFactory;
import library.Book;

public abstract class ReadingMethodTest {

	protected abstract Progression readTest(Book book, int timeUnits);

	@Test
	public void testReadingCreatesProgress() throws Exception {
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
