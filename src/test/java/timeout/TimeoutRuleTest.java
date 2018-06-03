package timeout;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import library.Book;
import library.BookService;

public class TimeoutRuleTest {

	private BookService service;

	@Before
	public void setUp() {
		service = new BookService();
	}
	
	@Rule
	public Timeout timeout = Timeout.seconds(2);

	@Test
	public void testTimeout() throws InterruptedException {
		List<Book> all = service.findAll();

		assertEquals(0, all.size());
	}

}

