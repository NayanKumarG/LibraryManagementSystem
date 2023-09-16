package com.accio.librarymanagementsystem.model;

import com.accio.librarymanagementsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

//@Table(name = "student_info" )
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;

//    @Column( name = "student_name")
    String name;

    int age;

    @Column(unique = true , nullable = false)
    String email;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "student" , cascade = CascadeType.ALL) // student is variable we used in librarycard entity. cascading because any changes crud to the parent it apply for child also.
    LibraryCard libraryCard;
}
