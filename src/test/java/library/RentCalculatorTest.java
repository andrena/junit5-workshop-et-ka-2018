package library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import library.Book;
import library.CustomerFee;
import library.RentCalculator;

public class RentCalculatorTest {

	private RentCalculator underTest;

	@ParameterizedTest(name = "Tagespreis für 2 Bücher für {0} ist {1}")
	@DisplayName("Tagespreis berechnen")
	@CsvSource({ "STUDENT, 4.4", "PENSIONER, 4.4" })
	void calculate(CustomerFee customer, double fee) {
		underTest = new RentCalculator();
		
		Book book = new Book("ABC", "Testbook");
		
		double calculatedFee = underTest.calculateDailyFee(customer, book, book);

		assertEquals(fee, calculatedFee);
	}

	@Test
	@DisplayName("Regulärer Tagespreis ohne Rabatte")
	void calculateRegular() {
		underTest = new RentCalculator();

		Book book = new Book("ABC", "Testbook");

		double calculatedFee = underTest.calculateDailyFee(CustomerFee.REGULAR, book, book);

		assertEquals(5.0, calculatedFee);
	}
}
