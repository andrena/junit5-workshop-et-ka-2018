
package library.activies.reading;

import library.Book;

public class SmartReadingTest extends ReadingMethodTest {

	@Override
	protected Progression readTest(Book book, int timeUnits) {
		ReadingMethod readingMethod = new SmartReading(book);
		for (int usedTimeunits = 0; usedTimeunits < timeUnits; usedTimeunits++) {
			readingMethod.read();
		}
		return readingMethod.getProgession();
	}

}
