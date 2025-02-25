package io.learning.bookshop.security.Repositories;

import io.learning.bookshop.security.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<Customuser> findAllProjectedBy();

    @Query(value = "UPDATE user_roles SET role_id = ?2 WHERE user_id = ?1", nativeQuery = true)
    void setNewRole(int user_id, int role_id);

}
