package com.accio.librarymanagementsystem.repository;

import com.accio.librarymanagementsystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author , Integer> {
}
