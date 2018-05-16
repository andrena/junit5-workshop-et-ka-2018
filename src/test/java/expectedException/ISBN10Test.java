package expectedException;

import library.isbn.ISBN10;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ISBN10Test {

	private ISBN10 underTest;

	@Before
	public void setUp() {
		underTest = new ISBN10();
	}

	@Test
	public void testValidISBN() {
		assertTrue(underTest.isOfType("3-86680-192-0"));
	}

	@Test
	public void testInvalidISBN() {
		assertFalse(underTest.isOfType("3-86680-192-5"));
	}

	@Test
	public void testMaleformedISBN() {
		assertFalse(underTest.isOfType("4-444-44-44-44"));
		assertFalse(underTest.isOfType("4444-444-444"));
		assertFalse(underTest.isOfType("3866801920"));
	}

}
