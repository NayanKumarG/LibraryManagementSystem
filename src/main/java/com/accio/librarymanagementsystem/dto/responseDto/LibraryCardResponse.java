package com.accio.librarymanagementsystem.dto.responseDto;

import com.accio.librarymanagementsystem.Enum.CardStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LibraryCardResponse {

    String cardno;

    CardStatus cardStatus;

    Date issuedDate;
}
