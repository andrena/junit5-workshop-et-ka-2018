package library.isbn;

public class InvalidISBNException extends Throwable {

	private static final long serialVersionUID = -4886379324055936086L;

    InvalidISBNException(String isbn) {
        super("ISBN '" + isbn + "' is invalid.");
    }
}
