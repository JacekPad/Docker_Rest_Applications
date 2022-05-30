package com.inteca.exceptions;


public class FamilyNotFoundException extends RuntimeException {
    private String message;

    public FamilyNotFoundException() {
    }

    public FamilyNotFoundException(Long id) {
        this.message = ("Nie znaleziono rodziny o takim id: " + id);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
