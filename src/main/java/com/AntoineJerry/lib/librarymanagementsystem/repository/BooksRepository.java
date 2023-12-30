package com.AntoineJerry.lib.librarymanagementsystem.repository;

import com.AntoineJerry.lib.librarymanagementsystem.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

    List<Books> findByTitleIgnoreCase(String title);

    List<Books> findByIsbnIgnoreCase(String isbn);


}
