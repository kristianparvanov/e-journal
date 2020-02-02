package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public class StudentDoesNotExistException extends RuntimeException {

    private static final String MESSAGE = "Student does not exist!";

    public StudentDoesNotExistException() {
        super(MESSAGE);
    }
}
