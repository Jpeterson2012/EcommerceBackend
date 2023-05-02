package io.learning.bookshop.security.Repositories;


import java.util.Optional;

import io.learning.bookshop.security.Models.Role;
import io.learning.bookshop.security.Models.Erole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> { Optional<Role> findByName(Erole name);
}
