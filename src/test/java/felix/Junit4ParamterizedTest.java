package felix;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Junit4ParamterizedTest {

	@Parameter
	public Customer customer;

	@Parameter(1)
	public double expectedFee;

	@Parameters(name = "Tagespreis für 2 Bücher für {0} ist {1}")
	public static Collection<Object[]> parameters() {
		return asList(
				new Object[][] { { Customer.PENSIONER, 4.4 }, { Customer.STUDENT, 4.4 }, { Customer.REGULAR, 5.0 }, });
	}

	@Test
	public void calculate() {
		RentCalculator calculator = new RentCalculator();

		Book book = new Book("ABC", "Testbook");
		double dailyFee = calculator.calculateDailyFee(customer, book, book);
			
		assertEquals(expectedFee, dailyFee);
	}

}
