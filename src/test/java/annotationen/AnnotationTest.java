package annotationen;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import library.Book;
import library.CustomerFee;
import library.LibraryManager;
import library.RentCalculator;

public class AnnotationTest {

	private LibraryManager libraryManager;
	private List<Book> booksToRent;

	private Book book = new Book("3-86680-192-0", "Buch0");
	private Book book1 = new Book("3-598-21501-0", "Buch1");
	private Book book2 = new Book("3-598-21502-9", "Buch2");
	private Book book3 = new Book("3-598-21503-7", "Buch3");
	private Book book4 = new Book("3-598-21504-5", "Buch4");
	private int index = 0;
	private int bookCount = 4;

	@Rule
	public RepeatRule repeatRule = new RepeatRule();

	@Before
	public void setup() {
		booksToRent = asList(book, book1, book2, book3, book4);
		libraryManager = new LibraryManager(booksToRent);
	}

	@Test
	@Repeat(times = 5)
	public void testRepeat() throws Exception {
		libraryManager.rentBook(booksToRent.get(index++));

		long count = libraryManager.availableBookCount();

		assertEquals(bookCount--, count);
	}

	@Test
	public void testDieserNameIstMist() throws Exception {
		RentCalculator rentCalculator = new RentCalculator();

		double dailyFee = rentCalculator.calculateDailyFee(CustomerFee.PENSIONER, book, book1);

		assertEquals(4.4d, dailyFee, 0.0);
	}

	@Test
	@Ignore
	public void ignore() throws Exception {
		RentCalculator rentCalculator = new RentCalculator();

		double dailyFee = rentCalculator.calculateDailyFee(CustomerFee.STUDENT, book, book1);

		assertEquals(12d, dailyFee, 0.0);
	}

}
