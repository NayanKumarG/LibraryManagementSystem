package com.accio.librarymanagementsystem.service.impl;

import com.accio.librarymanagementsystem.Enum.Genre;
import com.accio.librarymanagementsystem.dto.requestDto.BookRequest;
import com.accio.librarymanagementsystem.dto.responseDto.BookResponse;
import com.accio.librarymanagementsystem.exception.AuthorNotFoundException;
import com.accio.librarymanagementsystem.model.Author;
import com.accio.librarymanagementsystem.model.Book;
import com.accio.librarymanagementsystem.repository.AuthorRepository;
import com.accio.librarymanagementsystem.repository.BookRepository;
import com.accio.librarymanagementsystem.service.BookService;
import com.accio.librarymanagementsystem.transformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    JavaMailSender javaMailSender;
    public  String addBook(BookRequest bookRequest) {

        Optional<Author> authorOptional = authorRepository.findById(bookRequest.getId());
        if(authorOptional.isEmpty()) throw new AuthorNotFoundException("Author id not found!!");

        Author author = authorOptional.get();
        Book book = BookTransformer.BookRequestToBook(bookRequest);
        book.setAuthor(author);
        author.getBook().add(book);
        authorRepository.save(author);
        String text = "Hi! " +author.getName()+" You added the book "+book.getTitle()+"Thank You!!!";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("aneeshgunditharu@gmail.com");
        simpleMailMessage.setTo("nayangunditharu@gmail.com");
        simpleMailMessage.setSubject("Congrats!! Book added");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
        return "Book added successfully";

    }


    //using sql query (genre is string in table)
    public List<BookResponse> getBookByGenreAndCost(String genre, double cost) {
        List<Book> bookList = bookRepository.getBookByGenreAndCost(genre , cost);
        List<BookResponse> bookResponseList = new ArrayList<>();
        for(Book book : bookList)
        {
            bookResponseList.add(BookTransformer.BookToBookResponse(book));
        }
        return bookResponseList;
    }

    //using hql query (genre is Genre in model)
    public List<BookResponse> getBookByGenreAndCostHql(Genre genre, double cost) {
        List<Book> bookList = bookRepository.getBookByGenreAndCostHql(genre , cost);
        List<BookResponse> bookResponseList = new ArrayList<>();
        for(Book book : bookList)
        {
            bookResponseList.add(BookTransformer.BookToBookResponse(book));
        }
        return bookResponseList;
    }
}
