package com.store.bookstore.Controller;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptions  {
  
    @ExceptionHandler(value = FileNotFoundException.class)
    public ResponseEntity<BookExceptionResponse> handleException(FileNotFoundException e) {
        return new ResponseEntity<>(new BookExceptionResponse(e.getMessage(), 2000), HttpStatus.NOT_FOUND);

        }
        
}
