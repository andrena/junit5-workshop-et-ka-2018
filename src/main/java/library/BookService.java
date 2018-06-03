package library;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BookService {

    public void add(Book Book) {
	}

	public List<Book> findAll() throws InterruptedException {
		Thread.sleep(2500);
		return Collections.emptyList();
	}

	public void addAll(Collection<Book> Books) throws InterruptedException {
		Thread.sleep(5000);
	}

	public List<Book> findByTitleContainingIgnoreCase(String searchString) {
		return Collections.emptyList();
	}
}