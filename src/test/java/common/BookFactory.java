package common;

import library.Book;

public class BookFactory {

	public static Book getBook() {
		return new Book("0-330-25864-8", "The Hitchhiker's Guide to the Galaxy");
	}

	public static Book getSoftwareDevelopmentBook() {
		return new Book("978-0132350884", "Clean Code", 462);
	}

}
