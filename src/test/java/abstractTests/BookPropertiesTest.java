package abstractTests;

import library.Book;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public abstract class BookPropertiesTest {

    public abstract Book createBook();

    @Test
    public void testPageCountHasPages() {
        Book book = createBook();
        assertThat(book.getPageCount()).isEqualTo(0);
    }

    @Test
    public void testBookHasTitle() {
        Book book = createBook();
        assertThat(book.getTitle()).isNotNull();
        assertFalse(book.getTitle().isEmpty());
    }

}
