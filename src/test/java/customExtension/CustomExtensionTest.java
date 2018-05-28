package customExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import library.Book;
import library.BookState;
import library.LibraryManager;
import library.isbn.ISBNValidator;
import library.isbn.InvalidISBNException;

public class CustomExtensionTest {

	private final Book junitBook = new Book("ABC123", "Junit Jupiter");
	private final Book javaBook = new Book("456QB", "Java für Anfänger");
	private final Book scrumBook = new Book("DJEW123", "ScrumGuide");

	private ISBNValidator validatorMock = mock(ISBNValidator.class);

	private LibraryManager underTest = new LibraryManager(validatorMock);

	@Before
	public void setUp() throws InvalidISBNException {
		when(validatorMock.validate(anyString())).thenReturn(true);
	}

	@Test
	public void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	@Test
	public void containsBooks() {
		addAllBooksToLibrary(junitBook, javaBook);

		Assertions.assertThat(underTest.getBooks().values()).containsExactlyInAnyOrder(junitBook, javaBook);
	}

	@Test
	public void canRentBook() {
		addAllBooksToLibrary(junitBook, javaBook);

		assertTrue(underTest.rentBook(junitBook));
		assertEquals(BookState.RENT, junitBook.getState());
	}

	@Test
	public void notAllBooksAvailable() {
		addAllBooksToLibrary(junitBook, javaBook, scrumBook);
		underTest.rentBook(junitBook);

		assertEquals(2, underTest.availableBookCount());
	}

	private void addAllBooksToLibrary(Book... books) {
		underTest.addBooks(Arrays.asList(books));
	}
	
}
