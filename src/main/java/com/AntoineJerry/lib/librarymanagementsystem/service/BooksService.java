package com.AntoineJerry.lib.librarymanagementsystem.service;

import com.AntoineJerry.lib.librarymanagementsystem.model.Books;
import com.AntoineJerry.lib.librarymanagementsystem.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {


    private BooksRepository booksRepository;

    @CacheEvict(value = "allBooks", allEntries = true)
    public Books addBook(Books books){
        return booksRepository.save(books);
    };

    @Cacheable("allBooks")
    public List <Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @CacheEvict(value = "allBooks", allEntries = true)
    public Books deleteBook(Integer id) {
        Books books = findBookById(id);
        booksRepository.deleteById(id);
        return books;
    }

    public Books findBookById(int id) {
        return booksRepository.findById(id).orElseThrow(null);
    }

    public List<Books> findBookByTitle(String title) {
        return booksRepository.findByTitleIgnoreCase(title);
    }

    public List<Books> findBookByISBNNo(String isbn) {
        return booksRepository.findByIsbnIgnoreCase(isbn);
    }
}
