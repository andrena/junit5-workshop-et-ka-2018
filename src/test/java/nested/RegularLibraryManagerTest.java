package nested;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import library.Book;
import library.BookState;
import library.LibraryManager;

public class RegularLibraryManagerTest {

	private final Book junit = new Book("3-86680-192-0", "Junit Jupiter");
	private final Book java = new Book("3-598-21500-2", "Java für Anfänger");
	private final Book scrum = new Book("3-598-21506-1", "ScrumGuide");

	private LibraryManager underTest;

	@Before
	public void setUp() {
		underTest = new LibraryManager();
	}

	@Test
	public void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	@Test(expected = RuntimeException.class)
	public void cannotRentBook() {
		underTest.rentBook(new Book("3-86680-192-3", "Junit Jupiter"));
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
		assertTrue(underTest.hasBook("3-598-21506-1"));
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
