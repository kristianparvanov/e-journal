package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public class GroupDoesNotExistException extends RuntimeException {

    private static final String MESSAGE = "Group does not exist!";

    public GroupDoesNotExistException() {
        super(MESSAGE);
    }
}
