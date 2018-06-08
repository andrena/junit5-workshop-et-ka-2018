package customExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import customExtension.BookExtension.Rent;
import library.Book;
import library.BookState;
import library.LibraryManager;
import library.isbn.ISBNValidator;
import library.isbn.InvalidISBNException;

@ExtendWith(BookExtension.class)
public class CustomExtensionTest {

	private ISBNValidator validatorMock = mock(ISBNValidator.class);

	private LibraryManager underTest = new LibraryManager(validatorMock);

	@BeforeEach
	public void setUp() throws InvalidISBNException {
		when(validatorMock.validate(anyString())).thenReturn(true);
	}

	@Test
	public void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	@Test
	public void containsBooks(Book junitBook, Book javaBook) {
		addAllBooksToLibrary(junitBook, javaBook);

		Assertions.assertThat(underTest.getBooks().values()).containsExactlyInAnyOrder(junitBook, javaBook);
	}

	@Test
	public void canRentBook(Book junitBook, Book javaBook) {
		addAllBooksToLibrary(junitBook, javaBook);

		assertTrue(underTest.rentBook(junitBook));
		assertEquals(BookState.RENT, junitBook.getState());
	}

	@Test
	public void notAllBooksAvailable(@Rent Book junitBook, Book javaBook, Book scrumBook) {
		addAllBooksToLibrary(junitBook, javaBook, scrumBook);

		assertEquals(2, underTest.availableBookCount());
	}

	private void addAllBooksToLibrary(Book... books) {
		underTest.addBooks(Arrays.asList(books));
	}
	
}
