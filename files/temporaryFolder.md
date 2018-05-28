# TemporaryFolder Extension

In JUnit 4 gab es die TemporaryFolder Rule. Diese hat methoden wie newFile, newFolder bereitgestellt, über die im Test Verzeichnisse bzw Dateien angelegt werden konnten, die nach Durchlaufen des Tests gelöscht werden.

Für JUnit 5 gibt es stand heute noch keine solche Extension, es gibt aber bereits ein github issue für das Projekt [junit-pioneer](https://github.com/junit-pioneer/junit-pioneer/issues/39) das derzeit in Arbeit ist, indem so eine Extension implementiert werden wird.


Da das ganze aber eine gute Übung und auch nicht sehr kompliziert ist, ist die nächste Aufgabe diese Rule als Extension selbst zu implementieren.

Dazu könnt ihr die Klasse TemporaryFolder als Hilfestellung nutzen, die im Wesentlichen die Methoden aus der JUnit4 Rule nach implementiert und die ihr in eurer neuen Extension benutzen könnt.

## Für die Übung relevante Extensions
| Interface | Description |
| ---------- |:----------:|
| ExtensionContext.Store | Store provides methods for extensions to save and retrieve data. |
| ParameterResolver | ParameterResolver defines the API for Extensions that wish to dynamically resolve arguments for parameters at runtime. |
| AfterTestExecutionCallback | AfterTestExecutionCallback defines the API for Extensions that wish to provide additional behavior to tests immediately after each test has been executed. |

### Hinweis
Vergesst nicht am Ende des Tests über die afterTestExecution Methode der AfterTestExecutionCallback die delete Methode aufzurufen.

### TemporaryFolder
Hier eine beispielhafte Implementierung einer TemporaryFolder Klasse (inspiriert durch [org.junit.rules.TemporaryFolder](https://github.com/junit-team/junit4/blob/master/src/main/java/org/junit/rules/TemporaryFolder.java) )

```
import java.io.File;
import java.io.IOException;

public class TemporaryFolder {

	private File root;

	public void delete() {
		if (root != null) {
			recursiveDelete(root);
		}
	}

	private void recursiveDelete(File file) {
		File[] files = file.listFiles();
		if (files != null) {
			for (File each : files) {
				recursiveDelete(each);
			}
		}
		file.delete();
	}
	
	public File newFile(String fileName) throws IOException {
		File file = new File(getRoot(), fileName);
		if (!file.createNewFile()) {
			throw new IOException(String.format("failed to create file %s in folder %s", fileName, getRoot()));
		}
		return file;
	}

	public File newFile() throws IOException {
		return File.createTempFile("junit", null, getRoot());
	}

	public File newFolder() throws IOException {
		return createTemporaryFolder(getRoot());
	}
	
	private File getRoot() throws IOException {
		if (root == null) {
			root = createTemporaryFolder(null);
		}
		return root;
	}

	private File createTemporaryFolder(File base) throws IOException {
		File createdFolder = File.createTempFile("junit", "", base);
		createdFolder.delete();
		createdFolder.mkdir();
		return createdFolder;
	}

}

```
