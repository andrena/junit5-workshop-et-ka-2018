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

Um Suites in JUnit 5 zu verwenden muss derzeit noch der `vintage Runner`
von `junit-platform-runner` ausgenommen werden.

```groovy
testCompile('org.junit.platform:junit-platform-runner:1.2.0') {
    exclude group: 'junit', module: 'junit' 
}
```  

```java
@Suite
@IncludeClassNamePatterns("**/*JmqITs")   
public class RequiresJmqSuite {
	
	@BeforeSuite
	void setUpJmqConnection() { ... }
	
	@AfterSuite
	void tearDownJmqConnection() { ... }

}
```

# Aufgabe
Das Packet Testsuites enth�lt zwei Testsuites einmal BasicTestSuite und LongRunningTests.

 * Stelle BasicTestSuite auf JUnit 5 um und verwende `@SelectPackages`
 * Stelle LongRunningTests auf JUnit 5 um und verwende `@IncludeTags`

# L�sung

```java
@Suite
@IncludeClassNamePatterns("**/*JmqITs")
@SuiteDisplayName("Sammlung kleiner Tests")
@SelectClasses({RentCalculatorJunit4Test.class})
@SelectPackages({"expectedException"})
@IncludeTags({"short","long"})
public class RequiresJmqSuite {
	
	@BeforeSuite
	void setUpJmqConnection() { ... }
	
	@AfterSuite
	void tearDownJmqConnection() { ... }

}
```