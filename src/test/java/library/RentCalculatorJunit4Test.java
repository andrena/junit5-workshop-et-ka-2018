package library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RentCalculatorJunit4Test {

	@Parameter
	public CustomerFee customer;

	@Parameter(1)
	public double expectedFee;

	@Parameters(name = "Tagespreis für 2 Bücher für {0} ist {1}")
	public static Collection<Object[]> parameters() {
		return asList(
				new Object[][] { //
						{ CustomerFee.PENSIONER, 4.4 }, //
						{ CustomerFee.STUDENT, 4.4 }, //
						{ CustomerFee.REGULAR, 5.0 }, });
	}

	@Test
	public void calculate() {
		RentCalculator calculator = new RentCalculator();

		Book book = new Book("ABC", "Testbook");
		double dailyFee = calculator.calculateDailyFee(customer, book, book);

		assertEquals(expectedFee, dailyFee, 0.0);
	}

}
