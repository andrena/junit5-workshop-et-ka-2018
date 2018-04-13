package library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class StorageNumberConverterTest {

	@DisplayName("Zahlen konvertieren")
	@ParameterizedTest(name = "{0} zu {1}")
	@CsvFileSource(resources = { "romanNumbers.csv" })
	void toRomanTest(int arabisch, String roman) {
		StorageNumberConverter converter = new StorageNumberConverter();

		assertEquals(converter.toRoman(arabisch), roman);
	}

}
