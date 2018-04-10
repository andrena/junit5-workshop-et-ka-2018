
package library.activies.reading;

import library.Book;

public class FunReadingTest extends ReadingMethodTest {

	@Override
	protected Progression readTest(Book book, int timeUnits) {
		ReadingMethod readingMethod = new FunReading(book);
		for (int usedTimeunits = 0; usedTimeunits < timeUnits; usedTimeunits++) {
			readingMethod.read();
		}
		return readingMethod.getProgession();
	}

}
