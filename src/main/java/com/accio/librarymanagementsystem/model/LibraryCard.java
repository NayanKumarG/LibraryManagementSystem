package com.accio.librarymanagementsystem.model;

import com.accio.librarymanagementsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cardNo;

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @CreationTimestamp
    Date issueDate;

    @OneToOne //first one for current class.
    @JoinColumn //by default will create fk column from primary key
    Student student;
}
