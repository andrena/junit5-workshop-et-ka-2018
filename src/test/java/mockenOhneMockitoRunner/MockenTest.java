package mockenOhneMockitoRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import library.Book;
import library.LibraryManager;
import library.isbn.ISBNValidator;
import library.isbn.InvalidISBNException;

@RunWith(MockitoJUnitRunner.class)
public class MockenTest {

	private static final String ISBN = "3-86680-192-0";

	@Mock
	private ISBNValidator isbnValidator;

	private LibraryManager underTest;

	@Before
	public void setUp() throws InvalidISBNException {
		underTest = new LibraryManager();
		when(isbnValidator.validate(ISBN)).thenReturn(true);
	}

	@Test
	public void mockito() throws Exception {
		Book newBook = new Book(ISBN, "title");
		underTest.addBook(newBook);

		Map<String, Book> books = underTest.getBooks();

		assertEquals(newBook, books.get(ISBN));
	}
}
