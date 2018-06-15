package parameterized;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import library.StorageNumberConverter;

public class ParameterizedFileTest {


	private StorageNumberConverter underTest;

	@BeforeEach
	public void setup() {
		underTest = new StorageNumberConverter();
	}

	@ParameterizedTest
	@CsvFileSource(resources = { "romanNumbers.csv" })
	public void toRomanNumber(int inputValue, String romanNumber) {
		String result = underTest.toRoman(inputValue);

		assertEquals(romanNumber, result);
	}

}
