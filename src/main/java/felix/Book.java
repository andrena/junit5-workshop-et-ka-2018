package felix;

public class Book {

	private final String imei;
	private final String title;
	private BookState state;
	
	public Book(String imei, String title) {
		this.imei = imei;
		this.title = title;
		state = BookState.AVAILABLE;
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
	
}
