package library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class HierarchicalLibraryTest {

	private LibraryManager underTest;

	@Before
	public void setUp() {
		underTest = new LibraryManager();
	}

	@Test
	public void initialEmpty() {
		assertTrue(underTest.getBooks().isEmpty());
	}

	public class WithBook {

		private final Book junitBook = new Book("ABC123", "Junit Jupiter");
		private final Book javaBook = new Book("456QB", "Java für Anfänger");
		private final Book scrumBook = new Book("DJEW123", "ScrumGuide");

		@Before
		public void setUp() {
			underTest.addBook(junitBook);
			underTest.addBook(javaBook);
			underTest.addBook(scrumBook);
		}

		@Test
		public void containsBooks() {
			assertEquals(3, underTest.getBooks().size());
		}

		@Test
		public void canRentBook() {
			assertTrue(underTest.rentBook(javaBook));

			Book rentBook = underTest.getBook(javaBook.getISBN());
			assertEquals(BookState.RENT, rentBook.getState());
		}

		@Test
		public void hasBook() {
			assertTrue(underTest.hasBook("ABC123"));
		}

		public class WithSomeBooksRent {

			@Before
			public void setUp() {
				underTest.rentBook(javaBook);
			}

			@Test
			public void notAllBooksAvailable() {
				assertEquals(3, underTest.getBooks().size());
				assertEquals((long) 2, underTest.availableBookCount());
			}
		}

	}

}
