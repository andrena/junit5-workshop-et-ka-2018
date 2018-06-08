package timeout;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import library.Book;
import library.BookService;

public class TimeoutAnnotationTest {

	private BookService service;

	@Before
	public void setUp() throws InterruptedException {
		Thread.sleep(1000);
		service = new BookService();
	}

	@Test(timeout = 3000)
	public void testTimeout() throws InterruptedException {
		List<Book> all = service.findAll();
		assertEquals(0, all.size());
	}

}
