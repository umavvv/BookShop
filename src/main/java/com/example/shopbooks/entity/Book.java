package com.example.shopbooks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.File;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private Long price;
    private String image;

}
