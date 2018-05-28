# Extensions WIP

In JUnit 4 gab es die Möglichkeit Rules und Runners zu verwenden, um Code zu bestimmten Zeitpunkten des Testlebenszyklus ausführen zu können. Z.B. gab es die TemporaryFolder Rule um im Test einen Ordner bereitzustellen, der nach Ausführung des Tests gelöscht wird, um Datenmüll zu vermeiden. Ein anderes Beispiel wäre vielleicht Connection Logik zu einer Datenbank, wenn man im Test immer mit einer leeren Datenbank starten möchte. Diese konnte man dann in eine Rule packen, um nicht in jedem Test mit Datenbank interaktion den Code neu schreiben zu müssen.

Die Runners und Rules aus JUnit 4 wurden in JUnit 5 entfernt und durch Extensions ersetzt.

Eine Extension ist eine Java Klasse, die eines der Interfaces aus org.junit.jupiter.api.extension implementiert.

Sie darf **keinen eigenen State** haben! Man kann aber Objekte in einem von JUnit gemanagtem Store (der im Wesentlichen eine Map<Object, Object> ist und nach beenden des Tests gelöscht wird) ablegen und wieder holen.

## LifeCycle Extensions
Einige der Extension-Interfaces beeinflussen den Lifecycle eines Tests. Für eine Übersicht der Reihenfolge siehe dieser (und weiterer Annotationen) siehe:
![Reihenfolge von Lifecycle Extensions](https://junit.org/junit5/docs/current/user-guide/images/extensions_lifecycle.png)

Eine Liste aller Interfaces ist in der [Package-Summary](https://junit.org/junit5/docs/5.0.3/api/org/junit/jupiter/api/extension/package-summary.html) einsehbar.
Weitere Informationen zu Extensions findet ihr u.a. [hier](https://junit.org/junit5/docs/current/user-guide/#extensions)

## Einbinden von Extensions

## Für die Übung relevante Extensions
| Interface | Description |
| ---------- |:----------:|
| ExtensionContext.Store | Store provides methods for extensions to save and retrieve data. |
| ParameterResolver | ParameterResolver defines the API for Extensions that wish to dynamically resolve arguments for parameters at runtime. |

Eine Beispielhafte Nutzung dieser Extensions kann wie folgt aussehen:

```
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class BookBuilderExtension implements ParameterResolver {

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		// This ParameterResolver can resolve only Parameters of Type int
		return parameterContext.getParameter().getType().equals(int.class);
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		// return a different int for Each Parameter by using Store to save the nextInt to return
		Store store = extensionContext.getStore(ExtensionContext.Namespace.create(getClass(), extensionContext));

		@SuppressWarnings("unchecked")
		List<Integer> alreadyUsed = store.getOrComputeIfAbsent("alreadyUsedIntegers", key->new ArrayList<Integer>(), List.class);
		
		int currentInt= 1;
		while(alreadyUsed.contains(Integer.valueOf(currentInt))) {
			currentInt++;
		}
		alreadyUsed.add(currentInt);
		return currentInt;
	}

}
```
Und der benutzende Test:

```
	@Test
	@ExtendWith(BookBuilderExtension.class)
	void someTestUsingOurExtension(int a, int b, int c) throws Exception {
		assertThat(a).isEqualTo(1);
		assertThat(b).isEqualTo(2);
		assertThat(c).isEqualTo(3);
	}
```

Man kann auch eigene Annotation in der Extension definieren, um genauere Ausprägungen des Parameters zurück zu geben, z.B. direkt eine File oder ein Directory (die beide Instanzen vom Typ File sind) oder ein Objekt, bei dem bestimmte Parameter schon gesetzt sind.

```
@Target({ ElementType.TYPE, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface GreaterThan {
		int value();
	}
	
	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		// return a different int for Each Parameter by using Store to save the nextInt to return
		Store store = extensionContext.getStore(ExtensionContext.Namespace.create(getClass(), extensionContext));

		@SuppressWarnings("unchecked")
		List<Integer> alreadyUsed = store.getOrComputeIfAbsent("alreadyUsedIntegers", key->new ArrayList<Integer>(), List.class);
		
		int currentInt= parameterContext.findAnnotation(GreaterThan.class).map(GreaterThan::value).orElseGet(()->1);
		while(alreadyUsed.contains(Integer.valueOf(currentInt))) {
			currentInt++;
		}
		alreadyUsed.add(currentInt);
		return currentInt;
	}
```

Im Test sieht das dann so aus:

```
	@Test
	@ExtendWith(BookBuilderExtension.class)
	void someTestUsingOurExtension(int a, int b, @GreaterThan(10)int c) throws Exception {
		assertThat(a).isEqualTo(1);
		assertThat(b).isEqualTo(2);
		assertThat(c).isGreaterThan(10);
	}
```