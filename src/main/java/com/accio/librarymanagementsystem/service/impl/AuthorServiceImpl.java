package com.accio.librarymanagementsystem.service.impl;

import com.accio.librarymanagementsystem.dto.requestDto.AuthorRequest;
import com.accio.librarymanagementsystem.dto.responseDto.AuthorResponse;
import com.accio.librarymanagementsystem.dto.responseDto.BookResponse;
import com.accio.librarymanagementsystem.exception.AuthorNotFoundException;
import com.accio.librarymanagementsystem.model.Author;
import com.accio.librarymanagementsystem.model.Book;
import com.accio.librarymanagementsystem.repository.AuthorRepository;
import com.accio.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public AuthorResponse addAuthor(AuthorRequest authorRequest) {

        //map authordto to model
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setAge(authorRequest.getAge());
        author.setEmail(authorRequest.getEmail());
        //save the author in db
        Author savedAuthor = authorRepository.save(author);

        AuthorResponse authorResponse = new AuthorResponse();
        //map model to authorResponse dto
        authorResponse.setName(savedAuthor.getName());
        authorResponse.setEmail(savedAuthor.getEmail());

        return authorResponse;


    }

    public AuthorResponse getBooksByAuthorId(int id) {

        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isEmpty()) throw new AuthorNotFoundException("Author not found!!");

        Author author = optionalAuthor.get();
        AuthorResponse authorResponse = new AuthorResponse();

        //map model with dto
        authorResponse.setName(author.getName());
        authorResponse.setEmail(author.getEmail());

        List<Book> bookList = author.getBook();
        List<Book> responseList = new ArrayList<>();

        //add booklist to response
        for(Book book : bookList)
        {
            //map boot model with book dto
            BookResponse bookResponse = new BookResponse();
            bookResponse.setTitle(book.getTitle());
            bookResponse.setCost(book.getCost());
            bookResponse.setGenre(book.getGenre());
            authorResponse.getBook().add(bookResponse);
        }

        return authorResponse;
    }
}
