package io.learning.bookshop.security.Services;

import io.learning.bookshop.books.Books;
import io.learning.bookshop.security.Models.*;
import io.learning.bookshop.security.Repositories.Customuser;
import io.learning.bookshop.security.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<Customuser> getUsers(){
        List<Customuser> users = new ArrayList<>();
        userRepository.findAllProjectedBy()
                .forEach(users::add);
        return users;
    }
    public void setNewRole(int userid, int roleid){userRepository.setNewRole(userid, roleid);}

    public void resetPassword(int userid, String pw){userRepository.resetPassword(userid,pw);}
}
