# Abstract Tests

Abstract Test werden dazu genutzt um gleichbleibende Eigenschaften Mehrer Klassen zu testen.
Ein Beispiel hierfür sind Validatoren. Egal welcher Validator angesprochen wird, sein Verhalten nach außen sollte gleich bleiben.

Contracts bieten die gleiche Funktion wie Abstract Tests. Jedoch nutzen diese die Java 8 default Interface Methoden.

```java
    public interface ValidatiorContract<T, V> {
    
        T createValidator();
        V getValidValue();
        
        @Test
        default void testValidation(){
            T validator = createValidator();
            assertThat(validator.validate(getValidValue())).isTrue();
        }
        
    }
```

# Aufgabe

In den Dateien
[ReadingMethodTest](../src/test/java/abstractTests/ReadingMethodTest.java) und 
[BookPropertiesTest](../src/test/java/abstractTests/BookPropertiesTest.java)
sind in JUnit 4 verfasste abstrakte Tests.

Diese Test sollen nun mit den vorgestellten Technologien angepasst und durchgeführt werden.


# Bsp.: Lösung
```java
interface ReadingMethodTest {
    
    Progression readTest(Book book, int timeUnits);
    
    @Test
    default void testReadingTransfersKnowledge {
        ...
    }
}

class FunReadingTest implements ReadingMethodTest {
    
    @Override
    ...
}
```