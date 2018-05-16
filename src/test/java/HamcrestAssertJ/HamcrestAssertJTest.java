package HamcrestAssertJ;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import library.Book;
import library.LibraryManager;

public class HamcrestAssertJTest {

	private static final String ISBN = "3-598-21504-5";

	@Test
	public void hamcrestIs() throws Exception {
		Book book = new Book(ISBN, "title");
		LibraryManager underTest = new LibraryManager(asList(book));

		Book rentBook = underTest.getBook(ISBN);

		assertThat(rentBook, is(book));
	}

	@Test
	public void hamcrestNotNullValue() throws Exception {
		Book book = new Book(ISBN, "Die Abenteuer des Robinson Crusoe");
		LibraryManager underTest = new LibraryManager(asList(book));

		Book rentBook = underTest.getBook(ISBN);

		assertThat(rentBook.getTitle(), notNullValue());
	}

	@Test
	public void hamcrestIsDurchAssertJErsetzen() throws Exception {
		Book book = new Book(ISBN, "title");
		LibraryManager underTest = new LibraryManager(asList(book));

		Book rentBook = underTest.getBook(ISBN);

		assertThat(rentBook, is(book));
	}

	@Test
	public void hamcrestNotNullValueDurchAssertJErsetzen() throws Exception {
		Book book = new Book(ISBN, "Die Abenteuer des Robinson Crusoe");
		LibraryManager underTest = new LibraryManager(asList(book));

		Book rentBook = underTest.getBook(ISBN);

		assertThat(rentBook.getTitle(), notNullValue());
	}

}
