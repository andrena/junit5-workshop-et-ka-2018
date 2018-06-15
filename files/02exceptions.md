# Expected Exception

Diese Funktionalit�t ist in JUnit 4 �ber eine Rule und Annotation abgebildet.

JUnit 5 bietet hier mehr Kontrolle �ber den Ablauf eines solchen Tests.
assertThrows() bietet die M�glichkeit genau eine Funktion auf das Werfen einer bestimmten Exception zu �berpr�fen.
Des Weiteren wird die geworfene Exception zur�ckgeliefert und kann noch genauer untersucht werden.

```java
Throwable exception = assertThrows(Exception.class, ()-> functionCall(...));
assertThat(exception.getMessage).isEqualTo(...);
```

# Aufgabe
Wir habe im Packet excpectedException zweit Test Klassen die verschiedene M�glichkeiten Zeigen in JUnit 4 Exceptions zu fangen.
Diese Klassen sollen nun auf JUnit 5 umgestellt werden.

# Bsp.: L�sung
Mit JUnit 5 hat die @Test Annotation keine Properties mehr. Daher wird hier f�r beide Arten die Exception mit `assertThrows` gefangen.