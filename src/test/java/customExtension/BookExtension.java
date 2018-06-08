package customExtension;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import library.Book;

public class BookExtension implements ParameterResolver {

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().getType().equals(Book.class);
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		Store store = extensionContext.getStore(ExtensionContext.Namespace.create(getClass(), extensionContext));

		@SuppressWarnings("unchecked")
		List<String> alreadyUsed = store.getOrComputeIfAbsent("alreadyUsedIsbns", key -> new ArrayList<String>(),
				List.class);

		int i = 1;
		String isbn = Integer.toString(i);
		while (alreadyUsed.stream().anyMatch(isbn::equals)) {
			i++;
			isbn = Integer.toString(i);
		}
		alreadyUsed.add(isbn);
		return new Book(isbn, "someTitle-" + i);
	}

}
