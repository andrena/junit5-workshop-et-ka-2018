package extensions.builder;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import library.Book;
import library.BookState;

public class BookBuilderExtension implements ParameterResolver {

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().getType().equals(Book.class);
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		Book someBook = new Book("ISBN-" + parameterContext.getIndex(), "SomeBook-" + parameterContext.getIndex());
		Optional<BookState> map = Optional
				.ofNullable(parameterContext.getParameter().getAnnotation(WithBookState.class))
				.map(WithBookState::value);
		someBook.setState(map.orElse(BookState.AVAILABLE));
		return someBook;
	}

}
