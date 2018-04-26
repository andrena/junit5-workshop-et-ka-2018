package nested;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import library.Book;
import library.BookState;
import library.LibraryManager;

public class RegularLibraryManagerTest {

	private final Book junit = new Book("ABC123", "Junit Jupiter");
	private final Book java = new Book("456QB", "Java für Anfänger");
	private final Book scrum = new Book("DJEW123", "ScrumGuide");

	private LibraryManager underTest;

	@Before
	public void setUp() {
		underTest = new LibraryManager();
	}

	@Test
	public void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	@Test
	public void cannotRentBook() {
		Book book = new Book("123ABC", "Junit Jupiter");
		RuntimeException exception = assertThrows(RuntimeException.class, () -> underTest.rentBook(book));
		assertEquals("No book like this in library", exception.getMessage());
	}

	@Test
	public void containsBooks() {
		fillLibraryWithBooks();

		assertEquals(3, underTest.getBooks().size());
	}

	@Test
	public void canRentBook() {
		// TODO Showcase -> Bücher einfügen vergessen
		fillLibraryWithBooks();
		assertTrue(underTest.rentBook(java));

		Book rentBook = underTest.getBook(java.getISBN());
		assertEquals(BookState.RENT, rentBook.getState());
	}

	@Test
	public void canLookUpBook() {
		fillLibraryWithBooks();
		assertTrue(underTest.hasBook("ABC123"));
	}

	@Test
	public void notAllBooksAvailable() {
		// TODO Showcase -> Falsche Reihenfole
		fillLibraryWithBooks();
		rentBookInitially();
		assertEquals(2, underTest.availableBookCount());
	}

	private void fillLibraryWithBooks() {
		underTest.addBook(junit);
		underTest.addBook(java);
		underTest.addBook(scrum);
	}

	private void rentBookInitially() {
		underTest.rentBook(java);
	}
}
