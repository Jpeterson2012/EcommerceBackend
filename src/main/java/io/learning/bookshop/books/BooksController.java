package io.learning.bookshop.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import io.learning.bookshop.security.Services.UserService;

import java.util.List;
import java.util.Optional;



@RestController
@CrossOrigin(origins = {"${fe.url}"}, allowCredentials = "true")
@Secured("permitAll")
public class BooksController {
    @Autowired
    BooksService booksService;
    @Autowired
    UserService userService;


    @RequestMapping("/books")
    public List<Books> getAllBooks() {return booksService.getAllBooks();};

    @RequestMapping("/books/{id}")
    public Optional<Books> getBooks(@PathVariable int id) {
        return booksService.getBook(id);
    }

    @RequestMapping("/books/p")
    public List<Books> findPaginated(@RequestParam int page, @RequestParam int pageSize) {
        return booksService.findPaginated(page, pageSize);
    }

    @RequestMapping("/books/total")
    public int getDBTotal() {return booksService.getDBTotal();}

    @PostMapping("/books")
    public void addBooks(@RequestBody Books books) {
        booksService.addBooks(books);
    }

    @PutMapping("/books/{id}")
    public void updateBooks(@PathVariable int id, @RequestBody Books books) {
        booksService.updateBooks(id, books);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBooks(@PathVariable int id) {
        booksService.deleteBooks(id);
    }

    @RequestMapping("/books/role")
    public void setNewRole(@RequestParam int userid, @RequestParam int roleid) {userService.setNewRole(userid, roleid);}
}
