package parameterized;

import library.StorageNumberConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FileParameterTest {

	@Parameter
	public int inputValue;

	@Parameter(1)
	public String result;

	@Parameterized.Parameters(name = " {0} als römische Zahl ist {1}")
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] { //
				{ 1, "I" }, //
				{ 9, "IX" }, //
				{ 10, "X" }, //
				{ 11, "XI" } });
	}

	private StorageNumberConverter underTest;

	@Before
	public void setup() {
		underTest = new StorageNumberConverter();
	}

	@Test
	public void toRomanNumber() {
		String romanNumber = underTest.toRoman(inputValue);

		assertEquals(result, romanNumber);
	}

}
