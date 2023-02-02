package com.example.movie_software.Exception;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
