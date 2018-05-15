package mockenOhneMockitoRunner;

import static java.util.Arrays.asList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import library.Book;
import library.BookService;
import library.LibraryManager;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MockenTest {
//
//	@Mock
//	private BookService bookService;
//
//	private Book book = new Book();
//
//	@Before
//	public void setUp() {
//		when(bookService.findAll()).thenReturn(asList(book));
//	}
//
//	@Test
//	public void testName() throws Exception {
//		LibraryManager libraryManager = new LibraryManager(asList(new Book("isbn", "title")));
//	}
//}
