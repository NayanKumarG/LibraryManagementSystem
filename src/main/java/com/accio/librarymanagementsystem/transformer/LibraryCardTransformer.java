package com.accio.librarymanagementsystem.transformer;

import com.accio.librarymanagementsystem.Enum.CardStatus;
import com.accio.librarymanagementsystem.dto.responseDto.LibraryCardResponse;
import com.accio.librarymanagementsystem.model.LibraryCard;
import com.accio.librarymanagementsystem.model.Student;

import java.util.UUID;

public class LibraryCardTransformer {

    public static LibraryCard prepareLibraryCard()
    {
        return LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .build();
    }
    public static LibraryCardResponse StudentToLibraryCardResponse(Student student)
    {
        return LibraryCardResponse.builder()
                .cardStatus(student.getLibraryCard().getCardStatus())
                .cardno(student.getLibraryCard().getCardNo())
                .issuedDate(student.getLibraryCard().getIssueDate())
                .build();
    }
}
