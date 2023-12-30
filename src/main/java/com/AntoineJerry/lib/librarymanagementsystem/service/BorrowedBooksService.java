package com.AntoineJerry.lib.librarymanagementsystem.service;

import com.AntoineJerry.lib.librarymanagementsystem.model.Books;
import com.AntoineJerry.lib.librarymanagementsystem.model.BorrowedBooks;
import com.AntoineJerry.lib.librarymanagementsystem.model.Users;
import com.AntoineJerry.lib.librarymanagementsystem.repository.BooksRepository;
import com.AntoineJerry.lib.librarymanagementsystem.repository.BorrowedBooksRepository;
import com.AntoineJerry.lib.librarymanagementsystem.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BorrowedBooksService {

    public BorrowedBooksRepository borrowedBooksRepository;
    public BooksRepository booksRepository;
    public UsersRepository usersRepository;

    @CacheEvict(value = "addBorrowedBooks", allEntries = true)
    public BorrowedBooks addBorrowedBooks(BorrowedBooks borrowedBooks) {
        Books books = booksRepository.findById(borrowedBooks.getBooks().getId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        Users users = usersRepository.findById(borrowedBooks.getUsers().getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        borrowedBooks.setBooks(books);
        borrowedBooks.setUsers(users);

        return borrowedBooksRepository.save(borrowedBooks);
    }

    public BorrowedBooks findBorrowedBooksById(int id) {
        return borrowedBooksRepository.findById(id).orElseThrow(null);
    }

    public BorrowedBooks findBorrowedBooksByAuthorName(String bookAuthor) {
        return (BorrowedBooks) borrowedBooksRepository.findByAuthorName(bookAuthor);
    }

    public BorrowedBooks findBorrowedBooksByBookName(String bookName) {
        return (BorrowedBooks) borrowedBooksRepository.findByBookName(bookName);
    }
}
