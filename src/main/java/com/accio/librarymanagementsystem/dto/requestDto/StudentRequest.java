package com.accio.librarymanagementsystem.dto.requestDto;
import com.accio.librarymanagementsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequest {

    String name;

    int age;

    String email;

    Gender gender;



}
