package extensions.temporaryFolder;

import java.io.File;
import java.io.IOException;

public class TemporaryFolder {

	private File root;

	protected File getRoot() throws IOException {
		if (root == null) {
			root = createTemporaryFolder(null);
		}
		return root;
	}

	public void delete() {
		if (root != null) {
			recursiveDelete(root);
			root = null;
		}
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

	private File createTemporaryFolder(File base) throws IOException {
		File createdFolder = File.createTempFile("junit", "", base);
		createdFolder.delete();
		createdFolder.mkdir();
		return createdFolder;
	}

	private void recursiveDelete(File file) {
		File[] files = file.listFiles();
		if (files != null) {
			for (File each : files) {
				recursiveDelete(each);
			}
		}

		if (!file.delete()) {
			file.deleteOnExit();
		}
	}
}
