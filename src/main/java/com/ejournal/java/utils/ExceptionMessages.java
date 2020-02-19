package com.ejournal.java.utils;

/**
 * Created by kristiyan.parvanov on 19.02.20 г.
 */
public interface ExceptionMessages {

    String ENTITY_EXISTS_MESSAGE_PATTERN = "%s already exists";
    String ENTITY_NOT_FOUND_MESSAGE_PATTERN = "%s with id: '%s' doesn't exist";
    String MISSING_PROPERTIES_MESSAGE_PATTERN = "Missing %s properties for update";
    String USER_ROLE_NOT_SET = "User role not set";
}
