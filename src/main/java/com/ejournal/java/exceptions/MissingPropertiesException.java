package com.ejournal.java.exceptions;

import com.ejournal.java.utils.ExceptionMessages;

/**
 * Created by kristiyan.parvanov on 30.01.20 г.
 */
public class MissingPropertiesException extends RuntimeException {

    public MissingPropertiesException(final String entityName) {
        super(String.format(ExceptionMessages.MISSING_PROPERTIES_MESSAGE_PATTERN, entityName));
    }
}
