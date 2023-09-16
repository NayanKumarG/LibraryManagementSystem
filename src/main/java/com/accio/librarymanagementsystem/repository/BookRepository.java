package com.accio.librarymanagementsystem.repository;

import com.accio.librarymanagementsystem.Enum.Genre;
import com.accio.librarymanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    //using normal sql query (here we considering db tables and column attributes
    @Query(value = "select * from book where genre=:genre and cost>:cost" , nativeQuery = true)
    List<Book> getBookByGenreAndCost(String genre, double cost);

    //using HQL(hibernate query) : here we considering java objects and attributes
    @Query(value = "select b from Book b where b.genre=:genre and b.cost>:cost")
    List<Book> getBookByGenreAndCostHql(Genre genre, double cost);
}
