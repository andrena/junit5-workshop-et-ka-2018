package library.persistence;

import library.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void add(Book Book) {
        bookRepository.save(Book);
    }

	@Transactional
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public void addAll(Collection<Book> Books) {
        for (Book Book : Books) {
            bookRepository.save(Book);
        }
    }

	@Transactional
    public List<Book> findByTitleContainingIgnoreCase(String searchString) {
		return bookRepository.findByTitleContainingIgnoreCase(searchString);
    }
}