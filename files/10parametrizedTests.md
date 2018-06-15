# Parametrisierte Tests

In Junit 4 können mit dem ``ParameterizedRunner`` alle Methoden einer Testsklasse für verschiedene Sets an Input-Daten ausgeführt werden.

Die Syntax ist teilweise aber doch etwas umständlich.

## Beispiel

```java
@RunWith(Parameterized.class)
public class RentCalculatorTest {

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

    -- Tests --
    .....
```

In Junit5 werden die Parameter direkt in die jeweilige Testmethode übergeben. So können auch einzelne Methoden innerhalb einer Testklasse parameterisiert werden.  
Es gibt verschiedene Annotationen um Parameter zu übergeben, z.B. ``@CsvSource``, ``@EnumSource``, ... [Junit5 Parameterized](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)

## Beispiel

```
@ParameterizedTest
@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
void palindromes(String candidate) {
    assertTrue(isPalindrome(candidate));
}

@ParameterizedTest
@CsvSource(strings = { "racecar, racecar", "radar, Radar", "teest, test" })
void stringAreEqual(String candidate, String expected) {
    assertEquals(expected, candidate);
}
```

## Aufgabe

1) Schreibe den ``RentCalculatorTest`` so um, dass er die Junit5 Syntax verwendet.

2) Schreibe den ``StorageNumberConverterTest`` so um, dass er eine Csv-Datei einliest und die Werte daraus als Paramter verwendet.
