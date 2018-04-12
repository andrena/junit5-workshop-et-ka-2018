package expectedException;

import static org.junit.Assert.assertFalse;
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
		assertFalse(underTest.isOfType("3-86680-192-5"));
	}

	@Test
	public void testMaleformedISBN() {
		assertFalse(underTest.isOfType("4-444-44-44-44"));
		assertFalse(underTest.isOfType("4444-444-444"));
		assertFalse(underTest.isOfType("3866801920"));
	}

}
