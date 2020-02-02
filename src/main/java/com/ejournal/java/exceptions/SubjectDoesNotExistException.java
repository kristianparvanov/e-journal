package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public class SubjectDoesNotExistException extends RuntimeException {

    private static final String MESSAGE = "Subject does not exist!";

    public SubjectDoesNotExistException() {
        super(MESSAGE);
    }
}
