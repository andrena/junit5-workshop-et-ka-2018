package library.isbn;

import java.util.ArrayList;
import java.util.List;

public class ISBNValidator {
	
	private static final List<ISBNType> types = getISBNTypes();

	private static List<ISBNType> getISBNTypes() {
		List<ISBNType> types = new ArrayList<ISBNType>();
		types.add(new ISBN10());
		return types;
	}

	public boolean validate(String iSBN) throws InvalidISBNException {
		for (ISBNType isbnType : types) {
			if(isbnType.isOfType(iSBN)) {
				return true;
			}
		}
        throw new InvalidISBNException(iSBN);
	} 

}
