package common;

import java.util.HashMap;
import java.util.Map;

import felix.Book;

public class BookFactory {

	private static Map<Long, Book> books = getRegisterdBooks();

	public static Book getBook(long id) {
		return books.get(id);

	}

	private static Map<Long, Book> getRegisterdBooks() {
		Map<Long, Book> books = new HashMap<>();
		books.put(42L, new Book("0-330-25864-8", "The Hitchhiker's Guide to the Galaxy"));
		return books;
	}

}
