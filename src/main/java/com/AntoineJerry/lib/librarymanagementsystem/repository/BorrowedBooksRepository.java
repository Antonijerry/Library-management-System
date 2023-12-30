package com.AntoineJerry.lib.librarymanagementsystem.repository;

import com.AntoineJerry.lib.librarymanagementsystem.model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Integer> {

    List<BorrowedBooks> findByAuthorName(String bookAuthor);

    List<BorrowedBooks> findByBookName(String bookName);
}
