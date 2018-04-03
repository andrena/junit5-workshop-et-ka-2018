package extensions.temporaryFolder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.function.Function;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class TemporaryFolderExtension implements ParameterResolver, AfterTestExecutionCallback {
	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		cleanUpTemporaryFolder(context);

		if (context.getParent().isPresent()) {
			cleanUpTemporaryFolder(context.getParent().get());
		}

	}

	private void cleanUpTemporaryFolder(ExtensionContext extensionContext) {
		Store store = getStore(extensionContext);
		TemporaryFolder temporaryFolder = store.get(getTestClassName(extensionContext), TemporaryFolder.class);

		if (temporaryFolder != null) {
			temporaryFolder.delete();
		}
	}

	private ExtensionContext.Store getStore(ExtensionContext context) {
		return context.getStore(ExtensionContext.Namespace.create(getClass(), context));
	}

	private String getTestClassName(ExtensionContext extensionContext) {
		return extensionContext.getTestClass().get().getName();
	}

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		Parameter parameter = parameterContext.getParameter();
		boolean parameterIsTemporaryFolder = parameter.getType().isAssignableFrom(TemporaryFolder.class);
		boolean parameterIsFileAndAnnotated = parameter.getType().isAssignableFrom(File.class)
				&& (parameter.isAnnotationPresent(TempFolder.class) || parameter.isAnnotationPresent(TempFile.class));
		return parameterIsTemporaryFolder || parameterIsFileAndAnnotated;
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		try {
			TemporaryFolder temporaryFolder = createTemporaryFolderInStore(extensionContext);

			Parameter parameter = parameterContext.getParameter();
			if (parameter.getType().isAssignableFrom(TemporaryFolder.class)) {
				return temporaryFolder;
			}
			if (parameter.isAnnotationPresent(TempFolder.class)) {
				return temporaryFolder.newFolder();
			}
			if (parameter.isAnnotationPresent(TempFile.class)) {
				return temporaryFolder.newFile();
			}
			throw new ParameterResolutionException("unable to resolve parameter for " + parameterContext);
		} catch (IOException e) {
			throw new ParameterResolutionException("failed to create temp file or folder", e);
		}
	}

	private TemporaryFolder createTemporaryFolderInStore(ExtensionContext extensionContext) {
		Store store = getStore(extensionContext);
		Function<String, TemporaryFolder> storeValueCreator = (String key) -> new TemporaryFolder();

		return store.getOrComputeIfAbsent(getTestClassName(extensionContext), storeValueCreator, TemporaryFolder.class);
	}

}