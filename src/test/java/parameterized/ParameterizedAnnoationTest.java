package parameterized;

import library.Book;
import library.CustomerFee;
import library.RentCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedAnnoationTest {

	@Parameter
	public CustomerFee customer;

	@Parameter(1)
	public double expectedFee;

	@Parameterized.Parameters(name = " Tagespreis für {0} für 2 Bücher ist {1}")
    public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{ CustomerFee.STUDENT, 4.4 }, //
				{ CustomerFee.PENSIONER, 4.4 }, //
				{ CustomerFee.REGULAR, 5.0 }
    	});
    }

	private RentCalculator underTest;

	@Before
	public void setUp() {
		underTest = new RentCalculator();
	}

	@Test
	public void calculate() {
		Book book = new Book("3-234-213-3", "TestBook");
		double calculateFee = underTest.calculateDailyFee(customer, book, book);

		assertEquals(expectedFee, calculateFee, 0.1);
	}
}
