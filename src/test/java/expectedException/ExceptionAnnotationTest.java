package expectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.isbn.ISBNValidator;
import library.isbn.InvalidISBNException;

public class ExceptionAnnotationTest {

    private ISBNValidator underTest;

	@BeforeEach
    public void setUp() {
        underTest = new ISBNValidator();
    }

    @Test
    public void testValidISBN() throws InvalidISBNException {
        assertTrue(underTest.validate("3-86680-192-0"));
    }

	@Test
    public void testInvalidISBN() throws InvalidISBNException {
		assertThrows(InvalidISBNException.class, () -> underTest.validate("3-86680-192-5"));
    }

	@Test
    public void testWithAnnotationInvalidISBN() throws InvalidISBNException {
		assertThrows(InvalidISBNException.class, () -> underTest.validate("3-86680-192-5"));
    }


}
