# Test Suites

In JUnit 4 können Klassen in Test Suites zur gemeinsamen Ausführung aufgelistet werden.

JUnit 5 ermöglicht dazu noch das Definieren von TestSuites auf Package Ebene.

```java

@SelectClasses({RentCalculatorJunit4Test.class})
@SelectPackages({"expectedException"})
@IncludeTags({"short","long"})
public class TestSuite{
    
}
```

# Aufgabe
Ausprobieren und Rumspielen! Mit Tags!