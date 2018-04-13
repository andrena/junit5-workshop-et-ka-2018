package library;

import java.util.List;

public class Book {

	private final String ISBN;
	private final String title;
	private BookState state;
	private List<Page> pages;

	public Book(String isbn, String title) {
		this.ISBN = isbn;
		this.title = title;
		state = BookState.AVAILABLE;
	}

	public Book(String ISBN, String title, List<Page> pages) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.pages = pages;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public BookState getState() {
		return state;
	}

	public void setState(BookState state) {
		this.state = state;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

}
