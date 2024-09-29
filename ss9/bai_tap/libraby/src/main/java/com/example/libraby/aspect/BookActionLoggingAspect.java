package com.example.libraby.aspect;

import com.example.libraby.service.BookUnavailableException;
import com.example.libraby.service.InvalidBorrowingIdException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




@Aspect
@Component
public class BookActionLoggingAspect {

    private static final Logger logger =    LoggerFactory.getLogger(BookActionLoggingAspect.class);
    private int visitorCount = 0;

    @Before("execution(* com.example.libraby.controller.BookController.*(..))")
    public void logVisitorCount() {
        visitorCount++;
        logger.info("Visitor count: {}");
    }

    @AfterReturning(value = "execution(* com.example.libraby.service.BookService.borrowBook(..))", returning = "borrowId")
    public void logBorrowAction(JoinPoint joinPoint, String borrowId) {
        String title = (String) joinPoint.getArgs()[0];
        logger.info("Book borrowed: {}, Borrow ID: {}, Time: {}");
    }

    @AfterReturning("execution(* com.example.libraby.service.BookService.returnBook(..))")
    public void logReturnAction(JoinPoint joinPoint) {
        String borrowId = (String) joinPoint.getArgs()[0];
        logger.info("Book returned with borrow ID: {} at {}");
    }

    @AfterThrowing(pointcut = "execution(* com.example.libraby.service.BookService.borrowBook(..))", throwing = "ex")
    public void logBookUnavailableException(JoinPoint joinPoint, BookUnavailableException ex) {
        String title = (String) joinPoint.getArgs()[0];
        logger.error("Book unavailable for borrowing: {}. Error: {}", title, ex.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* com.example.libraby.service.BookService.returnBook(..))", throwing = "ex")
    public void logInvalidBorrowingIdException(JoinPoint joinPoint, InvalidBorrowingIdException ex) {
        String borrowId = (String) joinPoint.getArgs()[0];
        logger.error("Invalid borrow ID: {}. Error: {}", borrowId, ex.getMessage());
    }
}

