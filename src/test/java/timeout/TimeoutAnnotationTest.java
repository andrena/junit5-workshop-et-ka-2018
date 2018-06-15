package timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.Book;
import library.BookService;

public class TimeoutAnnotationTest {

	private BookService service;

	@BeforeEach
	public void setUp() throws InterruptedException {
		Thread.sleep(1000);
		service = new BookService();
	}

	@Test
	public void testTimeout() throws InterruptedException {
		assertTimeout(Duration.ofMillis(3000), () -> {
			List<Book> all = service.findAll();
			assertEquals(0, all.size());
		});
	}

}
