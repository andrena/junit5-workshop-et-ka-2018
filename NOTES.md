Die Datei müssen wir irgendwann noch zu einer Lesbaren Anleitung umwandeln :)

Hier mal die Use-Cases für die wir im Projekt aktuell Runner/Rules haben:
* Rules
	* ExpectedException - asserts auf Exceptions
	* ErrorCollector - mehrere Asserts auch bei Failure und dann alle Failures gemeinsam ausgeben (für Aufwändigere/integrativere Tests)
	* TimeZoneRule - Custom Rule, die im @Before Timezone.setDefault(myDefault) und im @After Timezone.setDefault(oldDefault) setzt, wobei myDefault ein Konstruktor Argument ist und oldDefault zwischengespeichert wird => Für Tests, die Date Strings parsen, damit man Asserts Platformunabhängig (unterschied lokal vs Jenkins) machen kann
	* TemporaryFolder - falls beim Test I/O Operationen gemacht werden; damit man keine Dateien durch unittests anlegt
	* ApplicationContextModifier (extends ExternalResource) - Custom Rule, in der per Reflection beliebige Beans durch Mock Implementierungen ersetzt werden können (da dies nicht in jedem Projektbereich bei uns einfach per Mockito möglich ist); im @After wird zurück gesetzt
	* RuleChain: OuterRule => RetryRule => RepeatRule => ShopTestContextRule => CleanupRule - wird in unserem Fancy Selenium Projekt genutzt, im Wesentlichen sorgt das dafür, dass Tests n mal wiederholt werden und dass davor Daten in eine DB geschrieben werden und alle Daten, die während dem Test in die DB geschrieben wurden danach wieder aufgeräumt werden
* Runners
	* Categories/Classpathsuite -> Testsuites, z.B. für alle Tests mit @LongRunning Annotation
	* Parametrized
	* MockitoJunitRunner
	* SpringJunitRunner

TODO
* Tests schreiben
	* [NestedTests vs HierarchicalRunner](files/nestedTest.md) (Felix)
	* [Abstract Tests nach Contracts](files/abstractTests.md) (Johannes)
	* [Hamcrest Matchers vs AssertJ](files/hamcrest.md) (Claudia)
		* Showcase einfache Migration
			* manuell einbinden von hamcrest
			* AssertJ funktioniert direkt
	* [Mocken ohne MockitoRunner](files/mocking.md) (Claudia)
	* [TemporaryFolderRule](files/rules.md) (Dirk)
	* TimeZoneRule (Dirk)
	    * Kein Test nach vier
	* [TestSuites](files/Testsuites.md) (Johannes)
		* Fast/LongRunning
		* Integration/Unit/Selenium tests
	* [Junit5 Annotationen](files/annotations.md) (Claudia)
		* Displayname
		* Repeated (vs Rule)
		* Disabled (vs Ignore)
	* [LifeCycle Annotationen](files/annotations.md) (Before, After,...) (Claudia)
	* [Exception Testing assertThrows vs ExpectedException](files/expectedException.md) (Johannes)
	* [Eigene Extension](files/extensions.md) (Dirk)
		* ?
	* [AssertTimeout und Futures](files/timeout.md) (Felix)
	* [Parametrized Tests](files/parametrizedTests.md) (Felix)
	*
* Pro Punkt von Oben >=1 Folie erstellen!
* 