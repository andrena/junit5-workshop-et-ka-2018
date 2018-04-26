package HamcrestAssertJ;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import library.Book;
import library.LibraryManager;

public class HamcrestAssertJTest {

	@Test
	public void hamcrestIs() throws Exception {
		Book book = new Book("isbn", "title");
		LibraryManager underTest = new LibraryManager(asList(book));

		Book rentBook = underTest.getBook("isbn");

		assertThat(rentBook, is(book));
	}

	@Test
	public void hamcrestContainsString() throws Exception {
		Book book = new Book("isbn", "Die Abenteuer des Robinson Crusoe");
		LibraryManager underTest = new LibraryManager(asList(book));

		Book rentBook = underTest.getBook("isbn");

		assertThat(rentBook.getTitle(), containsString("Crusoe"));
	}

	@Test
	public void hamcrestIsDurchAssertJErsetzen() throws Exception {
		Book book = new Book("isbn", "title");
		LibraryManager underTest = new LibraryManager(asList(book));

		Book rentBook = underTest.getBook("isbn");

		assertThat(rentBook, is(book));
	}

	@Test
	public void hamcrestContainsStringDurchAssertJErsetzen() throws Exception {
		Book book = new Book("isbn", "Die Abenteuer des Robinson Crusoe");
		LibraryManager underTest = new LibraryManager(asList(book));

		Book rentBook = underTest.getBook("isbn");

		assertThat(rentBook.getTitle(), containsString("Crusoe"));
	}

}
