package library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import library.isbn.ISBNValidator;
import library.isbn.InvalidISBNException;

@Service
public class LibraryManager {

	private ISBNValidator isbnValidator;

	private RentCalculator rentCalculator;

	private Map<String, Book> books;

	public LibraryManager(ISBNValidator isbnValidator, RentCalculator rentCalculator) {
		this.isbnValidator = isbnValidator;
		this.rentCalculator = rentCalculator;
		init();
	}

	public LibraryManager() {
		init();
	}

	private void init() {
		books = new HashMap<>();
		rentCalculator = new RentCalculator();
		isbnValidator = new ISBNValidator();
	}

	public LibraryManager(List<Book> newBooks) {
		init();
		addBooks(newBooks);
	}

	public Book getBook(String imei) {
		return books.get(imei);
	}

	public boolean hasBook(String imei) {
		return books.containsKey(imei);
	}

	public boolean rentBook(Book book) {
		if (books.containsKey(book.getISBN())) {
			Book bookWithISBN = books.get(book.getISBN());
			if (bookWithISBN.getState() == BookState.AVAILABLE) {
				bookWithISBN.setState(BookState.RENT);
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
		String isbn = book.getISBN();
		try {
			if (isbnValidator.validate(isbn)) {
				books.put(isbn, book);
			}
		} catch (InvalidISBNException e) {
			System.out.println("Validation of isbn failed. book=" + book + "exception=" + e);
		}
	}

	public void addBooks(List<Book> booksToAdd) {
		booksToAdd.forEach(this::addBook);
	}

	public long rentBookCount() {
		return books.entrySet() //
				.stream() //
				.filter(entry -> (entry.getValue().getState() == BookState.RENT)) //
				.count();
	}

	public long availableBookCount() {
		return books.entrySet() //
				.stream() //
				.filter(entry -> (entry.getValue().getState() == BookState.AVAILABLE)) //
				.count();
	}

}