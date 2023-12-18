package com.web.onlineshop.exception.exceptionhandling;

import com.web.onlineshop.exception.OnlineShopNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class OnlineShopExceptionHandler {
    @ExceptionHandler({OnlineShopNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(OnlineShopNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }
}
