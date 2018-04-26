package annotationen;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import library.Book;
import library.Customer;
import library.LibraryManager;
import library.RentCalculator;

public class AnnotationJUnit5Test {

	private LibraryManager libraryManager;

	private Book book = new Book("imei", "title");
	private Book book1 = new Book("imei1", "title1");
	private Book book2 = new Book("imei2", "title2");
	private Book book3 = new Book("imei3", "title3");
	private Book book4 = new Book("imei4", "title4");
	private List<Book> booksToRent = asList(book, book1, book2, book3, book4);
	private int index = 0;
	private int bookCount = 4;

	@Rule
	public RepeatRule repeatRule = new RepeatRule();

	@BeforeEach
	public void setup() {
		libraryManager = new LibraryManager(booksToRent);
	}

	@RepeatedTest(value = 5)
	public void testRepeat() throws Exception {

		libraryManager.rentBook(booksToRent.get(index++));

		long count = libraryManager.availableBookCount();

		assertEquals(bookCount--, count);
	}

	@Test
	@DisplayName("CalculateDailyFee")
	public void testDieserNameIstMist() throws Exception {
		RentCalculator rentCalculator = new RentCalculator();

		double dailyFee = rentCalculator.calculateDailyFee(Customer.PENSIONER, book, book1);

		assertEquals(4.4d, dailyFee, 0.0);
	}

	@Test
	@Disabled
	public void ignore() throws Exception {
		RentCalculator rentCalculator = new RentCalculator();

		double dailyFee = rentCalculator.calculateDailyFee(Customer.STUDENT, book, book1);

		assertEquals(12d, dailyFee, 0.0);
	}
}
