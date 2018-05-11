package timeout;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.BookService;

public class Junit5Timeout {

	private BookService service;

	@BeforeEach
	public void setUp() {
		service = new BookService();
	}

	@Test
	void testTimeout() {
		Assertions.assertTimeout(Duration.ofSeconds(2), service::findAll, "Zu langsam");
	}

	@Test
	void testTimeoutPreemptively() {
		Assertions.assertTimeoutPreemptively(Duration.ofSeconds(2), service::findAll, "Zu langsam");
	}

}
