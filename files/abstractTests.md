# Abstract Tests

Abstract Test werden dazu genutzt um gleichbleibende Eigenschaften Mehrer Klassen zu testen.
Ein Beispiel hierf�r sind Validatoren. Egal welcher Validator angesprochen wird, sein Verhalten nach au�en sollte gleich bleiben.

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