package nested;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import library.Book;
import library.BookState;
import library.LibraryManager;

@DisplayName("A LibraryManager")
class NestedTest {

	private LibraryManager underTest;

	@BeforeEach
	void setUp() {
		underTest = new LibraryManager();
	}

	@Test
	@DisplayName("is initially empty")
	void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	@Test
	@DisplayName("can't rent books that are not in the library")
	void cannotRentBook() {
		assertThrows(RuntimeException.class, () -> underTest.rentBook(new Book("3-86680-192-3", "Junit Jupiter")));
	}

	@Nested
	@DisplayName("with books")
	class FilledWithBooks {
		private final Book junit = new Book("3-86680-192-0", "Junit Jupiter");
		private final Book java = new Book("3-598-21500-2", "Java für Anfänger");
		private final Book scrum = new Book("3-598-21506-1", "ScrumGuide");

		@BeforeEach
		void fillLibraryWithBooks() {
			underTest.addBook(junit);
			underTest.addBook(java);
			underTest.addBook(scrum);
		}

		@Test
		@DisplayName("contains some books")
		public void containsBooks() {
			assertEquals(3, underTest.getBooks().size());
		}

		@Test
		@DisplayName("can rent existing books")
		public void canRentBook() {
			assertTrue(underTest.rentBook(java));

			Book rentBook = underTest.getBook(java.getISBN());
			assertEquals(BookState.RENT, rentBook.getState());
		}

		@Test
		@DisplayName("can lookup books")
		public void canLookUpBook() {
			assertTrue(underTest.hasBook("3-598-21506-1"));
		}

		@Nested
		@DisplayName("and some already rent books")
		class SomeAlreadyRent {
			@BeforeEach
			void rentBookInitially() {
				underTest.rentBook(java);
			}

			@Test
			@DisplayName("has not all books available")
			public void notAllBooksAvailable() {
				assertEquals(2, underTest.availableBookCount());
			}

		}
	}

}
