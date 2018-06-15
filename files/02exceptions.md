# Expected Exception

Diese Funktionalität ist in JUnit 4 über eine Rule und Annotation abgebildet.

JUnit 5 bietet hier mehr Kontrolle über den Ablauf eines solchen Tests.
assertThrows() bietet die Möglichkeit genau eine Funktion auf das Werfen einer bestimmten Exception zu überprüfen.
Des Weiteren wird die geworfene Exception zurückgeliefert und kann noch genauer untersucht werden.

```java
Throwable exception = assertThrows(Exception.class, ()-> functionCall(...));
assertThat(exception.getMessage).isEqualTo(...);
```

# Aufgabe
Wir habe im Packet excpectedException zweit Test Klassen die verschiedene Möglichkeiten Zeigen in JUnit 4 Exceptions zu fangen.
Diese Klassen sollen nun auf JUnit 5 umgestellt werden.

# Bsp.: Lösung
Mit JUnit 5 hat die @Test Annotation keine Properties mehr. Daher wird hier für beide Arten die Exception mit `assertThrows` gefangen.