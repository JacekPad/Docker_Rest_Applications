package com.inteca.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class ExceptionsAdvice {

    //Responsible for giving an 404 status and a message set in the exception class when there is no family at given id.
    @ResponseBody
    @ExceptionHandler(FamilyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse familyNotFoundHandler(FamilyNotFoundException exc) {
        return new ExceptionResponse(exc.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    //Responsible for giving a BAD REQUEST status and a message set in the exception class when validation fails.
    @ResponseBody
    @ExceptionHandler(ValidationFailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse validationFailHandler(ValidationFailException exc) {
        return new ExceptionResponse(exc.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
