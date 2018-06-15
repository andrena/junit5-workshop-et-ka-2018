package expectedException;

import library.isbn.ISBNValidator;
import library.isbn.InvalidISBNException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ExceptionAnnotationTest {

    private ISBNValidator underTest;

    @Before
    public void setUp() {
        underTest = new ISBNValidator();
    }

    @Test
    public void testValidISBN() throws InvalidISBNException {
        assertTrue(underTest.validate("3-86680-192-0"));
    }

    @Test(expected = InvalidISBNException.class)
    public void testInvalidISBN() throws InvalidISBNException {
        underTest.validate("3-86680-192-5");
    }

    @Test(expected = InvalidISBNException.class)
    public void testWithAnnotationInvalidISBN() throws InvalidISBNException {
        underTest.validate("3-86680-192-5");
    }


}
