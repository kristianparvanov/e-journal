package com.ejournal.java.services;

import java.util.List;

import com.ejournal.java.entities.Parent;

/**
 * Created by kristiyan.parvanov on 29.03.20 г.
 */
public interface ParentStudentService {

    List<Parent> getParents(List<String> ids);
}
