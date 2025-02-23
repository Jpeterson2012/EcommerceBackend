package io.learning.bookshop.books;
import java.util.List;
import org.springframework.data.jpa.repository.Query;



import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Integer> {
    @Query(value = "SELECT * FROM books ORDER BY id LIMIT ?1, 100", nativeQuery = true)
    List<Books> findPaginated(int id);
}
