package com.inteca.exceptions;

public class ValidationFailException extends RuntimeException{

    public ValidationFailException() {
        super("Jedna lub wiele osób nie są w poprawnym przedziale wiekowym.");
    }
}
