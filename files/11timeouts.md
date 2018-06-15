# AssertTimeout 

In JUnit können Timeouts verwendet werden um die Laufzeit einer Testmethode zu begrenzen, z.B. bei Datenbank-Zugriffen.
In JUnit 4 gibt es zwei Möglichkeiten:

1. Die Timeout-Rule.

```Java
    @Rule
	public Timeout timeout = Timeout.seconds(3);
```

2. Der Timeout Parameter in der @Test-Annotation

```Java
    @Test(timeout = 3000)
    public void testTimeout()
```

In JUnit5 werden Timeouts direkt in den Assertions überprüft. Das ermöglicht es, genau einzuschränken, welcher Teil zeitlich beschränkt wird.

```Java
    Assertions.assertTimeout(Duration.ofSeconds(2), () -> {});
    Assertions.assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {});
```

## Aufgabe

1) Schreibe die Tests im `timeout` package so um, dass sie die JUnit 5 Syntax verwenden. 

2) Was ist der Unterschied zwischen der Timeout-Rule und dem Annotation-Parameter?

3) Was ist der Unterschied zwischen `asserTimeout()` und `assertTimeoutPreemptivley()`?