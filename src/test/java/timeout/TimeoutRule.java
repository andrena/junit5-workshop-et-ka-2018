package timeout;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import library.BookService;

public class TimeoutRule {

	private BookService service;

	@Before
	public void setUp() {
		service = new BookService();
	}
	
	@Rule
	public Timeout timeout = Timeout.seconds(2);

	@Test
	public void testTimeout() throws InterruptedException {
		service.findAll();
	}

}

