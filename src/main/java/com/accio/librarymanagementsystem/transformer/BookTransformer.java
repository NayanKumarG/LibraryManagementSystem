package com.accio.librarymanagementsystem.transformer;

import com.accio.librarymanagementsystem.dto.requestDto.BookRequest;
import com.accio.librarymanagementsystem.dto.responseDto.BookResponse;
import com.accio.librarymanagementsystem.model.Book;

public class BookTransformer {

    public static Book BookRequestToBook(BookRequest bookRequest)
    {
        return Book.builder()
                .genre(bookRequest.getGenre())
                .cost(bookRequest.getCost())
                .title(bookRequest.getTitle())
                .noofpage(bookRequest.getNoofpage())
                .build();
    }

    public static BookResponse BookToBookResponse(Book book)
    {
        return BookResponse.builder()
                .authorName(book.getAuthor().getName())
                .genre(book.getGenre())
                .title(book.getTitle())
                .cost(book.getCost())
                .build();

    }
}
