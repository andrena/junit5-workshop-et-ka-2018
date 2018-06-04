# Test Suites

In JUnit 4 k�nnen Klassen in Test Suites zur gemeinsamen Ausf�hrung aufgelistet werden.

JUnit 5 erm�glicht dazu noch das Definieren von TestSuites auf Package Ebene.

```java

@SelectClasses({RentCalculatorJunit4Test.class})
@SelectPackages({"expectedException"})
@IncludeTags({"short","long"})
public class TestSuite{
    
}
```

# Aufgabe
Ausprobieren und Rumspielen! Mit Tags!