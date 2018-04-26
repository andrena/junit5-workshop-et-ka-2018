package abstractTests;

import common.BookFactory;
import library.Book;

public class BookTest extends BookPropertiesTest {

	@Override
	public Book createBook() {
		Book book = BookFactory.getBook();
		return book;
	}

}
