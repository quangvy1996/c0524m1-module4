package com.example.libraby.repository;

import com.example.libraby.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    Optional<Borrowing> findByBorrowId(String borrowId);
}

