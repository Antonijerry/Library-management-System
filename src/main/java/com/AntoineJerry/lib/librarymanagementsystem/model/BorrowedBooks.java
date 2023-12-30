package com.AntoineJerry.lib.librarymanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "borrowed_books")
public class BorrowedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_name")
    @Length(min = 6, max = 20, message = "Enter the name of the book")
    private String bookName;

    @Column(name = "book_author")
    @Length(min = 6, max = 20, message = "Enter the name of the author")
    private String bookAuthor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books books;

}
