# Test Suites

In JUnit 4 k�nnen Klassen in Test Suites zur gemeinsamen Ausf�hrung geb�ndelt werden.

Mit JUnit 5 wird die Annotation `@Suites.SuiteClasses` durch `@SelectClasses` ersetzt. 

Um JUnit 5 Suites in JUnit 4 zu nutzen werden folgende Abh�nigkeiten ben�tigt.

```groovy
compile group: 'org.junit.platform', name: 'junit-platform-suite-api', version: '1.2.0'
testCompile group: 'org.junit.platform', name: 'junit-platform-runner', version: '1.2.0'
```

Dann k�nnen die Suites wie folgt aussehen.

```java
@RunWith(JUnitPlatform.class)
@SelectClasses({RentCalculatorJunit4Test.class})
@SelectPackages({"expectedException"})
@IncludeTags({"short","long"})
public class TestSuite{
}
```

Die Suites Umsetzung von JUnit 5 ist derzeit noch nicht vollst�ndig.
Der Fortschritt kann unter [JUnit 5 Repository: Issues - Suites](https://github.com/junit-team/junit5/labels/theme%3A%20suites) betrachtet werden.

# Aufgabe
Das Packet Testsuites enth�lt zwei Testsuites einmal BasicTestSuite und LongRunningTests.

 * Stelle BasicTestSuite auf JUnit 5 um und verwende `@SelectPackages`
 * Stelle LongRunningTests auf JUnit 5 um und verwende `@IncludeTags`

# L�sung

```java
@RunWith(JUnitPlatform.class)
@SelectClasses({RentCalculatorJunit4Test.class})
@SelectPackages({"expectedException"})
@IncludeTags({"short","long"})
public class RequiresJmqSuite {
}
```