# Hamcrest und AssertJ

In JUnit 4 ist Hamcrest eingebunden, mit JUnit 5 wurde dies entfernt. Aus diesem Grund muss nun diese Abhängigkeit hinzugefügt werden:

```groovy
testImplementation "org.hamcrest:hamcrest-core:1.3"
```

Außerdem muss man dann das `assertThat` aus dem Paket `org.hamcrest.MatcherAssert.assertThat` anstatt von `org.junit` benutzen.

Eine Alternative zu Hamcrest ist AssertJ Dazu muss folgende Abhändigkeit hinzugefügt werden:

```groovy
testImplementation "org.assertj:assertj-core:3.8.0"
```

Hier sind zwei einfache Beispiele für AssertJ:

```java
assertThat(actual).isEqualTo(expected);
assertThat(actualDate).isBefore(expectedDate);
```

# Aufgabe (beachte die Namen der Tests)
[HamcrestAssertJTest](../src/test/java/hamcrestAssertJ/HamcrestAssertJTest.java)

1) Hamcrest einbinden
2) AssertJ verwenden