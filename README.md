
# JUnit 5: Das will ich jetzt auch benutzen!

„Ich möchte JUnit 5 benutzen, habe aber keine Ahnung, wie ich eigentlich anfangen soll...“
Probieren wir es doch einfach und fangen an. Heute!
JUnit 4 war in den letzten Jahren eines der meist verwendeten Frameworks, um Anwendungen automatisiert zu testen. Mit JUnit 5 steht jetzt der Nachfolger in den Startlöchern. Viele Entwickler fragen sich nun: Upgrade? Und wenn ja, wie?
In diesem Workshop werden wir gemeinsam eine JUnit 4-Lösung umstellen auf JUnit 5 – in kleinen, überschaubaren Schritten.

# Themen

* [Annotation](files/Annotations.md)
* [Exceptions](files/ExpectedException.md)
* [Hamcrest und AssertJ](files/hamcrest.md)
* [Extensions](files/extensions.md)
* [Test Suites](files/Testsuites.md)
* [Abstract Tests](files/abstractTests.md)

## JUnit 5 einbinden
Zum Einbinden in JUnit 5 muss die [build.gradle-Datei](build.gradle) angepasst werden.

JUnit 5 verwendet einen Modularen Ansatz, daher müssen mehrere Dependencies eingebunden werden.

 Um JUnit 4 und 5 in unserem Projekt gleichzeitig einsetzten zu können werden folgende Anhänigkeiten benötigt.  
 Um verschiedene TestEngines laufen zu lassen benötigen wir die JUnit Platform.
 Das Modul JUnit Vintage bietet uns TestEngines um JUnit 3 und 4 auf der Platform Test auszuführen.
   
 org.junit.platform:junit-platform-launcher 
 org.junit.vintage:junit-vintage-engine
 
 Prinzipjell können wir damit JUnit 4 Test ausführen um JUnit 4 Rules weiter nutzten zu können benötigten wird jedoch noch das Modul JUnit Jupiter Migrationsupport.
 Denn mit JUnit 5 sollen keine Rules mehr eingesetzt werden.  
 
 org.junit.jupiter:junit-jupiter-migrationsupport
 
 Die JUnit Jupiter Engine ermöglicht es uns JUnit 5 Test über die Platform auszuführen, die wir mit hilfe der JUnit Jupiter API geschrieben haben. 
 
 org.junit.jupiter:junit-jupiter-api
 org.junit.jupiter:junit-jupiter-engine

## Annotationen

## Exceptions


## Parametrisierte Tests
org.junit.jupiter:junit-jupiter-params


# Von:
* Claudia Fuhrmann
* Dirk Tröndle
* Felix Schlosser
* Johannes Göring 
