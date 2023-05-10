package io.learning.bookshop.security.Repositories;

import io.learning.bookshop.security.Models.Role;
import io.learning.bookshop.security.Models.User;

import java.util.Set;

public interface Customuser {

    String getUsername();
    String getEmail();
    Set<Role> getRoles();
}
