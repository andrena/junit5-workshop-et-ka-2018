package expectedException;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import library.ISBN10;

public class ISBN10Test {

	private ISBN10 underTest;

	@Before
	public void setUp() {
		underTest = new ISBN10();
	}

	@Test
	public void testValidISBN() throws Exception {
		assertTrue(underTest.isOfType("3-86680-192-0"));
	}

	@Test
	public void testInvalidISBN() throws Exception {
		underTest.isOfType("3-86680-192-5");
	}

}
