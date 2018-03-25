package felix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("New Library")
class LibraryManagerTest {

	private LibraryManager underTest;

	@BeforeEach
	void setUp() {
		underTest = new LibraryManager();
	}

	@Test
	@DisplayName("is initally empty")
	void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	@Test
	@DisplayName("cannot Rent a Book")
	void cannotRentBook() {
		Book book = new Book("123ABC", "Junit Jupiter");
		RuntimeException exception = assertThrows(RuntimeException.class, () -> underTest.rentBook(book));
		assertEquals("No book like this in library", exception.getMessage());
	}

	@Nested
	@DisplayName("with all books available")
	class WithSomeBooks {

		private final Book junitBook = new Book("ABC123", "Junit Jupiter");
		private final Book javaBook = new Book("456QB", "Java für Anfänger");
		private final Book scrumBook = new Book("DJEW123", "ScrumGuide");

		@BeforeEach
		void setUp() {
			underTest.addBook(junitBook);
			underTest.addBook(javaBook);
			underTest.addBook(scrumBook);
		}

		@Test
		@DisplayName("is not empty")
		void containsBooks() {
			assertEquals(3, underTest.getBooks().size());
		}

		@Test
		@DisplayName("you can rent a book")
		void canRentBook() {
			assertTrue(underTest.rentBook(javaBook));

			Book rentBook = underTest.getBook(javaBook.getImei());
			assertEquals(BookState.LENT, rentBook.getState());
		}
		
		@Test
		@DisplayName("you can check for a book")
		void hasBook() {
			assertTrue(underTest.hasBook("ABC123"));
		}
		
		@Nested
		@DisplayName("when some books are rent")
		class WithSomeBooksRent{
			
			@BeforeEach
			void setUp() {
				underTest.rentBook(javaBook);
			}
			
			@Test
			@DisplayName("has not All Books available")
			void notAllBooksAvailable() {
				assertEquals(3, underTest.getBooks().size());
				assertEquals((long) 2, underTest.availableBookCount());
			}
		}
		
	}

	
}
