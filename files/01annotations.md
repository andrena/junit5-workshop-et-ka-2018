# Annotationen

Die Annotationen von JUnit 4 und 5 unterscheiden sich leicht, beispielsweise wird `@Before` zu `@BeforeEach`.

Eine Liste Annotationen von kann im 
[JUnit 5 Userguide](https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations)
gefunden werden.

Hier ein kleiner Auszug der wichtigsten Annotationen:

| JUnit 4 | JUnit 5 | Beschreibung |
| ---------- |:----------:|:----------:|
| @Test | @Test | Markiert Test Methoden. |
| @Before | @BeforeEach | wird vor jeder Testmethode ausgeführt |
| @After | @AfterEach | wird nach jeder Testmethode ausgeführt |
| @BeforeClass| @BeforeAll | wird vor der Testklasse ausgeführt |
| @AfterClass | @AfterAll | wird nach der Testklasse ausgeführt |
| @Ignore |@Disabled | Test wird nicht ausgeführt |

Diese Annotationen sind u.a. neu dazu gekommen mit JUnit5:

| Name | Beschreibung |
| ---------- |:----------:|
| @DisplayName | setzt einen Anzeigenamen, dabei können beliebige ASCII Zeichen verwendet werden |
| @Tag | ermöglicht das Angeben von Tags, nach denen gefiltert werden kann |
| @RepeatedTest | wird anstatt der @Test Annotation genutzt, um den Test wiederholt auszuführen. Es muss ein Parameter "value=n" gesetzt werden, wobei n die Anzahl der wiederholungen ist |

## Meta-Annoationen

Es können auch eigene Meta-Annotationen geschrieben werden.

Hier ein Beispiel aus dem JUnit5 User Guide für eine `@Fast` Annotation.
```java
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {
}
```

# Aufgabe (beachte die Namen der Tests)
[AnnotationTest](../src/test/java/annotationen/AnnotationTest.java)
1) Stelle die folgende JUnit 4 Annotationen auf JUnit 5 um: @Before, @Ignore
2) Baue die RepeatRule aus
3) Ändere den Namen eines Tests

## Tipp
Lösche zuerst die JUnit 4 Imports und löse die dadurch entstandenen Fehler.

## Hinweis
Bei den folgenden Aufgaben sind immer zuerst die Abhängigkeiten zu JUnit 4 zu eliminieren, d.h. die Annotationen wie z.B. @Before und @Test müssen auf das JUnit 5 Äquivalent migriert werden.
