package com.example.libraby.service;

import com.example.libraby.model.Book;

import com.example.libraby.model.Borrowing;
import com.example.libraby.repository.BorrowingRepository;
import com.example.libraby.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private BorrowingRepository borrowingRepository;

    private Random random = new Random();

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public String borrowBook(String title) {
        Book book = bookRepository.findByTitle(title)
                .orElseThrow(() -> new BookUnavailableException("Book not found"));

        if (book.getQuantity() <= 0) {
            throw new BookUnavailableException("Book is unavailable for borrowing.");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        String borrowId = generateRandomBorrowId();
        borrowingRepository.save(new Borrowing(borrowId, title));

        return borrowId;
    }

    public void returnBook(String borrowId) {
        Borrowing borrowing = borrowingRepository.findByBorrowId(borrowId)
                .orElseThrow(() -> new InvalidBorrowingIdException("Invalid borrowing ID."));

        Book book = bookRepository.findByTitle(borrowing.getBookTitle())
                .orElseThrow(() -> new BookUnavailableException("Book not found"));

        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowingRepository.delete(borrowing);
    }

    private String generateRandomBorrowId() {
        return String.format("%05d", random.nextInt(99999));
    }
}

