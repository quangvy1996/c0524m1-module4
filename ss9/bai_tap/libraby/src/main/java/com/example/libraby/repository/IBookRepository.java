package com.example.libraby.repository;

import com.example.libraby.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
