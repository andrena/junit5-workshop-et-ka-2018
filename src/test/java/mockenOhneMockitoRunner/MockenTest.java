package mockenOhneMockitoRunner;

import static java.util.Arrays.asList;

import org.junit.Test;

import library.Book;
import library.LibraryManager;

//@RunWith(MockitoJUnitRunner.class)
public class MockenTest {

	@Test
	public void testName() throws Exception {
		LibraryManager libraryManager = new LibraryManager(asList(new Book("isbn", "title")));
	}
}
