package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public class SchoolDoesNotExistException extends RuntimeException {

    private static final String MESSAGE = "School does not exist!";

    public SchoolDoesNotExistException() {
        super(MESSAGE);
    }
}
