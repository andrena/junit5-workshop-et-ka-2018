package timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.Book;
import library.BookService;

public class TimeoutRuleTest {

	private BookService service;

	@BeforeEach
	public void setUp() throws InterruptedException {
		Thread.sleep(1000);
		service = new BookService();
	}
	
	@Test
	public void testTimeout() throws InterruptedException {
		assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
			List<Book> all = service.findAll();
			assertEquals(0, all.size());
		});
	}

}

