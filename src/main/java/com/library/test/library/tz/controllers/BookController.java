package com.library.test.library.tz.controllers;

import com.library.test.library.tz.DTO.BookDTO;
import com.library.test.library.tz.models.Book;
import com.library.test.library.tz.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private  final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private Book convertToBook(BookDTO bookDTO){
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(bookDTO,Book.class);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.ok("book added");
    }

    @PostMapping("/{bookId}/{userId}")
    public  ResponseEntity<?> setBookToUser(@PathVariable int bookId,
                               @PathVariable int userId){
        bookService.pickupBook(bookId,userId);
        return ResponseEntity.ok("User took the book");
    }

    @PostMapping("/{bookId}")
    public  ResponseEntity<?> returnBook(@PathVariable int bookId){
        bookService.returnBook(bookId);
        return ResponseEntity.ok("User returned the book");
    }

    @DeleteMapping("/{bookId}")
    public  ResponseEntity<?> deleteBook(@PathVariable int bookId){
        bookService.deleteBook(bookId);
        return  ResponseEntity.ok("book was deleted");
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable int bookId){
        return ResponseEntity.ok(bookService.getBook(bookId));
    }
}
