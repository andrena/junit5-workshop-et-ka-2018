package parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import library.Book;
import library.CustomerFee;
import library.RentCalculator;

public class ParameterizedAnnotationTest {

	public static List<Arguments> parameters() {
		return Arrays.asList(Arguments.of(CustomerFee.STUDENT, 4.4), Arguments.of(CustomerFee.PENSIONER, 4.4),
				Arguments.of(CustomerFee.REGULAR, 5.0));
	}

	private RentCalculator underTest = new RentCalculator();

	@ParameterizedTest
	@MethodSource("parameters")
	public void calculate(CustomerFee customer, double expectedFee) {
		Book book = new Book("3-234-213-3", "TestBook");
		double calculateFee = underTest.calculateDailyFee(customer, book, book);

		assertEquals(expectedFee, calculateFee, 0.1);
	}
}
