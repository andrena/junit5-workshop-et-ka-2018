package annotationen;

import library.Book;
import library.LibraryManager;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class LifeCycleAnnotationTest {

    private static Book book = new Book("imei", "title");
    private static Book book1 = new Book("imei1", "title1");
    private static Book book2 = new Book("imei2", "title2");
    private static Book book3 = new Book("imei3", "title3");
    private static Book book4 = new Book("imei4", "title4");

    private static LibraryManager libraryManager = new LibraryManager();
    private static List<Book> booksToRent;

    @BeforeClass
    public static void setup() {
        booksToRent = asList(book, book1, book2, book3, book4);
        libraryManager = new LibraryManager(booksToRent);
    }

    @Test
    public void testName() {

    }
}
