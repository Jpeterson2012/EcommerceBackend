package io.learning.bookshop.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"${fe.url}"}, allowCredentials = "true")
@Secured("permitAll")
public class BooksController {
    private static final Logger logger = LoggerFactory.getLogger(BooksController.class);


    @Autowired
    BooksService booksService;

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

    @RequestMapping("/books/total/name")
    public int getSearchTotal(@RequestParam String query) {return booksService.getSearchTotal(query);}

    @RequestMapping("/books/total/auth")
    public int getSearchTotal2(@RequestParam String query) {return booksService.getSearchTotal2(query);}

    @RequestMapping("/books/total/isbn")
    public int getSearchTotal3(@RequestParam String query) {return booksService.getSearchTotal3(query);}

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

    @RequestMapping("/books/search/name")
    public List<Books> searchBooks(@RequestParam String query) {
        logger.info("The path variable 'type' is: {}", query);
        return booksService.searchBooks(query);
    }
    @RequestMapping("/books/search/auth")
    public List<Books> searchBooks2(@RequestParam String query) {return booksService.searchBooks2(query);}

    @RequestMapping("/books/search/isbn")
    public List<Books> searchBooks3(@RequestParam String query) {return booksService.searchBooks3(query);}

    @RequestMapping("/books/favorites")
    public void addFavorites(@RequestParam int user_id, @RequestParam int book_id) {booksService.addFavorites(user_id, book_id);}

    @DeleteMapping("/books/favorites")
    public void DeleteFavorites(@RequestParam int user_id, @RequestParam int book_id) {booksService.deleteFavorites(user_id, book_id);}

    @RequestMapping("/books/favorites/{id}")
    public List<Integer> getFavorites(@PathVariable int id) {return booksService.getFavorites(id);}

    @RequestMapping("books/ubooks")
    public List<Books> getUserBooks(@RequestParam List <Integer> ubooks) {
        logger.info("The path variable 'type' is: {}", ubooks);
        return booksService.getUserBooks(ubooks);
    }

}
