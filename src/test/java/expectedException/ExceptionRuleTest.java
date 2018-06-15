package expectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.isbn.ISBN10;
import library.isbn.InvalidISBNException;

public class ExceptionRuleTest {

	private ISBN10 underTest;

	@BeforeEach
	public void setUp() {
		underTest = new ISBN10();
	}

	@Test
	public void testValidISBN() throws InvalidISBNException {
		assertTrue(underTest.isOfType("3-86680-192-0"));
	}

	@Test
	public void testInvalidISBN() throws InvalidISBNException {
		assertFalse(underTest.isOfType("3-86680-192-5"));
	}

	@Test
	public void testMaleformedISBNWithTooManySeparators() throws InvalidISBNException {
		InvalidISBNException exception = assertThrows(InvalidISBNException.class,
				() -> underTest.isOfType("4-444-44-44-44"));
		assertThat(exception.getMessage()).isEqualTo("ISBN '4-444-44-44-44' is invalid.");
	}

	@Test
	public void testMaleformedISBNWithTooFewSeparators() throws InvalidISBNException {
		InvalidISBNException exception = assertThrows(InvalidISBNException.class,
				() -> underTest.isOfType("4444-444-444"));
		assertThat(exception.getMessage()).isEqualTo("ISBN '4444-444-444' is invalid.");
	}

	@Test
	public void testMaleformedISBNWithoutSeparators() throws InvalidISBNException {
		InvalidISBNException exception = assertThrows(InvalidISBNException.class,
				() -> underTest.isOfType("3866801920"));
		assertThat(exception.getMessage()).isEqualTo("ISBN '3866801920' is invalid.");
	}

}
