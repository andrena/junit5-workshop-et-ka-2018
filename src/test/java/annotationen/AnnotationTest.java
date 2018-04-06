package annotationen;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import library.Book;
import library.Customer;
import library.LibraryManager;
import library.RentCalculator;

public class AnnotationTest {

	private Book book = new Book("imei", "title");
	private Book book1 = new Book("imei1", "title1");
	private Book book2 = new Book("imei2", "title2");
	private Book book3 = new Book("imei3", "title3");
	private Book book4 = new Book("imei4", "title4");
	private int index = 0;
	private int bookCount = 4;

	private LibraryManager libraryManager = new LibraryManager();
	private List<Book> booksToRent;

	@Rule
	public RepeatRule repeatRule = new RepeatRule();

	@Before
	public void setup() {
		booksToRent = new ArrayList<>();
		booksToRent.add(book);
		booksToRent.add(book1);
		booksToRent.add(book2);
		booksToRent.add(book3);
		booksToRent.add(book4);
		libraryManager.addBook(book);
		libraryManager.addBook(book1);
		libraryManager.addBook(book2);
		libraryManager.addBook(book3);
		libraryManager.addBook(book4);
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

		double dailyFee = rentCalculator.calculateDailyFee(Customer.PENSIONER, book, book1);

		assertEquals(4.4d, dailyFee, 0.0);
	}

	@Test
	@Ignore
	public void ignore() throws Exception {
		RentCalculator rentCalculator = new RentCalculator();

		double dailyFee = rentCalculator.calculateDailyFee(Customer.STUDENT, book, book1);

		assertEquals(12d, dailyFee, 0.0);
	}
}
