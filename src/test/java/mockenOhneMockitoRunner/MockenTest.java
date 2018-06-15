package mockenOhneMockitoRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import library.Book;
import library.LibraryManager;
import library.isbn.ISBNValidator;
import library.isbn.InvalidISBNException;

@ExtendWith(MockitoExtension.class)
public class MockenTest {

	private static final String ISBN = "3-86680-19";

	private LibraryManager underTest;

	@BeforeEach
	public void setUp(@Mock ISBNValidator isbnValidator) throws InvalidISBNException {
		underTest = new LibraryManager(isbnValidator);
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
