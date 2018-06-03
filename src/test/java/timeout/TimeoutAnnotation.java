package timeout;

import org.junit.Before;
import org.junit.Test;

import library.BookService;

public class TimeoutAnnotation {

	private BookService service;

	@Before
	public void setUp() {
		service = new BookService();
	}

	@Test(timeout = 2000)
	public void testTimeout() throws InterruptedException {
		service.findAll();
	}

	@Test(timeout = 5000)
	public void testTimeout2() throws InterruptedException {
		service.findAll();
	}

}
