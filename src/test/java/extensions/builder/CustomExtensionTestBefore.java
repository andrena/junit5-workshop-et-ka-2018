package extensions.builder;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import library.Book;
import library.BookState;
import library.LibraryManager;

class CustomExtensionTestBefore {

	private final Book junitBook = new Book("ABC123", "Junit Jupiter");
	private final Book javaBook = new Book("456QB", "Java für Anfänger");
	private final Book scrumBook = new Book("DJEW123", "ScrumGuide");

	private LibraryManager underTest = new LibraryManager();

	@Test
	public void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	@Test
	public void cannotRentBook() {
		RuntimeException exception = assertThrows(RuntimeException.class, () -> underTest.rentBook(junitBook));
		assertEquals("No book like this in library", exception.getMessage());
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
