package extensions.builder;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import extensions.builder.BookBuilderExtension.WithBookState;
import library.Book;
import library.BookState;
import library.LibraryManager;

@ExtendWith(BookBuilderExtension.class)
public class CustomExtensionTest {

	private LibraryManager underTest = new LibraryManager();

	@Test
	public void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	@Test
	public void cannotRentBook(Book book) {
		RuntimeException exception = assertThrows(RuntimeException.class, () -> underTest.rentBook(book));
		assertEquals("No book like this in library", exception.getMessage());
	}

	@Test
	public void containsBooks(Book book, Book another) {
		addAllBooksToLibrary(book, another);

		Assertions.assertThat(underTest.getBooks().values()).containsExactlyInAnyOrder(book, another);
	}

	@Test
	public void canRentBook(Book book, Book another) {
		addAllBooksToLibrary(book, another);

		assertTrue(underTest.rentBook(book));
		assertEquals(BookState.RENT, book.getState());
	}

	@Test
	public void notAllBooksAvailable(@WithBookState(BookState.RENT) Book unavailable, Book availableBook,
			Book anotherAvailableBook) {
		addAllBooksToLibrary(unavailable, availableBook, anotherAvailableBook);

		assertEquals(2, underTest.availableBookCount());
	}

	private void addAllBooksToLibrary(Book... books) {
		underTest.addBooks(Arrays.asList(books));
	}

}
