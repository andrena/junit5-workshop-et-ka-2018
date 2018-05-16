package expectedException;

import library.isbn.ISBNValidator;
import library.isbn.InvalidISBNException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class ISBNValidatorTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	private ISBNValidator underTest;
	
	
	@Before
	public void setUp() {
		underTest = new ISBNValidator();
	}
	
	@Test
	public void testValidISBN() throws InvalidISBNException {
		assertTrue(underTest.validate("3-86680-192-0"));
	}

	@Test
	public void testInvalidISBN() throws InvalidISBNException {
		exceptionRule.expect(InvalidISBNException.class);
		underTest.validate("3-86680-192-5");
	}

	
}
