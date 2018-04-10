package library;

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
		if (books.containsKey(book.getISBN())) {
			if (books.get(book.getISBN()).getState() == BookState.AVAILABLE) {
				books.get(book.getISBN()).setState(BookState.RENT);
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
		books.put(book.getISBN(), book);
	}

	public long availableBookCount() {
		return books.entrySet() //
				.stream() //
				.filter(entry -> (entry.getValue().getState() == BookState.AVAILABLE)) //
				.count();
	}

}