package com.accio.librarymanagementsystem.service;

import com.accio.librarymanagementsystem.exception.AuthorNotFoundException;
import com.accio.librarymanagementsystem.model.Author;
import com.accio.librarymanagementsystem.model.Book;
import com.accio.librarymanagementsystem.repository.AuthorRepository;
import com.accio.librarymanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    public String addBook(Book book) {

        Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
        if(authorOptional.isEmpty()) throw new AuthorNotFoundException("Author id not found!!");

        Author author = authorOptional.get();
        book.setAuthor(author);
        author.getBook().add(book);
        authorRepository.save(author);
        return "Book added successfully";

    }
}
