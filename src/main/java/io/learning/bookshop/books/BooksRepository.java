package io.learning.bookshop.books;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;


import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Integer> {
    @Query(value = "SELECT * FROM books ORDER BY id LIMIT ?1, ?2", nativeQuery = true)
    List<Books> findPaginated(int page, int pageSize);

    @Query(value = "SELECT COUNT(*) FROM books", nativeQuery = true)
    int getDBTotal();

    @Modifying
    @Query(value = "UPDATE user_roles SET role_id = ?2 WHERE user_id = ?1", nativeQuery = true)
    void setNewRole(int userid, int roleid);

}
