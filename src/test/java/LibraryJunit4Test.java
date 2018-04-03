import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.Test;

public class LibraryJunit4Test {

	
	@Test
	public void someJunit4Test() {
		Library library = new Library();
		assertTrue("Text", library.someLibraryMethod());
	}
	
	@Test
	public void foo() throws Exception {
		Library library = new Library();

		TimeZone timeZone = TimeZone.getTimeZone(TimeZone.getAvailableIDs()[3]);
		TimeZone.setDefault(timeZone);
	}
}
