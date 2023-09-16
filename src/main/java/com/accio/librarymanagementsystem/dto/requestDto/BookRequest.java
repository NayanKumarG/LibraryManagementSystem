package com.accio.librarymanagementsystem.dto.requestDto;

import com.accio.librarymanagementsystem.Enum.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequest {

    String title;

    int noofpage;

    Genre genre;

    double cost;

    int id;
}
