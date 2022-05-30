package com.inteca.exceptions;

public class ExceptionResponse {
    private String error;
    private int status;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String error, int status) {
        this.error = error;
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
