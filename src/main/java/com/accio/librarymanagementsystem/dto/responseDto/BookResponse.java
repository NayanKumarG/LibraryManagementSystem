package com.accio.librarymanagementsystem.dto.responseDto;

import com.accio.librarymanagementsystem.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class BookResponse {

    String title;

    Genre genre;

    double cost;

    String authorName;

}
