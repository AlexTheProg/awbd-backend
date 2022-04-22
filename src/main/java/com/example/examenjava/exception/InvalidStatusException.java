package com.example.examenjava.exception;

public class InvalidStatusException extends RuntimeException{
    public InvalidStatusException() {
        super("The status you are trying to add is not among the valid status types");
    }
}
