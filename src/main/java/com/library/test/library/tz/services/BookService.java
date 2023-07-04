package com.library.test.library.tz.services;

import com.library.test.library.tz.models.Book;
import com.library.test.library.tz.models.User;
import com.library.test.library.tz.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
   private final BookRepository bookRepository;

  private final UserService userService;

    @Autowired
    public BookService(BookRepository bookRepository, UserService userService) {
        this.bookRepository = bookRepository;
        this.userService = userService;
    }

    public List<Book> getAllBooks(){
    return     bookRepository.findAll();
    }

    public  Book getBook(int book_id){
        return  bookRepository.findById(book_id).orElseThrow();
    }

    public void addBook (Book book){
        bookRepository.save(book);
    }

    public  void deleteBook(int book_id){
        bookRepository.deleteById(book_id);
    }

    public  void pickupBook(int book_id, int user_id){
        Book book = bookRepository.findById(book_id).orElseThrow();
        book.setOwner(userService.getUserById(user_id));
        bookRepository.save(book);
    }

    public  void returnBook(int book_id){
        Book book = bookRepository.findById(book_id).orElseThrow();
        User user = book.getOwner();
        userService.removeBook(user,book);
        book.setOwner(null);
        bookRepository.save(book);
    }

}
