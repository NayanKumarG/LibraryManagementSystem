package com.accio.librarymanagementsystem.controller;

import com.accio.librarymanagementsystem.Enum.Genre;
import com.accio.librarymanagementsystem.dto.requestDto.BookRequest;
import com.accio.librarymanagementsystem.dto.responseDto.BookResponse;
import com.accio.librarymanagementsystem.model.Book;
import com.accio.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody BookRequest bookRequest)
    {
        try {
            String bookResponse = bookService.addBook(bookRequest);
            return new ResponseEntity(bookResponse, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    //get book by genre and cost>x
    @GetMapping("/get-by-genre-cost")
    public ResponseEntity getBookByGenreAndCost(@RequestParam("genre")String genre , @RequestParam("cost")double cost)
    {
        List<BookResponse> bookResponseList = bookService.getBookByGenreAndCost(genre , cost);
        return new ResponseEntity(bookResponseList , HttpStatus.FOUND);

    }

    @GetMapping("/get-by-genre-cost-hql")
    public ResponseEntity getBookByGenreAndCostHql(@RequestParam("genre")Genre genre , @RequestParam("cost")double cost)
    {
        List<BookResponse> bookResponseList = bookService.getBookByGenreAndCostHql(genre , cost);
        return new ResponseEntity(bookResponseList , HttpStatus.FOUND);

    }
}
