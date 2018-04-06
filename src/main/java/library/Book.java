package library;

import java.util.List;

public class Book {

	private final String imei;
	private final String title;
	private BookState state;
	private List<Page> pages;

	public Book(String imei, String title) {
		this.imei = imei;
		this.title = title;
		state = BookState.AVAILABLE;
	}

	public Book(String imei, String title, List<Page> pages) {
		super();
		this.imei = imei;
		this.title = title;
		this.pages = pages;
	}

	public String getImei() {
		return imei;
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
