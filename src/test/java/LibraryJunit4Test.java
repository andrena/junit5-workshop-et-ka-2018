import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LibraryJunit4Test {

	
	@Test
	public void someJunit4Test() {
		Library library = new Library();
		assertTrue("Text", library.someLibraryMethod());
	
	}
}
