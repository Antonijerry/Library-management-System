package com.AntoineJerry.lib.librarymanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books_library")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_title")
    @Length(min = 10, max = 40, message = "Enter the book title")
    private String title;

    @Length(min = 6, max = 15, message = "Enter the correct author name")
    private String author;

    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String isbn;

    @Column(name = "publication_year")
    private int publicationYear;


}
