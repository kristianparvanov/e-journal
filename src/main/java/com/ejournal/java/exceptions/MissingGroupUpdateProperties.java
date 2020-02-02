package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public class MissingGroupUpdateProperties extends RuntimeException {

    private static final String MESSAGE = "";

    public MissingGroupUpdateProperties() {
        super(MESSAGE);
    }
}
