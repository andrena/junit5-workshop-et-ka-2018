package library;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private String ISBN;
	private String title;
	private BookState state;
	private int pageCount;

	public Book() {
	}

	public Book(String isbn, String title) {
		this.ISBN = isbn;
		this.title = title;
		state = BookState.AVAILABLE;
	}

	public Book(String ISBN, String title, int pageCount) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.pageCount = pageCount;
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

	public int getPageCount() {
		return pageCount;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", state=" + state + ", pages=" + pageCount + "]";
	}

}
