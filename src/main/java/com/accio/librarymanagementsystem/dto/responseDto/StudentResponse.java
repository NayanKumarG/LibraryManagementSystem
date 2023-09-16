package com.accio.librarymanagementsystem.dto.responseDto;

import com.accio.librarymanagementsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponse {

    String name;

    String email;

    Gender gender;

    //it is a nested dto(dto inside dto)
    LibraryCardResponse libraryCardResponse;

}
