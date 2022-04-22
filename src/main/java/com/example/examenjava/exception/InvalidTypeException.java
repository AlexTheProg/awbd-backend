package com.example.examenjava.exception;

public class InvalidTypeException extends RuntimeException{
    public InvalidTypeException() {
        super("The type of transaction you are trying to add is not valid");
    }
}
