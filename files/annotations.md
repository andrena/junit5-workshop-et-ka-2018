# Annotationen WIP

Die Annotationen von JUnit 4 zu 5 unterscheiden sich leicht, beispielsweise wird `@Before` zu `@BeforeEach`

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

# Aufgabe (beachte hierbei die Testnamen)
1) Dies ist ab jetzt in jeder Aufgabe relevant. Ersetze die JUnit 4 Annotations durch JUnit 5 Annotations. 
Wenn du fertig bist darf es im ``AnnotationenTest`` keinen import aus JUnit4 mehr geben.

2) Probiere die neuen Annotationen in JUnit5 aus (siehe dazu die Tabelle oben). 

Für diese Aufgabe bearbeiten wir das annotationen Package

# Hinweis
Ein geschicktes vorgehen ist es die JUnit4 Imports am Dateianfang zu löschen und dann die dadurch enstehenden Fehler zu lösen.
Bei der @Test Annoation muss z.B. nur der Richtige Import gewählt werden.

Die RepeatRule und @Repeated Annotation kannst du durch @RepeatedTest ersetzen.