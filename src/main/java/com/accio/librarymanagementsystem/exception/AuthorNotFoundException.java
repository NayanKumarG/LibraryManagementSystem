package com.accio.librarymanagementsystem.exception;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String message)
    {
        super(message);
    }
}
