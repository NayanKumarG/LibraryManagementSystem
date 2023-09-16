package com.accio.librarymanagementsystem.service;

import com.accio.librarymanagementsystem.Enum.Genre;
import com.accio.librarymanagementsystem.dto.requestDto.BookRequest;
import com.accio.librarymanagementsystem.dto.responseDto.BookResponse;
import com.accio.librarymanagementsystem.model.Book;

import java.util.List;

public interface BookService {

    public String addBook(BookRequest bookRequest);

    List<BookResponse> getBookByGenreAndCost(String genre, double cost);

    List<BookResponse> getBookByGenreAndCostHql(Genre genre, double cost);
}
