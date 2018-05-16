package library;


import library.persistence.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

	@Test
	public void testName() {
		// Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		// Get persistence from context.
		BookService BookService = ctx.getBean(BookService.class);

		// Add some items
		BookService.add(new Book("1", "Television"));
		BookService.add(new Book("2", "Phone"));
		BookService.addAll(Arrays.asList(new Book("3", "Peach"), new Book("4", "Strawberry"), new Book("5", "Melone"),
				new Book("6", "Onion")));

		assertEquals(6, BookService.findAll().size());
		// Test entity listing
		System.out.println("findAll=" + BookService.findAll());

		// Test specified find methods
		System.out.println("findByNameContainingIgnoreCase 'on': " + BookService.findByTitleContainingIgnoreCase("on"));

		ctx.close();
	}
}
