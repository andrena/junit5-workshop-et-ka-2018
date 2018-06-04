# Annotationen WIP

Die Annotationen von JUnit 4 zu 5 unterscheiden sich leicht Beispielsweiße wird `@Before` zu `@BeforeEach`

Eine Liste Annotationen von kann im 
[JUnit 5 Userguide](https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations)
gefunden werden.

Hier werden lediglich für die Übung verwendete Annotationen aufgelistet.

| JUnit 4 | JUnit 5 | Beschreibung |
| ---------- |:----------:|:----------:|
| @Test | @Test | Markiert Test Methoden. |
| @Before | @BeforeEach | wird vor jeder Testmethode ausgeführt |
| @After | @AfterEach | wird nach jeder Testmethode ausgeführt |
| @BeforeClass| @BeforeAll | wird vor der Testklasse ausgeführt |
| @AfterClass | @AfterAll | wird nach der Testklasse ausgeführt |
| -- |@DisplayName | setzt einen Anzeigenamen, dabei können beliebige ASCII Zeichen verwendet werden |
| -- |@Tag | ermöglicht das Angeben von Tags, nach denen gefiltert werden kann |
| -- |@ExtendWith | wird zur Registrierung einer Extension verwendet. |
| @Ignore |@Disabled | Test wird nicht ausgeführt |

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

# Aufgabe
Dies ist ab jetzt in jeder Aufgabe relevant. Ersetze die JUnit 4 Annotations durch JUnit 5 Annotations.

Für diese Aufgabe bearbeiten wir das annoatationen Package

# Lösung

Darfst du vorstellen ;P
