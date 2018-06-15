package abstractTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import library.Book;
import library.activies.reading.Progression;

public interface ReadingMethodContract {

	Progression readTest(Book book, int timeUnits);

    @Test
	public default void testReadingCreatesProgress() {
		assertThat(readTest(BookFactory.getBook(), 1)).isNotNull();
    }

    @Test
	public default void testReadingTransfersKnowledge() {
		assertThat(readTest(BookFactory.getSoftwareDevelopmentBook(), 10).getKnowledge()).isNotNull();
    }

    @Test
	public default void testReadingIsFun() {
		assertThat(readTest(BookFactory.getBook(), 10).getFun()).isNotNull();
    }

}
