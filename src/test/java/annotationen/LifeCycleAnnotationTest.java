package annotationen;

import static java.util.Arrays.asList;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import library.Book;
import library.LibraryManager;

public class LifeCycleAnnotationTest {

	private Book book = new Book("imei", "title");
	private Book book1 = new Book("imei1", "title1");
	private Book book2 = new Book("imei2", "title2");
	private Book book3 = new Book("imei3", "title3");
	private Book book4 = new Book("imei4", "title4");

	private LibraryManager libraryManager = new LibraryManager();
	private List<Book> booksToRent;

	@BeforeClass
	public void setup() {
		booksToRent = asList(book, book1, book2, book3, book4);
		libraryManager = new LibraryManager(booksToRent);
	}

	@Test
	public void testName() throws Exception {

	}
}
