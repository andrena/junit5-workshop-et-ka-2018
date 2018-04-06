package felix;

import java.util.ArrayList;
import java.util.List;

public class BookTest extends BookPropertiesTest {

	@Override
	public Book createBook() {
		List<Page> pages = new ArrayList<Page>();
		for (long i = 0; i < 242; i++) {
			pages.add(new Page(i));
		}
		return new Book("42", "The Hitchhiker's Guide to the Galaxy", pages);
	}

}
