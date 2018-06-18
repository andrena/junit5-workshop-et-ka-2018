# Abstract Tests

Abstract Test werden dazu genutzt um gleichbleibende Eigenschaften mehrerer Klassen zu testen.

In JUnit 5 werden diese Tests als Contracts bezeichnet. Sie bieten die gleiche Funktion wie Abstract Tests. Jedoch nutzen diese die Java 8 default Interface Methoden.
Im Gegensatz von abstrakten Klassen lassen sich mehrere Interfaces an eine Testklasse hängen.  

```java
    public interface Contract<T> {
    
        T createValue();
        
        @Test
        default void testValue(){
            T value = createValue();
            assertThat(value).isEqualTo(expectedValue);
        }
        
    }
```

# Aufgabe

Wandle den Abstrakten JUnit 4 Test [AbstractTest](../src/test/java/abstractTests/AbstractTest.java) in ein Test-Interface um. 


# Bsp.: Lösung
```java
public interface EqualsContract<T>{

    T createValue();
    T createNotEqualValue();

    @Test
    default void valueEqualsItself() {
        T value = createValue();
        assertEquals(value, value);
    }

    @Test
    default void valueDoesNotEqualNull() {
        T value = createValue();
        assertFalse(value.equals(null));
    }

    @Test
    default void valueDoesNotEqualDifferentValue() {
        T value = createValue();
        T differentValue = createNotEqualValue();
        assertNotEquals(value, differentValue);
        assertNotEquals(differentValue, value);
    }

}
```