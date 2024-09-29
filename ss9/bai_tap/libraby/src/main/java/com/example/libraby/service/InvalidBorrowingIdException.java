package com.example.libraby.service;

public class InvalidBorrowingIdException extends RuntimeException {
    public InvalidBorrowingIdException(String message) {
        super(message);
    }
}