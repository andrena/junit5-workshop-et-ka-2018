package abstractTests;

import library.Book;
import library.activies.reading.FunReading;
import library.activies.reading.Progression;
import library.activies.reading.ReadingMethod;

public class FunAbstractTest implements ReadingMethodContract {

    @Override
	public Progression readTest(Book book, int timeUnits) {
        ReadingMethod readingMethod = new FunReading(book);
        for (int usedTimeunits = 0; usedTimeunits < timeUnits; usedTimeunits++) {
            readingMethod.read();
        }
        return readingMethod.getProgession();
    }

}
