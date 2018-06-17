# Mocking

Früher wurde der MockitoJUnitRunner benutzt, um Klassen zu mocken:

```
@RunWith(MockitoJUnitRunner.class)
public class MockenTest {
     @Mock
     private MockKlasse1 mock1;
     @Mock
     private MockKlasse2 mock2;

     private TestKlasse underTest;

     @Before
     public void setUp(){
       when(mock1.call()).thenReturn(true);
       when(mock2.call()).thenReturn(false);
     }

     @Test
     public void test() {
              undertest.machIrgendwas(mock1, mock2);
     }
}
```

Ab JUnit5 wird dies durch eine Extension (siehe extensions.md) gelöst. Anfangs war MockitoExtension.class eine der Beispiel-Extensions des JUnit-Teams, später wurde sie durch ein allgemeineres Beispiel (RandomParameterExtension.class) ersetzt.

```
@ExtendWith(MockitoExtension.class)
public class MockenTest {
     @Mock
      private MockKlasse1 mock1;
      private TestKlasse underTest;

     @BeforeEach
      void setUp(@Mock MockKlasse2 mock2){
             when(mock1.call()).thenReturn(true);
             when(mock2.call()).thenReturn(false);
      }

     @Test
      public void test() {
            undertest.machIrgendwas(mock1, mock2);
      }
}
```

https://github.com/junit-team/junit5-samples/blob/026a9d9abe06b6173398c1a2518793259cd190f2/junit5-mockito-extension/src/main/java/com/example/mockito/MockitoExtension.java

## Aufgabe
[MockenTest](src\test\java\mockenOhneMockitoRunner\MockenTest.java):
1) MockitoExtension schreiben (oder Beispiel-Extension von JUnit)
2) Extension verwenden


## Hinweis: 
Es empfiehlt sich eine eigene MockitoExtension zu implementieren. Dazu können folgende Interfaces implementiert werden:
* `TestInstancePostProcessor`: wenn man die `@Mock`-Annotation verwenden möchte, muss nach dem Instanzieren der Testinstanz  `MockitoAnnotations.initMocks(testInstance);` aufrufen werden
* `ParameterResolver`: wenn eine Übergabe der Mocks als Parameter gewünscht ist.

## Lösung
siehe Hinweis Link