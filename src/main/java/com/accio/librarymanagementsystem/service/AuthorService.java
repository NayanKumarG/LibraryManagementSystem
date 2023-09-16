package com.accio.librarymanagementsystem.service;

import com.accio.librarymanagementsystem.dto.requestDto.AuthorRequest;
import com.accio.librarymanagementsystem.dto.responseDto.AuthorResponse;

public interface AuthorService {

    public AuthorResponse addAuthor(AuthorRequest authorRequest);

    public AuthorResponse getBooksByAuthorId(int id);
}
