package temporaryFolder;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class TemporaryFolderExtension implements ParameterResolver, AfterTestExecutionCallback {

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		Store store = context.getStore(ExtensionContext.Namespace.create(getClass(), context));
		TemporaryFolder temporaryFolder = store.get("temporaryFolder", TemporaryFolder.class);
		if (temporaryFolder != null) {
			temporaryFolder.delete();
		}
	}

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().getType().equals(TemporaryFolder.class);
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		Store store = extensionContext.getStore(ExtensionContext.Namespace.create(getClass(), extensionContext));

		TemporaryFolder temporaryFolder = store.getOrComputeIfAbsent("temporaryFolder", key -> new TemporaryFolder(),
				TemporaryFolder.class);

		return temporaryFolder;
	}

}
