package com.accio.librarymanagementsystem.dto.responseDto;

import com.accio.librarymanagementsystem.model.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorResponse {

    String name;

    String email;

    List<BookResponse> book = new ArrayList<>();
}
