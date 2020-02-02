package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public class MissingSchoolUpdateProperties extends RuntimeException {

    private static final String MESSAGE = "Missing school properties for update";

    public MissingSchoolUpdateProperties() {
        super(MESSAGE);
    }
}
