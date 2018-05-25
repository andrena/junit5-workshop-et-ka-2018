# Annotationen WIP

Die Annotationen von JUnit 4 zu 5 unterscheiden sich leicht Beispielsweiße wird `@Before` zu `@BeforeEach`

Eine Liste Annotationen von kann im 
[JUnit 5 Userguide](https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations)
gefunden werden.

Hier werden lediglich für die Übung verwendete Annotationen aufgelistet.

| Annotation | Description|
| ---------- |:----------:|
| @Test | Markiert Test Methoden. Im Gegensatz zu JUnit 4 können darauf keine Eigenschafen deklariert werden. |
| @BeforeEach | ersetzt @Before von JUnit 4 |
| @AfterEach | ersetzt @After von JUnit 4      |
| @BeforeAll | ersetzt @BeforeClass von JUnit 4 |
| @AfterAll | ersetzt @AfterClass von JUnit 4 |
| @DisplayName | setzt einen Anzeigenamen dabei können beliebige ASCII Zeichen verwendet werden |
| @Tag | ermöglicht das Angeben von Tags, nach denen gefiltert werden kann |
| @ExtendWith | wird zur Registrierung einer Extension verwendet. |
| @Disabled | ersetzt @Ignored von JUnit 4 |

## Eigene Annoationen

Es können auch eigene Meta-Annotationen geschrieben werden.

Hier ein Beispiel aus dem JUnit5 User Guide für eine `@Fast` Annotation.
```java
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {
}
```