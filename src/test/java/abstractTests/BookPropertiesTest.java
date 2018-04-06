package abstractTests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import felix.Book;

public abstract class BookPropertiesTest {

	public abstract Book createBook();

	@Test
	public void testPageCountHasPages() {
		Book book = createBook();
		assertNotNull(book.getPages());
		assertFalse(book.getPages().size() == 0);
	}

	@Test
	public void testBookHasTitle() {
		Book book = createBook();
		assertNotNull(book.getTitle());
		assertFalse(book.getTitle().isEmpty());
	}

}