# Parametrisierte Tests

In JUnit 5 sind parametrisierte Tests ein einfacher Weg um zum Beispiel Enums zu Testen.

```java

@ParameterizedTest
@EnumSource(States.class)
void testStates(States state) {
    assertThat(state.edit()).isEqualTo(States.EDITED);
}

@ParameterizedTest
@ValueSource(int = {"13", "7", "3", "21"})
void testSources(int number){
    assertTrue(isLuckyNumber(number));
}

```