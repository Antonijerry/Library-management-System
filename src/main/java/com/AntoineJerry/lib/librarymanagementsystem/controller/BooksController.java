package com.AntoineJerry.lib.librarymanagementsystem.controller;


import com.AntoineJerry.lib.librarymanagementsystem.model.Books;
import com.AntoineJerry.lib.librarymanagementsystem.model.BorrowedBooks;
import com.AntoineJerry.lib.librarymanagementsystem.service.BooksService;
import com.AntoineJerry.lib.librarymanagementsystem.service.BorrowedBooksService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
public class BooksController {


    public BooksService booksService;
    public BorrowedBooksService borrowedBooksService;

    //to get all books /end point
    @GetMapping("")
    public ResponseEntity<List<Books>> getAllBooks(){
        return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
    }

    //to add book to the library /end point
    @PostMapping("")
    public ResponseEntity<Books> addBook(@RequestBody Books books){
        return new ResponseEntity<>(booksService.addBook(books), HttpStatus.CREATED);
    }

    //to borrow a book and add to the Borrowed-book library /end point
    @PostMapping("/borrow")
    public ResponseEntity<BorrowedBooks> borrowBook(@RequestBody @Valid BorrowedBooks borrowedBooks){
        return new ResponseEntity<>(borrowedBooksService.addBorrowedBooks(borrowedBooks), HttpStatus.CREATED);
    }

    //to get a borrowed book by id
    @GetMapping("/borrowed-book/{id}")
    public ResponseEntity<BorrowedBooks> getBorrowedBooksById(@PathVariable int id) {
        return new ResponseEntity<>(borrowedBooksService.findBorrowedBooksById(id), HttpStatus.OK);
    }
     // to search for borrowed books by their author name /end point
    @GetMapping("/borrowed-book-author/{id}")
    public ResponseEntity<BorrowedBooks>  getBorrowedBooksByAuthorName(@PathVariable String bookAuthor){
        return new ResponseEntity<>(borrowedBooksService.findBorrowedBooksByAuthorName(bookAuthor), HttpStatus.OK);
    }

    //to search for borrowed books by their book name /end point
    @GetMapping("/borrowed-book-name/{id}")
    public ResponseEntity<BorrowedBooks> getBorrowedbooksByBookName(@PathVariable String bookName){
        return new ResponseEntity<>(borrowedBooksService.findBorrowedBooksByBookName(bookName), HttpStatus.OK);
    }
    //to delete a book /end point
    @DeleteMapping("/{id}")
    public Books deleteBook(@PathVariable("id") int id){
        return booksService.deleteBook(id);
    }

    //to find a book by id /end point
    @GetMapping("/{id}")
    public ResponseEntity<Books> findBookById(@PathVariable("id") int id) {
        return new ResponseEntity<>(booksService.findBookById(id), HttpStatus.OK);
    }

    //find a book by the book title /end point
    @GetMapping("/title/{title}")
    public List<Books> findBookByTitle(@PathVariable String title){
         return booksService.findBookByTitle(title);
    }

    //find a book by the book isbn /end point
    @GetMapping("/isbn/{isbn}")
    public List<Books> findBookByISBNNo(@PathVariable("isbn") String isbn){
        return booksService.findBookByISBNNo(isbn);
    }
}
