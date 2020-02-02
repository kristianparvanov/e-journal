package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public class MissingSubjectUpdateProperties extends RuntimeException {

    private static final String MESSAGE = "Missing subject properties for update";

    public MissingSubjectUpdateProperties() {
        super(MESSAGE);
    }
}
