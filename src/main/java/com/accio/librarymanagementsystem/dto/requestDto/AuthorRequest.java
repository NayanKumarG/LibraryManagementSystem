package com.accio.librarymanagementsystem.dto.requestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorRequest {

    String name;

    int age;

    String email;
}
