package com.AntoineJerry.lib.librarymanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user_table")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "full_name")
    @Length(min = 6, max = 15, message = "Enter your first and sur name!")
    private String fullName;

    private int age;

    private String address;

    @Email(message = "Enter Valid email address")
    private String email;

}
