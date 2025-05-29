package io.learning.bookshop.books;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BooksRepository extends CrudRepository<Books, Integer> {
    @Query(value = "SELECT * FROM books ORDER BY id LIMIT ?1, ?2", nativeQuery = true)
    List<Books> findPaginated(int page, int pageSize);

    @Query(value = "SELECT COUNT(*) FROM books", nativeQuery = true)
    int getDBTotal();

    @Query(value = "SELECT COUNT(*) FROM books WHERE name LIKE %?1%", nativeQuery = true)
    int getSearchTotal(String query);

    @Query(value = "SELECT COUNT(*) FROM books WHERE auth LIKE %?1%", nativeQuery = true)
    int getSearchTotal2(String query);

    @Query(value = "SELECT COUNT(*) FROM books WHERE isbn LIKE %?1%", nativeQuery = true)
    int getSearchTotal3(String query);

    @Query(value = "SELECT * FROM books WHERE name LIKE %?1% LIMIT ?2, 20", nativeQuery = true )
    List<Books> searchBooks(String query, int page);

    @Query(value = "SELECT * FROM books WHERE auth LIKE %?1% LIMIT ?2, 20", nativeQuery = true )
    List<Books> searchBooks2(String query, int page);

    @Query(value = "SELECT * FROM books WHERE isbn LIKE %?1% LIMIT ?2, 20", nativeQuery = true )
    List<Books> searchBooks3(String query, int page);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO favorites VALUES(?1,?2)", nativeQuery = true)
    void addFavorites(int user_id, int book_id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM favorites WHERE user_id = ?1 AND book_id = ?2", nativeQuery = true)
    void deleteFavorites(int user_id, int book_id);

    @Query(value = "SELECT book_id FROM favorites WHERE user_id = ?1", nativeQuery = true)
    List<Integer> getFavorites(int user_id);

    @Query(value = "SELECT * FROM books WHERE id in (:ubooks)", nativeQuery = true)
    List<Books> getUserBooks(@Param("ubooks") List<Integer> ubooks);

    @Query(value = "INSERT INTO cart VALUES(?1,?2,?3) ON DUPLICATE KEY UPDATE qty = ?3", nativeQuery = true)
    void addCartData(int user_id, int book_id, int qty);

}
