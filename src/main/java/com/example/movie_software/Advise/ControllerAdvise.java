package com.example.movie_software.Advise;


import com.example.movie_software.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerAdvise {
    // Our Exception
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message =e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    // Server Validation Exception
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message= e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    // SQL Constraint Exception
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String message =e.getMessage();
        return ResponseEntity.status(400).body(message);
    }


    // Method not allowed Exception
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message =e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

}
