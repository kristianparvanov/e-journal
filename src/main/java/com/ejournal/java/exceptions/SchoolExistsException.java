package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public class SchoolExistsException extends RuntimeException {

    private static final String MESSAGE = "School already exists";

    public SchoolExistsException() {
        super(MESSAGE);
    }
}
