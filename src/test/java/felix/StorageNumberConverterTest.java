package felix;

import org.junit.jupiter.api.Test;

public class StorageNumberConverterTest {

	@Test
	public void hundretToRomain() {
		StorageNumberConverter converter = new StorageNumberConverter();

		for (int index = 0; index <= 1000; index++) {
			System.out.println(converter.toRoman(index));
		}
	}

}
