package com.accio.librarymanagementsystem.controller;

import com.accio.librarymanagementsystem.dto.requestDto.AuthorRequest;
import com.accio.librarymanagementsystem.dto.responseDto.AuthorResponse;
import com.accio.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody AuthorRequest authorRequest)
    {
        AuthorResponse response = authorService.addAuthor(authorRequest);
        return new ResponseEntity(response , HttpStatus.CREATED);
    }

    @GetMapping("/getBooksByAuthorId")
    public ResponseEntity getBooksByAuthorId(@RequestParam("id")int id)
    {
        try
        {
            AuthorResponse authorResponse = authorService.getBooksByAuthorId(id);
            return new ResponseEntity(authorResponse , HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

}
