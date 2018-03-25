package felix;

import java.util.HashMap;
import java.util.Map;

public class LibraryManager {

	private final Map<String, Book> books;

	public LibraryManager() {
		books = new HashMap<>();
	}

	public Book getBook(String imei) {
		return books.get(imei);
	}
	
	public boolean hasBook(String imei) {
		return books.containsKey(imei);
	}

	public boolean rentBook(Book book) {
		if (books.containsKey(book.getImei())) {
			if (books.get(book.getImei()).getState() == BookState.AVAILABLE) {
				books.get(book.getImei()).setState(BookState.LENT);
				return true;
			}
			return false;
		}
		throw new RuntimeException("No book like this in library");
	}

	public void returnBook(String imei) {
		books.get(imei).setState(BookState.AVAILABLE);
	}

	public Map<String, Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		books.put(book.getImei(), book);
	}

	public long availableBookCount() {
		return books.entrySet() //
				.stream() //
				.filter(entry -> (entry.getValue().getState() == BookState.AVAILABLE)) //
				.count();
	}

}