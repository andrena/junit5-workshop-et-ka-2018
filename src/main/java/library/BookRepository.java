package library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByTitleContainingIgnoreCase(String searchString);

	public List<Book> findAll();
}