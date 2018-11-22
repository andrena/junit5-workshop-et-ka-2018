
# JUnit 5: Das will ich jetzt auch benutzen!

„Ich möchte JUnit 5 benutzen, habe aber keine Ahnung, wie ich eigentlich anfangen soll...“
Probieren wir es doch einfach und fangen an. Heute!
JUnit 4 war in den letzten Jahren eines der meist verwendeten Frameworks, um Anwendungen automatisiert zu testen. Mit JUnit 5 steht jetzt der Nachfolger in den Startlöchern. Viele Entwickler fragen sich nun: Upgrade? Und wenn ja, wie?
In diesem Workshop werden wir gemeinsam eine JUnit 4-Lösung umstellen auf JUnit 5 – in kleinen, überschaubaren Schritten.

# Projekt
Als Beispiel Projekt nutzten wir eine Bibliotheksverwaltungssoftware.
Diese wurde mit JUnit 4 getestet. Wir haben uns jetzt als Team dazu entschieden JUnit 5 einzusetzen.

Da die Software sich noch in einem frühen Entwicklungsstatus befindet, wollen wir alle bestehenden Tests nach JUnit 5 umschreiben und die Abhängigkeit auf JUnit 4 ablösen.

## Themen

* [Annotation](files/01annotations.md)
* [Exceptions](files/02exceptions.md)
* [Hamcrest und AssertJ](files/03hamcrestUndAssertJ.md)
* [Extensions - Einführung](files/04_1extensions.md)
* [Extensions - Temporary Folder](files/04_2temporaryFolder.md)
* [Mocken](files/05mocks.md)
* [Abstract Tests](files/06abstractTests.md)
* [Nested Tests](files/07nestedTests.md)
* [Parametrized Tests](files/08parametrizedTests.md)
* [Timeouts](files/09timeouts.md)
* [Test Suites](files/10testsuites.md)

## Gradle Konfiguration
Zum Einbinden in JUnit 5 muss die [build.gradle-Datei](build.gradle) angepasst werden.

JUnit 5 verwendet einen modularen Ansatz, daher muss mehr als eine Anhängigkeit eingebunden werden.

Um JUnit 4 und 5 in unserem Projekt gleichzeitig einsetzten zu können, werden folgende Anhängigkeiten benötigt.  
Um verschiedene TestEngines laufen zu lassen, benötigen wir die JUnit Platform.
Das Modul JUnit Vintage bietet uns TestEngines um JUnit 3 und JUnit 4 Tests auf der JUnit 5 Plattform auszuführen.
   
 `org.junit.platform:junit-platform-launcher:1.1.1` 
 `org.junit.vintage:junit-vintage-engine:5.1.1`
 
Prinzipiell können wir damit JUnit 4 Test ausführen.

Um JUnit 4 Rules weiter nutzten zu können benötigten wird jedoch noch das Modul JUnit Jupiter Migrationssupport, 
da mit JUnit 5 sollen keine Rules mehr eingesetzt werden.

 `org.junit.jupiter:junit-jupiter-migrationsupport`
 
Die JUnit Jupiter Engine ermöglicht es uns JUnit 5 Test über die Plattform auszuführen, die wir mithilfe der JUnit Jupiter API geschrieben haben.
 
 `org.junit.jupiter:junit-jupiter-api:5.1.1`
 `org.junit.jupiter:junit-jupiter-engine:5.1.1`

## Parametrisierte Tests
Das Ausführen von Parametrisierten Test mit JUnit 5 funktioniert nicht out of the box dazu wird das Modul JUnit Jupiter-Params benötigt.

`org.junit.jupiter:junit-jupiter-params`

## Von:
* Claudia Fuhrmann
* Dirk Tröndle
* Felix Schlosser
* Johannes Göring 
