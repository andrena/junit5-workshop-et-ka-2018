package abstractTests;

import library.Book;
import library.activies.reading.Progression;
import library.activies.reading.ReadingMethod;
import library.activies.reading.SpeedReading;

public class SpeedAbstractTest extends AbstractTest {

    @Override
    protected Progression readTest(Book book, int timeUnits) {
        ReadingMethod readingMethod = new SpeedReading(book);
        for (int usedTimeunits = 0; usedTimeunits < timeUnits; usedTimeunits++) {
            readingMethod.read();
        }
        return readingMethod.getProgession();
    }

}
