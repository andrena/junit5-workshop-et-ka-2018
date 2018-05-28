# Extensions WIP

In JUnit 4 gab es die Möglichkeit Rules und Runners zu verwenden, um Code zu bestimmten Zeitpunkten des Testlebenszyklus ausführen zu können. Z.B. gab es die TemporaryFolder Rule um im Test einen Ordner bereitzustellen, der nach Ausführung des Tests gelöscht wird, um Datenmüll zu vermeiden. Ein anderes Beispiel wäre vielleicht Connection Logik zu einer Datenbank, wenn man im Test immer mit einer leeren Datenbank starten möchte. Diese konnte man dann in eine Rule packen, um nicht in jedem Test mit Datenbank interaktion den Code neu schreiben zu müssen.

Die Runners und Rules aus JUnit 4 wurden in JUnit 5 entfernt und durch Extensions ersetzt.

Eine Extension ist eine Java Klasse, die eines der Interfaces aus org.junit.jupiter.api.extension implementiert.
Sie darf *keinen eigenen State* haben! Man kann aber Objekte in einem von JUnit gemanagtem Store (der im Wesentlichen eine Map<String, Object> ist und nach beenden des Tests gelöscht wird) ablegen und wieder holen.

## LifeCycle Extensions
Einige der Extension-Interfaces beeinflussen den Lifecycle eines Tests. Für eine Übersicht der Reihenfolge siehe dieser (und weiterer Annotationen) siehe:
![Reihenfolge von Lifecycle Extensions](https://junit.org/junit5/docs/current/user-guide/images/extensions_lifecycle.png)

Eine Liste aller Interfaces ist in der [Package-Summary](https://junit.org/junit5/docs/5.0.3/api/org/junit/jupiter/api/extension/package-summary.html) einsehbar.
Weitere Informationen zu Extensions findet ihr u.a. [hier](https://junit.org/junit5/docs/current/user-guide/#extensions)

## Für die Übung relevante Extensions
| Interface | Description |
| ---------- |:----------:|
| ExtensionContext.Store | Store provides methods for extensions to save and retrieve data. |
| ParameterResolver | ParameterResolver defines the API for Extensions that wish to dynamically resolve arguments for parameters at runtime. |

Eine Beispielhafte implementierung der extensions findet ihr hier: