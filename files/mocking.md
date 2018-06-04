# Mocking

Früher wurde der MockitoJUnitRunner benutzt, um Klassen zu mocken:

```
@RunWith(MockitoJUnitRunner.class)
public class MockenTest {
     @Mock
      private MockKlasse mocked;

      private TestKlasse underTest;

     @Before
      public void setUp(){
             when(mocked.call()).thenReturn(true);
      }

     @Test
      public void test() {
              undertest.machIrgendwas(mocked);
      }
}
```

Ab JUnit5 wird dies durch eine Extension (siehe extensions.md) gelöst. Anfangs war MockitoExtension.class eine der Beispiel-Extensions des JUnit-Teams, später wurde sie durch ein allgemeineres Beispiel (RandomParameterExtension.class) ersetzt.

##Tipp:
Die MockitoExtension implementiert den TestInstancePostProcessor und den ParameterResolver. 

```
@ExtendWith(MockitoExtension.class)
public class MockenTest {
     @Mock
      private MockKlasse mocked;
      private TestKlasse underTest;

     @BeforeEach
      void setUp(@Mock OtherMockKlasse otherMocked){
             when(mocked.call()).thenReturn(true);
             when(otherMocked.call()).thenReturn(false);
      }

     @Test
      public void test() {
            undertest.machIrgendwas(mocked);
      }
}
```

## Hinweis: 
https://github.com/junit-team/junit5-samples/blob/026a9d9abe06b6173398c1a2518793259cd190f2/junit5-mockito-extension/src/main/java/com/example/mockito/MockitoExtension.java


