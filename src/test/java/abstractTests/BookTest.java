package abstractTests;

import common.BookFactory;
import common.PageFactory;
import library.Book;

public class BookTest extends BookPropertiesTest {

	@Override
	public Book createBook() {
		Book book = BookFactory.getBook();
		book.setPages(PageFactory.createPages(242));
		return book;
	}

}
