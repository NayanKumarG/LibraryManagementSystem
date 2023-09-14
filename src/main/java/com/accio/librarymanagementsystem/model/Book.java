package com.accio.librarymanagementsystem.model;

import com.accio.librarymanagementsystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    int noofpage;

    @Enumerated(EnumType.STRING)
    Genre genre;

    double cost;

    @ManyToOne
    @JoinColumn
    Author author;
}
