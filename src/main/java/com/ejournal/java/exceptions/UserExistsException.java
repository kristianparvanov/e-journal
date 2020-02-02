package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public class UserExistsException extends RuntimeException {

    private static final String MESSAGE = "User already exists";

    public UserExistsException() {
        super(MESSAGE);
    }
}
