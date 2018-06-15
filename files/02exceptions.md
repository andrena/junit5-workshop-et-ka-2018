# Expected Exception

Diese Funktionalität ist in JUnit 4 über eine Rule und Annotation abgebildet.

JUnit 5 bietet hier mehr Kontrolle über den Ablauf eines solchen Tests.
assertThrows() bietet die Möglichkeit genau eine Funktion auf das Werfen einer bestimmten Exception zu überprüfen.
Des Weiteren wird die geworfene Exception zurückgeliefert, wodurch man angenehmer auf Eigenschaften der Exception, wie z.B. Message oder Cause prüfen kann.

```java
Throwable exception = assertThrows(Exception.class, ()-> functionCall(...));
assertThat(exception.getMessage()).isEqualTo(...);
```

# Aufgabe
1) Stelle den ExceptionRuleTest auf assertThrows um
2) Stelle den ExceptionAnnotationTest auf assertThrows um 

# Bsp.: Lösung
Mit JUnit 5 hat die @Test Annotation keine Properties mehr. Daher wird hier für beide Arten die Exception mit `assertThrows` gefangen.