package expectedException;

import library.isbn.ISBN10;
import library.isbn.InvalidISBNException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ISBN10Test {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	private ISBN10 underTest;

	@Before
	public void setUp() {
		underTest = new ISBN10();
	}

	@Test
	public void testValidISBN() throws InvalidISBNException {
		assertTrue(underTest.isOfType("3-86680-192-0"));
	}

	@Test
	public void testInvalidISBN() throws InvalidISBNException {
		exceptionRule.expect(InvalidISBNException.class);
		assertFalse(underTest.isOfType("3-86680-192-5"));
	}

	@Test
	public void testMaleformedISBN() throws InvalidISBNException {
		exceptionRule.expect(InvalidISBNException.class);
		assertFalse(underTest.isOfType("4-444-44-44-44"));
		assertFalse(underTest.isOfType("4444-444-444"));
		assertFalse(underTest.isOfType("3866801920"));
	}

}
